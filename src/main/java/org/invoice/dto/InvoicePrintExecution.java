package org.invoice.dto;

import org.invoice.entity.SuccessPrinted;
import org.invoice.enums.InvoiceStatEnum;

/**
 * 封装打印电子账单执行后结果
 *
 */
public class InvoicePrintExecution {

    private long invoiceId;

    //执行结果状态
    private int state;

    //状态表示
    private String stateInfo;

    //成功对象
    private SuccessPrinted successPrinted;

    @Override
    public String toString() {
        return "PrintInvoiceExecution{" +
                "invoiceId=" + invoiceId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", successPrinted=" + successPrinted +
                '}';
    }

    public InvoicePrintExecution(long invoiceId, InvoiceStatEnum statEnum, SuccessPrinted successPrinted) {
        this.invoiceId = invoiceId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStateInfo();
        this.successPrinted = successPrinted;
    }

    public InvoicePrintExecution(long invoiceId, InvoiceStatEnum statEnum) {
        this.invoiceId = invoiceId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStateInfo();
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

    public SuccessPrinted getSuccessPrinted() {
        return successPrinted;
    }

    public void setSuccessPrinted(SuccessPrinted successPrinted) {
        this.successPrinted = successPrinted;
    }
}
