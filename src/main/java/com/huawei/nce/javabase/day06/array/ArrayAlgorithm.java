package com.huawei.nce.javabase.day06.array;

import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/19 11:01
 */
public class ArrayAlgorithm {
    public static void main(String[] args) {
        // testArrayAlgorithm1();
        // testArrayAlgorithm2();
        // testArrayAlgorithm3();
        // testArrayAlgorithm4();
       // testArrayAlgorithm5();
        testArrayAPI();
    }

    private static void testArrayAPI() {
        int[] array1 = new int[]{7, 3, 19, 2, 11, 13, 17, 5};
        int[] array2 = new int[]{7, 3, 19, 2, 11, 13, 17, 5};
        // 1.Arrays.equals(int[] a,int[] b) 比较两个数组是否相等
        System.out.println(Arrays.equals(array1,array2));
        // 2.Arrays.toString 打印数组信息
        System.out.println(Arrays.toString(array1));

        //3.数组排序.快速排序
        Arrays.sort(array1);
        System.out.println(Arrays.toString(array1));

        // 4.数组二分查找
        int index = Arrays.binarySearch(array1, 13);
        if (index >= 0) {
            System.out.println("找到了目标数字,索引为: " + index);
        } else {
            System.out.println("没有找到目标数字");
        }

        // 5.创建并初始化包含多个元素的集合
        List<Integer> integerList = Arrays.asList(7, 3, 19, 2);
        integerList.forEach(number -> System.out.print(number + "\t"));
        System.out.println();
        // 6. Arrays.fill 将指定的数值填充到数组中
        Arrays.fill(array1, 100);
        System.out.println(Arrays.toString(array1));
    }

    /**
     * 测试数组的二分查找(前提:要查找的数组必须有序,如果无序,需要提前进行排序)
     */
    private static void testArrayAlgorithm5() {
        int[] array = new int[]{7, 3, 19, 2, 11, 13, 17, 5};
        int targetNumber = 13;
        sortArray(array);
        int index = binarySearchArray(array, targetNumber);
        if (index >= 0) {
            System.out.println("找到了目标数字,索引为: " + index);
        } else {
            System.out.println("没有找到目标数字");
        }

    }

    private static int binarySearchArray(int[] sortedArray, int targetNumber) {
        int startIndex = 0;
        int endIndex = sortedArray.length -1;
        while (startIndex <= endIndex) {
            int middleIndex = (endIndex - startIndex)/2;
            if (targetNumber == sortedArray[middleIndex]) {
                System.out.println("找到了目标数字,索引为: " + middleIndex);
                return middleIndex;
            } else if (targetNumber > sortedArray[middleIndex]) {
                // (middle,length -1]
                startIndex  = middleIndex +1 ;
            } else {
                // [0, middle)
                endIndex  = middleIndex -1;
            }
        }
        return -1 * sortedArray.length;
    }

    /**
     * 对数组进行排序(冒泡排序 时间复杂度: n*n)
     *
     * @param array array
     * @return int[]
     */
    private static void sortArray(int[] array) {
        // n个数字需要进行n-1大轮排序.
        for (int i = 0 ; i < array.length -1; i++) {
            // 某一轮次需要在这一轮排序中比较的次数
            // 轮次为 0 , 比较次数: 7  ;轮次为 6, 比较次数:1
            for (int j = 0; j < array.length - 1- i; j++) {
                // 冒泡排序是相邻元素的比较
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j+1] = temp;
                }
            }
        }
    }

    /**
     * 测试数组的线性查找
     */
    private static void testArrayAlgorithm4() {
        int[] array = new int[]{7, 3, 19, 2, 11, 13, 17, 5};
        int targetNumber = 13;
        boolean hasFind  = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == targetNumber) {
                System.out.println("找到了目标数字,索引为: " + i);
                hasFind = true;
                break;
            }
        }
        if (!hasFind) {
            System.out.println("没有找到目标数字");
        }
    }

    /**
     * 测试数组的反转
     */
    private static void testArrayAlgorithm3() {
        int[] array = new int[]{2, 3, 5, 7, 11, 13, 17, 19};
        printArray(array);
        for (int i = 0; i < array.length / 2; i++) {
            int temporaryVariable = array[i];
            array[i] = array[array.length -1 -i];
            array[array.length - 1 - i] = temporaryVariable;
        }
        printArray(array);
    }

    /**
     * 使用简单数组的:
     * 创建并初始化一个数组 2,3,5,7,11,13,17,19
     * 显示array1的内容
     * 把array1赋值给array2
     * 实现array3对array1的复制
     */
    private static void testArrayAlgorithm2() {
        int[] array1 = new int[]{2, 3, 5, 7, 11, 13, 17, 19};
        int[] array2;
        int[] array3 = new int[array1.length];
        printArray(array1);
        // 赋值
        array2 = array1;
        array2[0] = 100;
        printArray(array1);
        // 复制
//        for (int i = 0; i < array1.length; i++) {
//            array3[i] = array1[i];
//        }
        System.arraycopy(array1, 0, array3, 0, array1.length);
        array3[0] = 200;
        printArray(array1);
        printArray(array3);

    }

    /**
     * 定义一个int型的一维数组，包含10个元素，分别赋一些随机整数(1-100)，
     * 然后求出所有元素的最大值，最小值，和值，平均值，并输出出来。
     */
    private static void testArrayAlgorithm1() {
        int [] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            int randomNumber = (int)(Math.random() * 100) + 1;
            array[i] = randomNumber;
        }
        printArray(array);
        int maxNumber = getArrayMaxNumber(array);
        System.out.println("数组元素中的最大值: " + maxNumber);
        int minNumber = getArrayMinNumber(array);
        System.out.println("数组元素中的最小值: " + minNumber);
        int sumNumber = getArraySum(array);
        System.out.println("数组元素中的和为: " + sumNumber);
        int average = getArrayAverage(array);
        System.out.println("数组元素中的平均值为: " + average);
    }

    private static int getArrayAverage(int[] array) {
        int sumNumber = 0;
        for (int i : array) {
            sumNumber +=i;
        }
        return sumNumber/array.length;
    }

    private static int getArraySum(int[] array) {
        int sumNumber = 0;
        for (int i : array) {
            sumNumber +=i;
        }
        return sumNumber;
    }

    private static int getArrayMinNumber(int[] array) {
        int minNumber = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minNumber) {
                minNumber = array[i];
            }
        }
        return minNumber;
    }

    private static int getArrayMaxNumber(int[] array) {
        int maxNumber = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxNumber) {
                maxNumber = array[i];
            }
        }
        return maxNumber;
    }

    private static void printArray(int[] array) {
        System.out.print("数组中的元素为: ");
        for (int j : array) {
            System.out.print(j + "\t");
        }
        System.out.println();
    }
}
