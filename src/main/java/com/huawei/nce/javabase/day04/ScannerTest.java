package com.huawei.nce.javabase.day04;
// 1.导包

import java.util.Scanner;

/**
 * ScannerTest
 *
 * @author Administrator
 * @date 2021/9/5 22:31
 */
public class ScannerTest {
    public static void main(String[] args) {
        // 1.测试canner中nextLine()方法和next()方法的区别
        // testNextAndNextLine();
        // 2.testOther
        //testOther();
        testNextAndNextLine2();
    }

    private static void testOther() {
        // 2.实例化一个scanner实例
        Scanner scanner = new Scanner(System.in);
        // 3.调用实例对应的方法 来获取指定类型的变量
        System.out.println("请输入你的姓名: " );
        String name = scanner.nextLine();
        System.out.println(name);

        System.out.println("请输入你的性别(男/女)");
        String gender = scanner.nextLine();
        char genderChar = gender.charAt(0);
        System.out.println(genderChar);

        // 如果输入的信息不是数值类型的,则会报inputMisMatchException的异常.
        // Exception in thread "main" java.util.InputMismatchException
        System.out.println("请输入的你的芳龄");
        int age = scanner.nextInt();
        System.out.println(age);

        System.out.println("请输入你的体重");
        double weight = scanner.nextDouble();
        System.out.println(weight);

        System.out.println("你是否相中了我?(true/fasle)");
        boolean isLove = scanner.nextBoolean();
        System.out.println(isLove);

        

    }

    private static void testNextAndNextLine() {
        Scanner scanner = new Scanner(System.in);
         /*
         scanner.next() 和scanner.nextLine() 都是用来接收键盘录入的字符串信息的
         scanner是一个扫描器,它会把键盘录入的信息先暂时存入到缓存中,当遇到读取结束的标志符后
         会停止读取.
         scanner.next()对应的读取结束的标志符是  空格, tab,回车
         scanner.nextLine() 对应的读取结束的标志符是  回车.
         */
        System.out.println("请输入字符串（next）：");
        String str = scanner.next();
        System.out.println(str);

        System.out.println("请输入字符串（nextLine）：");
        String str1 = scanner.nextLine();
        System.out.println(str1);
    }
    
    public static void testNextAndNextLine2() {
        Scanner input = new Scanner(System.in);

        System.out.println("请输入字符串（next1）：");
        String str1 = input.next();
        System.out.println(str1);

        System.out.println("请输入字符串（nextLine）：");//曹老板很有钱
        String str = input.nextLine();
        System.out.println(str);



        System.out.println("请输入字符串（next2）：");
        String str2 = input.next();
        System.out.println(str2);


    }
}