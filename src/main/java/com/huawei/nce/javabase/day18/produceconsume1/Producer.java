package com.huawei.nce.javabase.day18.produceconsume1;

/**
 * TODO
 *
 * @author Administrator
 * @date 2022/10/11 15:05
 */
public class Producer implements Runnable {
    private Clerk clerk;
    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }
    @Override
    public void run() {
        System.out.println("生产者开始生产产品");
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.addProduct();
        }
    }
//    @Override
//    public void run() {
//        while (true) {
//            // 这里的this是就是当前对象 producer ,这个时候就导致了同步监视器不是同一个.
//            // 线程一抢的是producer这个同步监视器
//            synchronized (this) {
//                if (Clerk.productQuantity < 10) {
//                    System.out.println("开始生产第" +  Clerk.productQuantity + "个产品");
//                    Clerk.productQuantity ++;
//                } else {
//                    try {
//                        wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//    }
}
