package org.invoice.exception;

/**
 * Created by Administrator on 2016/9/6.
 */
public class InvoiceConnectionException extends InvoiceException{
    public InvoiceConnectionException(String message) {
        super(message);
    }

    public InvoiceConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

}
