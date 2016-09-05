package org.invoice.enums;

/**
 * Created by Administrator on 2016/9/4.
 */
public enum InvoiceStatEnum {

    CREATED(2,"合成电子发票成功"),
    SUCCESS(1,"打印成功"),
    END(0,"打印有效期结束"),
    REPEAT_PRINT(-1,"重复打印"),
    INNER_ERROR(-2,"系统异常"),
    DATA_REWRITE(-3,"数据篡改");

    private int state;

    private String stateInfo;

    InvoiceStatEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static InvoiceStatEnum stateOf(int index) {
        for(InvoiceStatEnum state:values()) {
            if(index == state.getState()) {
                return state;
            }
        }

        return null;
    }
}
