package com.huawei.nce.javabase.day08.objectoriented;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/20 8:53
 */
public class TransferTest1 {
    public static void main(String[] args) {
        TransferTest1 transferTest1 = new TransferTest1();

        /*
         * 变量a,b main中声明了一次. 在swap方法中也声明了一次. 这样变量a,b在栈内存中就有两份
         *  a,b的值在swap方法中交换了. 在main方法中没有交换.
         * 原因: 值传递机制
         *  基本数据类型的变量存储/赋值的是栈内存中数据本身的值.
         *  引用数据类型的变量存储/赋值的是堆内存中的数据的首地址
         * 如果参数是基本类型. 则实参传递给形参的是栈内存中数据本身的值
         * 如果参数是引用数据类型, 则实参传递给形参的是堆内存中对象的首地址.
         *
         * */

        // int a = 10;
        // int b = 20;
        // transferTest.swap(a, b);

        Data data = new Data();
        data.a = 10;
        data.b = 20;
        transferTest1.swap(data);

        System.out.println("main中 a的值: " + data.a + ", b的值: " + data.b);
    }
    private void swap(Data data) {
        int temp = data.a;
        data.a = data.b;
        data.b = temp;
        System.out.println("swap中 a的值: " + data.a + ", b的值: " + data.b);

    }

    private void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("swap中 a的值: " + a + ", b的值: " + b);

    }

    static class Data {
        int a;
        int b;
        private Data(int a, int b) {
            this.a = a;
            this.b = b;
        }
        private Data() {
        }
    }
}
