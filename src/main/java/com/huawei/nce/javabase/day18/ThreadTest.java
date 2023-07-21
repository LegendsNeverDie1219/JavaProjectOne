package com.huawei.nce.javabase.day18;

/**
 * TODO
 *
 * @author Administrator
 * @date 2023/2/27 23:57
 */
public class ThreadTest {
    public static void main(String[] args) {
        while (true) {
            System.out.println("hds");
        }
        // new Thread(() -> {
        //     System.out.println("this is a thread");
        //     try {
        //         TimeUnit.HOURS.sleep(1);
        //     } catch (InterruptedException e) {
        //         throw new RuntimeException(e);
        //     }
        // },"thread hds");
    }
}
