package com.huawei.nce.javabase.day28.reflection;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/11/13 17:20
 */
public interface MyInterface {
    /**
     * 信息
     */
    public abstract  void info();


    public default  void show() {
        @SuppressWarnings("unchecked")
        Person person = (Person) new Object();
    }

}
