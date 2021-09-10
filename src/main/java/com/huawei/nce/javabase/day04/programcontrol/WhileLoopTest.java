package com.huawei.nce.javabase.day04.programcontrol;

import java.util.Random;
import java.util.Scanner;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/10 9:48
 */
public class WhileLoopTest {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        //testWhileLoopOne();
       // testDoWhileLoopOne();
        testWhileLoopTwo();
    }

    /**
     * 求调和级数中从第多少项开始值大于10
     * 调和级数的第n项形式为：1+1/2+1/3+…+1/n
     */
    private static void testWhileLoopTwo() {
        double sum = 0.0;
        double i =1.0;
        while (sum <=10) {
            sum += 1.0/i;
            i++;
        }
        System.out.println("从第几项开始, :" + i) ;
    }

    /**
     * 随机生成一个100以内的数，猜数字游戏：
     * 从键盘输入数，如果大了提示，大了，如果小了，提示小了，如果对了，就不再猜了，并统计一共猜了多少次？
     */
    private static void testDoWhileLoopOne() {
        System.out.println("开始生成 [0,100)的随机数");
        // 前端推荐使用这个.
        // window.crypto.getRandomValues(new Uint8Array(1)) * 0.001
        //Math.random线程安全,推荐使用.
        // int randomNumber = (int)(Math.random() * 100);
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        System.out.println("生成的随机数字是: " + randomNumber);

        System.out.println("请输入你要猜测的数字");
        int count = 0;
//        int guessNumber;
//        do {
//            count ++;
//            guessNumber = SCANNER.nextInt();
//            if (guessNumber > randomNumber) {
//                System.out.println("你输入的数字大了,请继续");
//            } else if (guessNumber < randomNumber){
//                System.out.println("你输入的数字小了,请继续");
//            }
//            //break;
//        } while (guessNumber !=randomNumber);

        do {
            count ++;
            int guessNumber = SCANNER.nextInt();
            if (guessNumber > randomNumber) {
                System.out.println("你输入的数字大了,请继续");
                continue;
            } else if (guessNumber < randomNumber){
                System.out.println("你输入的数字小了,请继续");
                continue;
            } else {
                break;
            }
        } while (true);
        System.out.println("你猜的次数为: " +count);
    }

    /**
     * 从键盘中读入个数不确定的整数,并且判断读入的整数和负数的个数,输入0时程序结束.
     */
    public static void testWhileLoopOne() {
        System.out.println("请从键盘中录入一个整数");
        int positiveNumber = 0;
        int negativeNumber = 0;
//        while (true) {
//            double num = SCANNER.nextDouble();
//            if (num > 0) {
//                positiveNumber ++;
//            } else if (num < 0) {
//                negativeNumber ++;
//            } else {
//                break;
//            }
//        }

        for (;;) {
            double num = SCANNER.nextDouble();
            if (num > 0) {
                positiveNumber ++;
            } else if (num < 0) {
                negativeNumber ++;
            } else {
                break;
            }
        }
        System.out.println("正数的个数为: " + positiveNumber);
        System.out.println("负数的个数为: " + negativeNumber);
    }
}
