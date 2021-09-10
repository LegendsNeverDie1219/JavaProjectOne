package com.huawei.nce.javabase.day04.programcontrol;

import java.util.Scanner;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/8 23:24
 */
public class ForLoopTest {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
       // testForLoopOne();
        // testForLoopTwo();
        //testForLoopThree();
       // testForLoopFour();
        //testForLoopFive();
        //testForLoopSix();
       // testForLoopSeven();
        testForLoopEight();
    }
    /**
     * 求100以内的所有质数,并打印
     */
    private static void testForLoopEight() {
        // 被除数范围 2-100(最小的质数是2)
        long startTime = System.currentTimeMillis();
        int count = 0;
        name: for (int i = 2; i <= 100000; i++) {
            for (int j = 2; j <= Math.sqrt(i); j ++) {
                if (i % j == 0) {
                    // 默认跳过包裹该关键字的最近的一层for循环.
                    // 如果想跳过外层for循环,需要给外层for循环起别名, continue label
                    continue name;
                }
            }
            count++;
        }
        System.out.println("质数的个数为: " + count);
        // 9592 话费的时间为: 11
        System.out.println("话费的时间为: " + (System.currentTimeMillis() -startTime));
    }

    /**
     * 求100以内的所有质数,并打印
     */
    private static void testForLoopSeven() {
        // 被除数范围 2-100(最小的质数是2)
        long startTime = System.currentTimeMillis();
        for (int i = 2; i <= 100000; i++) {
            boolean flag = true;
            // 除数范围(2 ~ i-1)只要有一次能整除 ,则flag为false, 跳出内层for循环,
            // 优化二:
            for (int j = 2; j <= Math.sqrt(i); j ++) {
//            for (int j = 2; j < i; j ++) {
                if (i % j == 0) {
                    flag = false;
                    // 优化一: 添加break;
                    // 默认跳过包裹该关键字的最近的一层for循环.
                    break;
                }
            }
            if (flag) {
                System.out.println("质数: " + i);
            }
        }
        System.out.println("话费的时间为: " + (System.currentTimeMillis() -startTime));
        // 第一次: 13072
        // 添加break :1091
        // 修改循环判断条件:59
    }

    /**
     * 输出所有的水仙花数
     * 所谓水仙花数是指一个3位数，其各个位上数字立方和等于其本身。
     * 例如： 153 = 1*1*1 + 3*3*3 + 5*5*5
     */
    private static void testForLoopSix() {
        for (int i = 100; i < 1000; i++) {
            int hundreds = i / 100;
            int tens = i / 10 % 10;
            int digits = i % 10;
            int tempOne = hundreds * hundreds *hundreds;
            int tempTwo = tens * tens *tens;
            int tempThree = digits * digits *digits;
            if (tempOne + tempTwo + tempThree == i) {
                System.out.println(i);
            }
        }
    }

    /**
     * 打印如下的图形：菱形1
     *     *           1  ->     4   1
     *    * *          2  ->     3   2
     *   * * *         3  ->     2    3
     *  * * * *        4         1    4
     * * * * * *       5         0    5
     *  * * * *        6         1    4
     *   * * *         7         2    3
     *    * *          8         3    2
     *     *           9         4     1
     */
    private static void testForLoopFive() {
        for (int i = 1; i <= 5; i++) {
            //上半部分
            for (int j = 0; j < 5-i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        //下半部分
        for (int i = 1; i <= 4; i++) {
            for (int k = 0; k < i; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 5-i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /**
     * 3000米长的绳子，每天减一半。问多少天这个绳子会小于5米？不考虑小数
     */
    private static void testForLoopFour() {
        int day = 0;
//        for (double ropeLength = 3000; ropeLength >= 5; day ++) {
//            ropeLength /= 2;
//        }
        // 循环体和迭代条件的位置有时候可以互换.
        for (double ropeLength = 3000; ropeLength >= 5; ropeLength /= 2) {
           day++;
        }
        System.out.println("需要的天数: " + day);
    }

    /**
     * 打印 9 9乘法表
     *  1*1 =1
     *  2*1 =2 2*2 =4
     *  3*1....
     */
    private static void testForLoopThree() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " * " + j + " = " + i * j + " " );
            }
            if (i != 9) {
                System.out.println();
            }
        }
    }

    /**
     * 输入两个正整数, 求他们的最大公约数以及最小公倍数
     * 比如 12和20d的最大公约数是4,最小公倍数是60
     */
    private static void testForLoopTwo() {
        System.out.println("请输入第一个正整数");
        int numOne = SCANNER.nextInt();
        System.out.println("请输入第二个正整数");
        int numTwo = SCANNER.nextInt();

        // 1<=最大公约数 <= 最小的数     最大的数 <= 最大公倍数 <= 两个数之积
        // 最大公约数 到大到小找   最小公倍数  从小到大找
        int minNum = numOne < numTwo ? numOne : numTwo;
        //int commonDivisor = 1;
        for (int i = minNum; i >= 1; i--) {
            if (numOne % i == 0 && numTwo % i == 0) {
               // commonDivisor = i;
                System.out.println("最大的公约数是: " + i);
                break;
            }
        }
       // System.out.println("最大的公约数是: " + commonDivisor);

        int maxNum = numOne > numTwo ? numOne : numTwo;
        int commonMultiple = numOne * numTwo;
        for (int i = maxNum; i<= numOne * numTwo; i++) {
            if (i % numOne ==0 && i % numTwo == 0) {
                commonMultiple = i;
                break;
            }
        }
        System.out.println("最小公倍数为: " + commonMultiple);


    }

    /**
     * for循环的结构
     * 1.初始化部分
     * 2.循环判断部分
     * 3.循环体部分
     * 4.迭代部分
     * (有时候,循环体部分中的内容,也可能写入到了迭代部分)
     */
    private static void testForLoopOne() {
        int num = 1;
        // abcbcbc
        for (System.out.print("a"); num <= 3; System.out.print("c"),num++) {
            System.out.print("b");
        }
    }
}
