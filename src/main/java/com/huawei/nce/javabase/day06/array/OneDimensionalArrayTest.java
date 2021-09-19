package com.huawei.nce.javabase.day06.array;

/**
 * 一.数组的概述:
 * 1.数组,是多个相同类型的数据按照一定顺序排列的集合.并使用一个名字来命名
 * 并通过下标对数组的元素进行管理
 *
 * 2.数组的相关概念
 * >数组名
 * > 元素
 * >下标
 * >数组长度
 *
 * 3.数组特点
 * 1)数组是有序排列的
 * 2)数组是引用类型的变量,但是数组内的元素,既可以是基本类型,也可以是引用类型
 * 3)创建数组对象会在堆内存(heap)中开辟一块连续的内存空间
 * 4)数组长度一旦确定,就不能修改.
 *
 * 4.数组分类
 * 1)按照维数: 一维数组,二维数组
 * 2)按照数组元素的类型: 基本数据类型元素的数组  引用数据类型元素的数组.
 *
 * 5.一维数组的使用
 * 1)一维数组的声明和初始化
 * 2)一维数组的调用指定下标的元素
 * 3) 获取数组的长度
 * 4) 遍历数组
 * 5)数组元素的默认初始化值
 * 6)数组的内存解析
 */

import java.util.Scanner;

/**
 * OneDimensionalArray
 *
 * @author Administrator
 * @date 2021/9/12 14:29
 */
public class OneDimensionalArrayTest {
    public static void main(String[] args) {
        //testArrayOne();
        testArrayTwo();
    }

    /**
     *  从键盘读入学生成绩，找出最高分，
     * 并输出学生成绩等级。
     * 成绩>=最高分-10 等级为’A’
     * 成绩>=最高分-20 等级为’B’
     * 成绩>=最高分-30 等级为’C’
     * 其余 等级为’D’
     */
    private static void testArrayTwo() {
        Scanner scanner = new Scanner(System.in);
        // 1.读取键盘录入的学生个数信息,存入到变量number
        System.out.println("请输入学生的个数");
        int number = scanner.nextInt();
        // 2.读取键盘录入的学生的成绩信息.存入到数组中array中
        double[] array = new double[number];
        double maxScore = array[0];
        System.out.println("请输入" + number +"个学生的成绩");
        for (int i = 0; i < array.length; i ++) {
            double score = scanner.nextDouble();
            array[i] = score;
            // 3.获取成绩中的最高分,存入到的变量中maxScore
            if (array[i] > maxScore) {
                maxScore = array[i];
            }
        }
        // 4.遍历数组,根据条件打印等级信息
        for (double score : array) {
            if (score >= maxScore - 10) {
                System.out.println("student " + "i" + "score is " + score
                        + " grade is A");
            } else if (score >= maxScore - 20) {
                System.out.println("student " + "i" + "score is " + score
                        + " grade is B");
            } else if (score >= maxScore - 30) {
                System.out.println("student " + "i" + "score is " + score
                        + " grade is C");
            } else {
                System.out.println("student " + "i" + "score is " + score
                        + " grade is D");
            }
        }
    }

    /**
     * 一维数组的使用
     */
    private static void testArrayOne() {
        // 1.1数组的声明
        int[] ids;
        // 1.2静态初始化:数组的初始化和数组元素的赋值操作同时进行

        ids = new int[] {1001, 1002, 1003, 1004};
        // 1.2动态初始化: 只是执行了数组的初始化(规定数组长度,对内部元素赋默认值)
        String[] names = new String[5];

        // 2.调用指定位置的元素
        names[0] = "胡歌";
        names[1] = "杨幂";
        names[2] = "霍建华";
        names[3] = "唐嫣";
        names[4] = "刘诗诗";
        // ArrayIndexOutOfBoundsException
        //names[5] = "茂茂";
        // 3.获取数组的长度
        System.out.println("names.length: " + names.length);
        System.out.println("ids.length: " + ids.length);
        // 4.遍历数组
        for (int i = 0; i < ids.length; i++) {
            System.out.println(ids[i]);
        }

        for (String name : names) {
            System.out.println(name);
        }

        // 5.数组元素的默认初始化值.
        /*
        * 数组元素类型是整形: 0
        * 数组元素类型是浮点型: 0.0
        * 数组元素类型是字符型: 0 或者'\u0000'
        * 数组元素类型是boolean false
        * 数组元素是引用类型
         */
        int[] arr1 = new int[4];
        double[] arr2 = new double[4];
        char[] arr3 = new char[4];
        boolean[] arr4 = new boolean[4];
        String[] arr5 = new String[4];
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + "->");
        }
        System.out.println();
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + "->");
        }
        System.out.println();
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + "->");
        }
        System.out.println();
        for (int i = 0; i < arr4.length; i++) {
            System.out.print(arr4[i] + "->");
        }
        System.out.println();
        for (int i = 0; i < arr5.length; i++) {
            System.out.print(arr5[i] + "->");
        }
    }
}
