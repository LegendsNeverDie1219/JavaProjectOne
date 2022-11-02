package com.huawei.nce.javabase.day18.produceconsume1;

import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/6 15:43
 */
public class ProduceConsumerModel {
    /**
     * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处
     * 取走产品，店员一次只能持有固定数量的产品(比如:20），如果生产者试图
     * 生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通
     * 知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
     * 果店中有产品了再通知消费者来取走产品。
     * 这里可能出现两个问题：
     * 生产者比消费者快时，消费者会漏掉一些数据没有取到。
     * 消费者比生产者快时，消费者会取相同的数据。
     */
    /**
     * 分析:
     * ①是否涉及多线程问题 是  生产者线程,消费者线程
     * ②是否涉及操作共享数据 是  (店员)
     * ③是否有线程安全问题   有,(三种方式)
     * ④是否涉及线程之前的通信 是
     * @param args
     */
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        // Producer producer = new Producer(clerk);
        // Consumer consumer = new Consumer(clerk);
        // new Thread(producer, "生产者一").start();
        // new Thread(consumer, "消费者一").start();
        new Thread(() -> {
            System.out.println("生产者开始生产产品");
            while (true) {
                try {
                    //Thread.sleep(1000);
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                clerk.addProduct();
            }
        }, "生产者一").start();
        new Thread(() -> {
            System.out.println("消费者开始消费产品");
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                clerk.consumeProduct();
            }
        }, "消费者一").start();

    }
}

