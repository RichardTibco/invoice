package org.invoice.exception;

/**
 * 秒杀相关业务异常
 * Created by zhangyijun on 15/10/16.
 */
public class InvoiceException extends RuntimeException {

    public InvoiceException(String message) {
        super(message);
    }

    public InvoiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
