package org.invoice.dao;

import org.apache.ibatis.annotations.Param;
import org.invoice.entity.Invoice;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/9/4.
 */
public interface InvoiceDao {

    /**
     * 打印发票
     * @param invoiceId
     * @return
     */
    int printInvoice(@Param("invoiceId") long invoiceId,@Param("printTime") Date printTime);

    /**
     * 根据id查询电子发票
     * @param invoiceIde
     * @return
     */
    Invoice queryById(long invoiceIde);


    /**
     * 根据偏移量查询电子发票列表
     * @param offet
     * @param limit
     * @return
     */
    List<Invoice> queryAll(@Param("offset") int offet, @Param("limit") int limit);
}
