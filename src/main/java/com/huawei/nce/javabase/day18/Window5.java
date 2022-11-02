package com.huawei.nce.javabase.day18;

import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/6 12:00
 */
public class Window5 implements Runnable {
    private int ticket = 100;
    // 重入锁.
    private ReentrantLock reentrantLock = new ReentrantLock();

    /**
     * 解决线程安全的问题三: Lock锁 ---- JDK5.0新增
     * synchronized 和Lock锁的异同
     * 相同: 两者都可以解决线程安全的问题
     * 区别: synchronized 对应的同步代码块/同步方法,在执行完同步代码块/同步方法之后,会自动释放锁
     *     Lock需要调用lock.lock() 方法获取锁, 启动同步. 调用lock.unlock() 释放锁,结束同步.
     */
    @Override
    public void run() {
        while (true) {
            try {
                // 调用锁定的方法
                reentrantLock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖票,票号为: " + ticket);
                    ticket--;


                } else {
                    break;
                }
            } finally {
                // 在finally中调用解锁的方法.
                reentrantLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Window5 runnableImpl = new Window5();
        new Thread(runnableImpl, "窗口一").start();
        new Thread(runnableImpl, "窗口二").start();
        new Thread(runnableImpl, "窗口三").start();
    }
}
