package org.invoice.dto;

import org.invoice.entity.Invoice;
import org.invoice.enums.InvoiceStatEnum;

/**
 * Created by Administrator on 2016/9/6.
 */
public class ComboExecution {

    private long invoiceId;

    //执行结果状态
    private int state;

    //状态表示
    private String stateInfo;

    private Invoice invoice;

    public ComboExecution(long invoiceId, InvoiceStatEnum statEnum, Invoice invoice) {
        this.invoiceId = invoiceId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStateInfo();
        this.invoice = invoice;
    }

    public long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public String toString() {
        return "ComboExecution{" +
                "invoiceId=" + invoiceId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", invoice=" + invoice +
                '}';
    }
}
