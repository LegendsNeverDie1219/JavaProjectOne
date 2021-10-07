package com.huawei.nce.javabase.day18;

/**
 * 例子: 创建三个窗口卖票,总票数为100张.
 *
 * 存在线程安全问题,待解决
 *
 * @author Administrator
 * @date 2021/10/4 21:13
 */
public class Window1 extends Thread{
    private static int ticket = 100;
    @Override
    public void run() {
        while(true) {
            if (ticket > 0) {
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName() + "卖票,票号为: " + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Window1 windowOne = new Window1();
        windowOne.setName("窗口一");
        Window1 windowTwo = new Window1();
        windowTwo.setName("窗口二");
        Window1 windowThree = new Window1();
        windowThree.setName("窗口三");
        windowOne.start();
        windowTwo.start();
        windowThree.start();
    }
}
