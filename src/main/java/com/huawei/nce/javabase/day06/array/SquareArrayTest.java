package com.huawei.nce.javabase.day06.array;

import java.util.Scanner;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/19 9:44
 */
public class SquareArrayTest {
    /**
     * 从键盘输入一个整数（1~20）
     * 则以该数字为矩阵的大小，把1,2,3…n*n 的数字按照顺时针螺旋的形式填入其中。例如： 输入数字2，则程序输出：
     * 1 2
     * 4 3
     * 输入数字3，则程序输出：
     * 1 2 3
     * 8 9 4
     * 7 6 5
     * 输入数字4， 则程序输出：
     * 1   2   3   4
     * 12  13  14  5
     * 11  16  15  6
     * 10  9   8   7
     *
     * @param args args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请从键盘中录入一个整数: 范围是1~20");

        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            if (number <= 0 || number >= 21) {
                System.out.println("你输入的数字范围不合法,请重新输入");
                continue;
            }
            System.out.println("你输入的数字是: " + number);
            // 2.给数组赋值
            int[][] squareArray = geneSquareArray(number);
            // 3.打印数组
            printSquareArray(squareArray);
            break;
        }

    }

    private static void printSquareArray(int[][] squareArray) {
        for (int[] outerArray: squareArray) {
            for (int innerElement :outerArray) {
                String prefix = innerElement > 99 ? "" : innerElement > 9 ? "0" : "00";
                System.out.print(prefix + innerElement + " ");
            }
            System.out.println();
        }
    }

    private static int[][] geneSquareArray(int number) {
        int[][] squareArray = new int[number][number];
        // 1.定义数组的外层元素(列)的下标范围(0~number-1)
        int minY = 0;
        int maxY = number -1;
        // 2.定义数组内层元素(行)的下标范围(0~number-1)
        int minX = 0;
        int maxX = number -1;
        // 3.定义数组中元素的初始化值
        int count = 0;
        // 4.根据规律变换列下标.行下标依次给数组的的相对外层赋值(要注意循环的就结束条件)
        while (minX <= maxX) {
            // 给数组的第一行赋值(要注意,不要写死)
             for (int x = minX; x <= maxX; x++) {
                 // (要注意,下标不要写死)
                 squareArray[minY][x] = ++count;
             }

             minY++;
            // 给数组的最后一列赋值(去掉右上角)
            for (int y = minY; y <= maxY; y++) {
                squareArray[y][maxX] = ++count;
            }

            maxX--;
            // 给数组的最后一行赋值(去掉右下角)
            for (int x = maxX; x >= minX; x--) {
                squareArray[maxY][x] = ++count;
            }

            maxY--;
            // 给数组的第一列赋值(去掉左上角)
            for (int y  = maxY; y >=minY; y--) {
                squareArray[y][minX] = ++count;
            }
            minX++;
        }
        return squareArray;
    }
}
