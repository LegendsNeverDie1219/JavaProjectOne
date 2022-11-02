package com.huawei.nce.javabase.day18.produceconsume3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author 胡东升
 * @date 2022/10/10 18:15
 */
public class ProduceConsumerBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);
        ShareResource2 shareResource2 = new ShareResource2(blockingQueue);
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t生产者线程启动成功");
            try {
                shareResource2.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "produce").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t消费线程启动成功");
            try {
                shareResource2.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "consumer").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("5秒钟时间到,大老板main线程叫停,活动结束");
        shareResource2.stop();
    }
}

