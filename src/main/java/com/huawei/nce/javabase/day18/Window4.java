package com.huawei.nce.javabase.day18;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/6 10:50
 */
public class Window4 implements Runnable {
    private int ticket = 100;
//    @Override
//    public void run() {
//        while(true) {
//            synchronized (this) {
//                if (ticket > 0) {
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName() + "卖票,票号为: " + ticket);
//                    ticket--;
//                } else {
//                    break;
//                }
//            }
//        }
//    }

    @Override
    public void run() {
        while (true) {
            if (this.sellTickets()) {
                break;
            }
        }
    }

    private synchronized boolean sellTickets() {
        if (ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖票,票号为: " + ticket);
            ticket--;
        } else {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Window4 runnableImplTwo = new Window4();
        Thread threadOne = new Thread(runnableImplTwo, "窗口一");
        Thread threadTwo = new Thread(runnableImplTwo, "窗口二");
        Thread threadThree = new Thread(runnableImplTwo, "窗口三");
        threadOne.start();
        threadTwo.start();
        threadThree.start();

    }
}
