package org.invoice.entity;

import java.util.Date;

/**
 * Created by Administrator on 2016/9/4.
 */
public class Invoice{

    private long invoiceId;

    private long pid;

    private String name;

    private String code;

    private String number;

    private int counter;

    private short state;

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

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
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

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
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

    public Invoice() {
    }

    public Invoice(long invoiceId, long pid, String name, String code, String number, int counter, short state, Date startTime, Date endTime, Date issueInvoiceTime, Date createTime) {
        this.invoiceId = invoiceId;
        this.pid = pid;
        this.name = name;
        this.code = code;
        this.number = number;
        this.counter = counter;
        this.state = state;
        this.startTime = startTime;
        this.endTime = endTime;
        this.issueInvoiceTime = issueInvoiceTime;
        this.createTime = createTime;
    }

    public Invoice(String name, int counter, short state, Date startTime, Date endTime) {
        this.name = name;
        this.counter = counter;
        this.state = state;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", number='" + number + '\'' +
                ", counter=" + counter +
                ", state=" + state +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", issueInvoiceTime=" + issueInvoiceTime +
                ", createTime=" + createTime +
                '}';
    }
}
