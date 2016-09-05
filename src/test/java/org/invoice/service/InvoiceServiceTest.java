package org.invoice.service;

import org.invoice.dto.ComboExecution;
import org.invoice.dto.Exposer;
import org.invoice.entity.Invoice;
import org.invoice.exception.InvoiceCloseException;
import org.invoice.exception.RepeatPrintException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/9/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class InvoiceServiceTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    InvoiceService invoiceService;
    @Test
    public void getInvoiceList() throws Exception {
        List<Invoice> list = invoiceService.getInvoiceList();
        logger.info("list={}", list);
        /**
         * Invoice{invoiceId=1000, name='小米通讯技术有限公司', code='01110012542', number='0211854', counter=0,
         * startTime=Sun Sep 04 00:00:00 GMT+08:00 2016,
         * endTime=Wed Sep 07 00:00:00 GMT+08:00 2016,
         * issueInvoiceTime=Sun Nov 01 00:00:00 GMT+08:00 2015,
         * createTime=Sun Sep 04 12:48:52 GMT+08:00 2016},
         *
         * Invoice{invoiceId=1001, name='苹果技术有限公司', code='01110012566', number='0214324', counter=1,
         * startTime=Sun Sep 04 00:00:00 GMT+08:00 2016,
         * endTime=Wed Sep 07 00:00:00 GMT+08:00 2016,
         * issueInvoiceTime=Sun Nov 01 00:00:00 GMT+08:00 2015,
         * createTime=Sun Sep 04 12:48:52 GMT+08:00 2016},
         *
         * Invoice{invoiceId=1002, name='华为通讯技术有限公司', code='01110046542', number='0214374', counter=1,
         * startTime=Sun Sep 04 00:00:00 GMT+08:00 2016,
         * endTime=Wed Sep 07 00:00:00 GMT+08:00 2016,
         * issueInvoiceTime=Sun Nov 01 00:00:00 GMT+08:00 2015,
         * createTime=Sun Sep 04 12:48:52 GMT+08:00 2016},
         *
         * Invoice{invoiceId=1003, name='中兴通讯公司', code='01110012982', number='0212354', counter=1,
         * startTime=Sun Sep 04 00:00:00 GMT+08:00 2016,
         * endTime=Wed Sep 07 00:00:00 GMT+08:00 2016,
         * issueInvoiceTime=Sun Nov 01 00:00:00 GMT+08:00 2015,
         * createTime=Sun Sep 04 12:48:52 GMT+08:00 2016}]

         */
    }

    @Test
    public void getById() throws Exception {
        long id = 1001;
        Invoice invoice = invoiceService.getById(id);
        logger.info("invoice={}",invoice);
    }

    @Test
    public void exportInvoiceLogic() throws Exception {
        long id = 1001;
        Exposer exposer = invoiceService.exportInvoicePrintUrl(id);
        if(exposer.isExposed()){
            logger.info("exposer={}",exposer);
            long phone = 13502171127L;
            String md5 = exposer.getMd5();
            try {
                invoiceService.executePrintInvoice(id,phone,md5);
            }catch (InvoiceCloseException e) {
                logger.error(e.getMessage());
            }catch (RepeatPrintException e) {
                logger.error(e.getMessage());
            }
        } else {
            logger.warn("exposer={}",exposer);
        }
    }

    @Test
    public void testComboInvoice() throws Exception {
        Long[] ll = {1000L, 1001L, 1002L};
        List<Long> invoices = Arrays.asList(ll);
        ComboExecution comboExecution = invoiceService.ComboInvoice(invoices);
        logger.info("new Invoice is {}", comboExecution.getInvoice());
    }

}