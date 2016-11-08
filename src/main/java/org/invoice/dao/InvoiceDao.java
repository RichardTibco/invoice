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
     * @param invoiceId
     * @return
     */
    Invoice queryById(long invoiceId);

    List<Invoice> queryByIds(@Param("ids") List<Long> ids);

    /**
     * 根据偏移量查询电子发票列表
     * @param offet
     * @param limit
     * @return
     */
    List<Invoice> queryAll(@Param("offset") int offet, @Param("limit") int limit);

    /**
     * 创建合成后的发票
     * @param name
     * @param startTime
     * @param endTime
     * @return
     */
//    int insertInvoice(@Param("name") String name, @Param("counter") int counter, @Param("state") short state,
//                      @Param("startTime") Date startTime,@Param("endTime") Date endTime);
    int insertInvoice(@Param("invoice") Invoice invoice);

    int setupConnection(@Param("pid") long pid, @Param("ids") List<Long> ids);
}
