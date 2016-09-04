package org.invoice.exception;

/**
 * 重复秒杀异常(运行期异常)
 * Created by zhangyijun on 15/10/16.
 */
public class RepeatPrintException extends InvoiceException {

    public RepeatPrintException(String message) {
        super(message);
    }

    public RepeatPrintException(String message, Throwable cause) {
        super(message, cause);
    }
}
