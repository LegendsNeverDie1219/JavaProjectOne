package com.huawei.nce.javabase.day18;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/4 20:29
 */
public class MyThread extends Thread {
    /**
     * 多线程的创建方式一:继承Thread类.
     * ①创建一个继承Thread类的子类.
     * ②重写Thread类中的run方法
     * ③new一个线程子类实例
     * ④调用start()方法
     * 作用: 启动当前线程 ; 调用当前线程的run()方法
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "_" + i);
            }
        }
    }

    /**
     * 测试线程中的常用方法:
     * 1.start() 启动当前线程,调用当前线程的run()方法
     * 2.run() 通常子类要重写Thread类中run()方法,可以将要执行的操作/代码逻辑放到run()方法中去.
     * currentThread() 静态方法,返回执行当前代码的线程
     * getName() 获取当前线程的名称
     * setName() 设置当前线程的名称
     * yield()  当前线程执行cpu的执行权.
     * join() 在线程a中调用线程b的join()方法.会使线程a进入阻塞状态.直到线程b执行完成整个run()方法.才结束阻塞.
     * stop()已过时,强制结束当前线程
     * isAlive() 判断当前线程是否存活
     *
     * 线程的优先级:
     *    public final static int MIN_PRIORITY = 1;
     *    public final static int NORM_PRIORITY = 5;
     *    public final static int MAX_PRIORITY = 10;
     *    分为十档, 最高的优先级是10 默认是5
     *    涉及的方法: getPriority()获取当前线程的优先级
     *              setPriority() 设置当前线程的优先级
     *    线程创建的时候继承了父线程的优先级
     *    并非是优先级高的线程就一定会先执行.只是概率问题.
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread1 = new MyThread();
        myThread1.setName("线程一");
        myThread1.setPriority(Thread.MAX_PRIORITY);
        myThread1.start();
        // IllegalThreadStateException
        // 不可以让已经启动了的线程再次执行start()方法,会报不合法的线程状态的异常.
        // myThread.start();
//        SubThread subThread = new SubThread();
//        subThread.setName("线程二");
//        subThread.start();

//        new Thread() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 100; i++) {
//                    if (i % 10 == 0) {
//                        try {
//                            sleep(1000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        System.out.println(Thread.currentThread().getName() + "_" + i);
//                    }
//                }
//            }
//        }.start();

       Thread.currentThread().setName("主线程");
        for (int i = 0; i < 100; i++) {
            if (i % 10 == 0) {
                try {
                  myThread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "_" + i);
            }
        }
        System.out.println("mythread1.isAlive(): " + myThread1.isAlive());


    }
}

class SubThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + "**********" + i);
            }
        }
    }
}
