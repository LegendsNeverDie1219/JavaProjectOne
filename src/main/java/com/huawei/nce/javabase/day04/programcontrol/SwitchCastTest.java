package com.huawei.nce.javabase.day04.programcontrol;

import java.util.Scanner;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/6 21:44
 */
public class SwitchCastTest {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        // testSwitchCaseOne();
        // testSwitchCaseTwo();
        testSwitchCaseThree();

    }

    /**
     * 根据指定的月份,打印该月份属于的季节
     */
    private static void testSwitchCaseThree() {
        System.out.println("请输入指定的月份");
        int month = SCANNER.nextInt();
        switch (month) {
            case (3):
            case 4:
            case 5:
                System.out.println("春暖花开");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏日炎炎");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋高气爽");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println("冬雪皑皑");
                break;
            default:
                System.out.println("你输入的月份不正确");
                break;
        }
    }

    /**
     * 从键盘中分别录入年月日,输出这一天是今天的第几天
     */
    private static void testSwitchCaseTwo() {
        System.out.println("请输入年份:");
        int year = SCANNER.nextInt();
        if (year < 1) {
            System.out.println("输入的年份不合法");
            return;
        }
        System.out.println("请输入月份");
        int month = SCANNER.nextInt();
        if (month > 12 || month < 1) {
            System.out.println("输入的月份不合法");
            return;
        }
        System.out.println("请输入天数");
        int day = SCANNER.nextInt();
        if (day > 31 || day < 1) {
            System.out.println("输入的天数不合法");
            return;
        }
        byte month1 = (byte) month;
        short month2 = (short) month;
        long month3 = (long) month;
        float month4 = (float) month;
        double month5 = (double) month;
        // switch (expr1) 是一个表达式
        // 可以接收byte, short,char, int, 枚举, 字符串, 不能接收long,double,float,boolean
        // java: 不兼容的类型: 从long转换到int可能会有损失
        switch ((int)month3) {
            case 12:
                day += 30;
            case 11:
                day += 31;
            case 10:
                day += 30;
            case 9:
                day += 31;
            case 8:
                day += 31;
            case 7:
                day += 30;
            case 6:
                day += 31;
            case 5:
                day += 30;
            case 4:
                day += 31;
            case 3:
                // 根据是平年还是闰年判断二月份的天数
                // 平年  28
                // 闰年 29
                if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                    day += 29;
                } else {
                    day += 28;
                }
            case 2:
                day += 31;
            case 1:
                System.out.println("这是一年中的第: " + day + "天");
                break;
        }


    }

    /**
     * 从键盘接收整数参数,如果参数为1-7 ,则输出对应的星期数
     * 否则,打印参数非法.
     */
    private static void testSwitchCaseOne() {
        System.out.println("请输入1-7的自然数: ");
        // tmd -> Exception in thread "main" java.util.InputMismatchException
        int param = SCANNER.nextInt();
        switch (param) {
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            case 4:
                System.out.println("星期四");
                break;
            case 5:
                System.out.println("星期五");
                break;
            case 6:
                System.out.println("星期六");
                break;
            case 7:
                System.out.println("星期七");
                break;
            default:
                System.out.println("你输入的参数不合法");
                break;
        }
    }
}
