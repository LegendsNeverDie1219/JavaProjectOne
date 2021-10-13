package com.huawei.nce.javabase.day20;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/7 21:13
 */
public class MyString {
    private final char value[];

//    public MyString() {
//        this.value = "".value;
//    }

    private int hash; // Default to 0

    public MyString(MyString original) {
        this.value = original.value;
        this.hash = original.hash;
    }

    public void modifyValue() {
        // Cannot assign a value to final variable 'value'
        //value = new char[5];

        for (int i = 0; i < value.length; i++) {
            value[i] = 0;
        }
    }
}
