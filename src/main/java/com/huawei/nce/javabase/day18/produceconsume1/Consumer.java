package com.huawei.nce.javabase.day18.produceconsume1;

/**
 * TODO
 *
 * @author Administrator
 * @date 2022/10/11 15:04
 */
public class Consumer implements Runnable {
    private Clerk clerk;
    public Consumer (Clerk clerk) {
        this.clerk = clerk;
    }
    @Override
    public void run() {
        System.out.println("消费者开始消费产品");
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
//    @Override
//    public void run() {
//        while (true) {
//            // 这里的this是就是当前对象 consumer ,这个时候就导致了同步监视器不是同一个.
//            // 线程二抢的是consumer这个同步监视器
//            synchronized (this) {
//                if (Clerk.productQuantity > 0) {
//                    System.out.println("开始消费第" +  Clerk.productQuantity + "个产品");
//                    Clerk.productQuantity --;
//
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
