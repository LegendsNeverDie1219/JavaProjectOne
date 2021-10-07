package com.huawei.nce.javabase.day18;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/4 21:47
 */
public class Window2 implements Runnable{
    private int ticket =100;
    @Override
    public void run() {
        while(true) {
            if(ticket > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "卖票,票号为:" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Window2 window = new Window2();
        Thread thread1 = new Thread(window);
        thread1.setName("窗口一");


        Thread thread2 = new Thread(window);
        thread2.setName("窗口二");


        Thread thread3 = new Thread(window);
        thread3.setName("窗口三");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
