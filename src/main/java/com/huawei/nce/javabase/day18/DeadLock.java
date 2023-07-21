package com.huawei.nce.javabase.day18;

/**
 * TODO
 *
 * @author Administrator
 * @date 2022/10/11 16:14
 */

public class DeadLock {
    private static String A = "a";
    private static String B = "b";

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (A) {
                    // 让线程先睡眠2s
                    try {
                        Thread.sleep(1000);
                        // 尝试获取B对象的锁
                        synchronized (B) {
                            System.out.println("线程A获取到B对象");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        },"AA").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                // 占有B对象
                synchronized (B) {
                    // 尝试获取B对象的锁
                    synchronized (A) {
                        System.out.println("线程B获取到A对象");
                    }
                }
            }
        },"BB").start();
    }
}

