package com.huawei.nce.pojo;

/**
 * TODO
 *
 * @author Administrator
 * @date 2020/9/27 22:29
 */
public enum StudentEnum {
    HUGE(1),TANGYAN(2),HUOJIANHUA(3),YANGMI(4);
    private int value;

    StudentEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


}
