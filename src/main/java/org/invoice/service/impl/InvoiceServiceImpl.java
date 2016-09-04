package org.invoice.service.impl;

import org.invoice.dao.InvoiceDao;
import org.invoice.dao.SuccessPrintedDao;
import org.invoice.dto.Exposer;
import org.invoice.dto.InvoicePrintExecution;
import org.invoice.entity.Invoice;
import org.invoice.entity.SuccessPrinted;
import org.invoice.enums.InvoiceStatEnum;
import org.invoice.exception.InvoiceCloseException;
import org.invoice.exception.InvoiceException;
import org.invoice.exception.RepeatPrintException;
import org.invoice.service.InvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/9/4.
 */
@Service
public class InvoiceServiceImpl implements InvoiceService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    InvoiceDao invoiceDao;

    @Autowired
    SuccessPrintedDao successPrintedDao;
    //md5盐值字符串
    private final String salt = "iooiret98vcnbjnol32498095445%^*$)#oiogfd";

    @Override
    public List<Invoice> getInvoiceList() {
        return invoiceDao.queryAll(0,4);
    }

    @Override
    public Invoice getById(long id) {
        return invoiceDao.queryById(id);
    }

    @Override
    public Exposer exportInvoicePrintUrl(long invoiceId) {

        Invoice invoice = invoiceDao.queryById(invoiceId);
        if (invoice == null) {
            return new Exposer(false, invoiceId);
        }

        Date startTime = invoice.getStartTime();
        Date endTime = invoice.getEndTime();
        //系统当前时间
        Date nowTime = new Date();
        if (nowTime.getTime() < startTime.getTime()
                || nowTime.getTime() > endTime.getTime()) {
            return new Exposer(false, invoiceId, nowTime.getTime(), startTime.getTime(),
                    endTime.getTime());
        }
        //转化特定字符串的过程，不可逆
        String md5 = getMD5(invoiceId);
        return new Exposer(true, md5, invoiceId);
    }

    private String getMD5(long invoiceId) {
        String base = invoiceId + "/" + salt;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    @Override
    @Transactional
    /**
     */
    public InvoicePrintExecution executePrintInvoice(long invoiceId, long userPhone, String md5)
            throws InvoiceException, RepeatPrintException, InvoiceCloseException {
        if (md5 == null || !md5.equals(getMD5(invoiceId))) {
            throw new InvoiceException("print invoice data rewrite");
        }
        //执行电子发票打印逻辑:减电子发票库存 + 记录打印行为
        Date nowTime = new Date();

        try {
            //记录购买行为
            int insertCount = successPrintedDao.insertSuccessPrinted(invoiceId, userPhone);
            //唯一:invoiceId,userPhone
            if (insertCount <= 0) {
                //重复打印
                throw new RepeatPrintException("invoice print repeated");
            } else {
                //减库存,热点商品竞争
                int updateCount = invoiceDao.printInvoice(invoiceId, nowTime);
                if (updateCount <= 0) {
                    //没有更新到记录，打印发票有效期结束,rollback
                    throw new InvoiceCloseException("invoice print is closed");
                } else {
                    //打印成功 commit
                    SuccessPrinted successPrinted = successPrintedDao.queryByIdWithInvoice(invoiceId, userPhone);
                    return new InvoicePrintExecution(invoiceId, InvoiceStatEnum.SUCCESS, successPrinted);
                }
            }
        } catch (InvoiceCloseException e1) {
            throw e1;
        } catch (RepeatPrintException e2) {
            throw e2;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            //所有编译期异常 转化为运行期异常
            throw new InvoiceException("Invoice print inner error:" + e.getMessage());
        }
    }
}
