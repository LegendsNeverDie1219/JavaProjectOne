package com.huawei.nce.javabase.day06.array;
/**
 *  5.二维数组的使用
 *  1)二维数组的声明和初始化
 *  2)二维数组的调用指定下标的元素
 *  3) 获取数组的长度
 *  4) 遍历数组
 *  5)数组元素的默认初始化值
 *  6)数组的内存解析
 *
 *
 *  数据结构:
 *  1.数据与数据之间的逻辑关系: 集合, 一对一, 一对多, 多对多
 *  2.数据的存储结构:
 *  线性表(刻画一对一的关系): 顺序表(数组) 链表, 栈, 队列
 * 树形结构(刻画一对多的关系): 二叉树
 * 图形结构
 */

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/12 16:02
 */
public class TwoDimensionalArray {
    public static void main(String[] args) {
        // 1).二维数组的声明和初始化
        int[][] arr1;
        //静态初始化
        arr1 = new int[][] {{1,2}, {3,4,5},{6,7,8,9}};
        // 动态初始化1
        String[][] arr2 = new String[3][2];
        // 动态初始化2
        String[][] arr3 = new String[3][];
        int[] arr4[]  = new int[][] {{1,2,3}, {4,5},{6,7,8}};
        // 2).二维数组的调用指定下标的元素
        System.out.println(arr1[0][1]);
        System.out.println(arr2[1][1]);
        // 3) 获取数组的长度
        System.out.println(arr4.length);
        System.out.println(arr4[0].length);
        System.out.println(arr4[1].length);
        System.out.println(arr4[2].length);
        //4) 遍历数组
        for (int i = 0; i < arr4.length; i ++) {
            for (int j = 0; j < arr4[i].length; j ++) {
                System.out.print(arr4[i][j] + " ");
            }
        }
        System.out.println();
        /*
        * 针对初始化方式一: int[][] arr1 = new int[4][3]
        * 外层元素的初始化值为内层数组的首地址
        * 内层元素的初始化值根据元素类型的不同而取不同的值,参考一维数组
        * 针对初始化方式二: int[][] arr2 = new int[4][];
        * 外层元素的初始化值为: null
        * 内层元素的初始化值为: 不能调用.
         */
        // 5)数组元素的默认初始化值
        float[][] floatArray = new float[4][3];
        // 地址值: floatArray: [[F@6e0be858
        System.out.println("floatArray: " + floatArray);
        //地址值 floatArray[0]: [F@6e0be858  [F@61bbe9ba
        System.out.println("floatArray[0]: " + floatArray[0]);
        // floatArray[0][0]: 0.0
        System.out.println("floatArray[0][0]: " + floatArray[0][0]);

        String[][] stringArray = new String[4][3];
        //  [Ljava.lang.String;@61bbe9ba
        System.out.println("stringArray[0]: " + stringArray[0]);
        // null
        System.out.println("stringArray[0][0]: " + stringArray[0][0]);

        double[][] doubleArray = new double[4][];
        // null
        System.out.println("doubleArray[0]: " +doubleArray[0]);
        // NullPointerException
        System.out.println("doubleArray[0]: " +doubleArray[0][0]);
        // 6)数组的内存解析
    }
}
