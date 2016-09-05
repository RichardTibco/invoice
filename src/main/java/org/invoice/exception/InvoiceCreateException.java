package org.invoice.exception;

/**
 * Created by Administrator on 2016/9/6.
 */
public class InvoiceCreateException extends InvoiceException {
    public InvoiceCreateException(String message) {
        super(message);
    }

    public InvoiceCreateException(String message, Throwable cause) {
        super(message, cause);
    }
}
