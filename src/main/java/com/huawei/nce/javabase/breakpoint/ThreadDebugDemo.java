package com.huawei.nce.javabase.breakpoint;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/5/25 23:58
 */
public class ThreadDebugDemo {
    public static void main(String[] args) {
        MyRunnable myRunnable =  new MyRunnable();
        Thread threadOne = new Thread(myRunnable, "线程1");
        Thread threadTwo = new Thread(myRunnable, "线程2");
        Thread threadThree = new Thread(myRunnable, "线程3");
        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }
}
