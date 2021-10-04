package com.huawei.nce.javabase.day16.exceptionhandling;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/2 16:19
 */
public class ErrorTest {
    public static void main(String[] args) {
        // java.lang.StackOverflowError 栈内存溢出,递归调用.导致栈内存中的变量args一直无法释放
       // main(args);
        // 2.java.lang.OutOfMemoryError 堆内存溢出,4G内存空间
       // Integer[] arr = new Integer[1024*1024*1024];
    }
}
