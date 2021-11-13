package com.huawei.nce.javabase.day28.proxy;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/11/13 21:56
 */
public interface Human {
    /**
     * getBelief
     * @return String
     */
    public abstract  String getBelief();

    /**
     * eat
     * @param food food
     */
    public abstract void eat(String food);
}
