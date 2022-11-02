package com.huawei.nce.javabase.day18.produceconsume3;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * TODO
 *
 * @author Administrator
 * @date 2022/11/2 11:40
 */

public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("汇总1 ...");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("汇总2 ...");
        });
        //for(int u = 0, u < 2;u ++)//开两次屏障使用
        for(int i = 0;i < 3;i ++) {
            new Thread(() -> {
                try {
                    Thread.sleep((long)(Math.random() * 2000));

                    int randomInt = new Random().nextInt(500);
                    System.out.println("hello " + randomInt);

                    cyclicBarrier.await();

                    System.out.println("world " + randomInt);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}