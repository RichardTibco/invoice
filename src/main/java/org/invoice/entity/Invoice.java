package org.invoice.entity;

import java.util.Date;

/**
 * Created by Administrator on 2016/9/4.
 */
public class Invoice{

    private long invoiceId;

    private String name;

    private String code;

    private String number;

    private int counter;

    private Date startTime;

    private Date endTime;

    private Date issueInvoiceTime;

    private Date createTime;

    public long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getIssueInvoiceTime() {
        return issueInvoiceTime;
    }

    public void setIssueInvoiceTime(Date issueInvoiceTime) {
        this.issueInvoiceTime = issueInvoiceTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", number='" + number + '\'' +
                ", counter=" + counter +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", issueInvoiceTime=" + issueInvoiceTime +
                ", createTime=" + createTime +
                '}';
    }
}
