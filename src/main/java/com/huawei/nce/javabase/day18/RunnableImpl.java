package com.huawei.nce.javabase.day18;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/4 21:23
 */
public class RunnableImpl implements Runnable{
    /**
     * 多线程的创建方式二:实现Runnable接口.
     * ①创建一个实现Runnable接口的实现类
     * ②实现Runnable接口中的run方法
     * ③new一个线程实例,将runnable接口实现类实例作为入参
     * 传递到Thread(runnable)有参构造方法中.
     * ④调用start()方法
     * 作用: 启动当前线程 ; 调用当前线程的run()方法
     */
    /**
     * 比较创建线程的两种方式:
     * 开发中,优先选择使用实现Runnable接口的方式
     *  1.实现Runnable接口的方式实现于接口,摆脱了单继承的局限性
     *  2.实现Runnable接口的方式更适合处理多个线程之前共享数据的情况
     *
     *  联系 :两种方式都需要重写Run()方法.
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "_" + i);
            }
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new RunnableImpl();
        Thread thread = new Thread(runnable);
        thread.setName("线程一");
        thread.start();
    }
}
