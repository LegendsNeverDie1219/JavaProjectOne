package com.huawei.nce.javabase.day18.produceconsume2;

/**
 * TODO
 *
 * @author 胡东升
 * @date 2022/10/10 16:45
 */
public class ProduceConsumerModel {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(() -> {
            for (int i = 0; i <= 5; i++) {
                shareResource.increaseNumber();
            }
        }, "AAA").start();

        new Thread(() -> {
            for (int i = 0; i <= 5; i++) {
                shareResource.decreaseNumber();
            }
        }, "BBB").start();
    }
}
