package org.invoice.dto;

/**
 * 暴露打印借口地址DTO
 */
public class Exposer {

    //是否开启打印功能
    private boolean exposed;

    //一种加密措施
    private String md5;

    //id
    private long invoiceId;

    //系统当前时间(毫秒)
    private long now;

    //开启时间
    private long start;

    //结束时间
    private long end;

    @Override
    public String toString() {
        return "Exposer{" +
                "exposed=" + exposed +
                ", md5='" + md5 + '\'' +
                ", invoiceId=" + invoiceId +
                ", now=" + now +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    public Exposer(boolean exposed, String md5, long invoiceId) {
        this.exposed = exposed;
        this.md5 = md5;
        this.invoiceId = invoiceId;
    }

    public Exposer(boolean exposed, long invoiceId, long now, long start, long end) {
        this.exposed = exposed;
        this.invoiceId = invoiceId;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public Exposer(boolean exposed, long invoiceId) {
        this.exposed = exposed;
        this.invoiceId = invoiceId;
    }

    public boolean isExposed() {
        return exposed;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }
}
