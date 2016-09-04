package org.invoice.dao;

import org.apache.ibatis.annotations.Param;
import org.invoice.entity.SuccessPrinted;

/**
 * Created by Administrator on 2016/9/4.
 */
public interface SuccessPrintedDao {

    /**
     * 插入打印明细，可过滤重复
     * @param invoiceId
     * @param userPhone
     * @return
     */
    int insertSuccessPrinted(@Param("invoiceId") long invoiceId , @Param("userPhone") long userPhone);


    SuccessPrinted queryByIdWithInvoice(@Param("invoiceId") long invoiceId, @Param("userPhone") long userPhone);
}
