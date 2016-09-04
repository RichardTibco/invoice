package org.invoice.entity;

import java.util.Date;

/**
 * Created by Administrator on 2016/9/4.
 */
public class SuccessPrinted {

    private long invoiceId;

    private long userPhone;

    private short state;

    private Date createTime;

    private Invoice invoice;

    public long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public String toString() {
        return "SuccessPrinted{" +
                "invoiceId=" + invoiceId +
                ", userPhone=" + userPhone +
                ", state=" + state +
                ", createTime=" + createTime +
                ", invoice=" + invoice +
                '}';
    }
}
