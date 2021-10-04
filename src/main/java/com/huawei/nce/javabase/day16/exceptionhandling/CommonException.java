package com.huawei.nce.javabase.day16.exceptionhandling;

import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/2 16:32
 */
public class CommonException {
    @Test
    public void test1() {
        NullRef nullRef = new NullRef();
        nullRef = null;
        // java.lang.NullPointerException
        System.out.println(nullRef.i);
    }

    @Test
    public void test2() {
        String[] friends = new String[] {"aa","bb"};
        for (int i = 0; i <= friends.length; i++) {
            //java.lang.ArrayIndexOutOfBoundsException:
            System.out.println(friends[i]);
        }
    }
    //
    @Test
    public void test3() {
        int x =1;
        int y =0;
        // java.lang.ArithmeticException: / by zero
        System.out.println(x/y);
    }
    @Test
    public void test4() {
        Object obj = new Date();
        // java.lang.ClassCastException: java.util.Date cannot be cast to java.lang.String
        String string = (String)obj;
        System.out.println(string);
    }
}

class NullRef {
    int i = 1;
}