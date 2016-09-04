package org.invoice.exception;

/**
 * 秒杀关闭异常
 * Created by zhangyijun on 15/10/16.
 */
public class InvoiceCloseException extends InvoiceException {

    public InvoiceCloseException(String message) {
        super(message);
    }

    public InvoiceCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
