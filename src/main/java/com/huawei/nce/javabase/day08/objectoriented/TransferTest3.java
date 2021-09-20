package com.huawei.nce.javabase.day08.objectoriented;

import java.io.PrintStream;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/20 9:54
 */
public class TransferTest3 {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        // 需要在method方法被调用之后,仅打印出 a =100, b =200
        method(a,b);
        System.out.println("a = " + a);
        System.out.println("b = " + b);

    }
    // 方法二:
    private static void method(int a, int b) {
        PrintStream printStream = new PrintStream(System.out) {
            @Override
            public void println(String x) {
                if ("a = 10".equals(x)) {
                    x = "a = 100";
                } else if ("b = 10".equals(x)) {
                    x = "b = 200";
                }

                super.println(x);
            }
        };
        System.setOut(printStream);
    }
    // 方法一:
//    private static void method(int a, int b) {
//        a *= 10 ;
//        b *= 20;
//        System.out.println("a = " + a);
//        System.out.println("b = " + b);
//        // 终止java虚拟机
//        System.exit(0);
//    }
}
