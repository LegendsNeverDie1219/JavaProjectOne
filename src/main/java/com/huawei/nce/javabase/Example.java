package com.huawei.nce.javabase;

import org.junit.jupiter.api.Test;

/**
 * TODO
 *
 * @author Administrator
 * @date 2022/9/9 8:05
 */
public class Example {
    @Test
    public void test() {
        char[] arr = new char[]{'a', 'b', 'c'};
        System.out.println(arr);// abc
        int[] arr1 = new int[]{1, 2, 3};
        System.out.println(arr1);//[I@69a3d1d
        double[] arr2 = new double[]{1.1, 2.2, 3.3};
        System.out.println(arr2);//[D@86be70a
    }

    @Test
    public void test2() {
        Object o1 = true ? new Integer(1) : new Double(2.0);
        System.out.println(o1);//
    }

    @Test
    public void test3() {
        Object o2;
        if (true)
            o2 = new Integer(1);
        else
            o2 = new Double(2.0);
        System.out.println(o2);//
    }

    @Test
    public void test4() {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j); // false
        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n);// true
        Integer x = 128;
        Integer y = 128;
        // -128~127
        System.out.println(x == y);// false
    }

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "] = " + args[i]);
        }
    }
}
