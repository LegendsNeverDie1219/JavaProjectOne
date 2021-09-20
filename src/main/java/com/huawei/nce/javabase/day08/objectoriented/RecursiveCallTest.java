package com.huawei.nce.javabase.day08.objectoriented;

/**
 * 递归调用:
 * 1.一个方法体内调用他自身 ,是一种隐式的循环,它会重复执行某段代码,
 * 2.递归一定要向已知的方向去递归.否则会变成无穷递归. 类似死循环.
 *
 * @author Administrator
 * @date 2021/9/20 10:57
 */
public class RecursiveCallTest {
    private static int count;
    public static void main(String[] args) {
//        int sum = getSum(4);
//        System.out.println("1-4之间的自然数的和为: " + sum);
//        int factorial = getFactorial(4);
//        System.out.println("1-4之前自然数的阶乘为: " + factorial);

//        int sequenceSum = getSequenceSum(4);
//        System.out.println("序列求和1 结果为: " + sequenceSum);

//        int sequenceSum2 = getSequenceSum2(10);
//        System.out.println("序列求和2 结果为: " + sequenceSum2);
        int sequenceSum3 = getSequenceSum3(4);
        System.out.println("序列求和2 结果为: " + sequenceSum3);
    }

    /**
     * 一个小猴子从第要跳到10层台阶.每次只能跳1层台阶或者2层台阶
     * 问 : 有多少中情况.
     * @param n n
     * @return
     */
    private static int getSequenceSum3(int n) {
        count++;
        System.out.println("count: " + count +" n: " + n);
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }  else {
            return getSequenceSum3(n-1) + getSequenceSum3(n -2);
        }
    }

    private static int getInvokeFrequency(int n) {
        count++;
        System.out.println("count: " + count +" n: " + n);
        if (n <= 0) {
            return 1;
        } else {
            return getSequenceSum3(n-1) + getSequenceSum3(n -2);
        }
    }

    /**
     *：输入一个数据n，计算斐波那契数列(Fibonacci)的第n个值
     * 1 1 2 3 5 8 13 21 34 55
     * f(n+2) = f(n+1) +f(n)
     * f(1) =1  f(2) = 1
     * 规律：一个数等于前两个数之和
     * 要求：计算斐波那契数列(Fibonacci)的第n个值，并将整个数列打印出来
     * @param n
     * @return int
     */
    private static int getSequenceSum2(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return  getSequenceSum2(n-1) + getSequenceSum2(n -2);
        }
    }

    /**
     * 已知有一个数列: f(0) = 1, f(1) = 4, f(n+2) = 2*f(n+1) +f(n);
     * 其中 n>=0, 求f(10)
     *
     * @param num num
     * @return int
     */
    private static int getSequenceSum(int num) {
        if (num == 0) {
            return 1;
        } else if (num == 1) {
            return 4;
        } else {
            return 2 * getSequenceSum(num -1) + getSequenceSum(num -2);
        }
    }

    private static int getFactorial(int num) {
        if (num == 1) {
            return 1;
        } else {
            return num * getFactorial(num -1);
        }
    }

    /**
     * 计算1-100之间自然数的和.
     */
    private static int getSum(int num) {
        if (num == 1) {
            return 1;
        } else {
            return num + getSum(num -1);
        }
    }


}
