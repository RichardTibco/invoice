package org.invoice.service;

import org.invoice.dto.ComboExecution;
import org.invoice.dto.Exposer;
import org.invoice.dto.InvoicePrintExecution;
import org.invoice.entity.Invoice;
import org.invoice.exception.InvoiceCloseException;
import org.invoice.exception.InvoiceException;
import org.invoice.exception.RepeatPrintException;

import java.util.List;

/**
 * Created by Administrator on 2016/9/4.
 */
public interface InvoiceService {
    /**
     * 查询所有电子发票记录
     * @return
     */
    List<Invoice> getInvoiceList();

    /**
     * 查询单个电子发票记录
     * @return
     */
    Invoice getById(long id);

    /**
     * 打印发票有效期开启输出打印接口地址,
     * 否则输出系统时间和秒杀时间
     * @param invoiceId
     * @return
     */
    Exposer exportInvoicePrintUrl(long invoiceId);

    /**
     * 执行打印电子发票动作
     * @param invoiceId
     * @param userPhone
     * @param md5
     * @return
     */
    InvoicePrintExecution executePrintInvoice(long invoiceId, long userPhone, String md5) throws InvoiceException, RepeatPrintException, InvoiceCloseException;

    /**
     * 执行合并电子发票动作
     * @param ids
     * @return
     */
    ComboExecution ComboInvoice(List<Long> ids);
}
