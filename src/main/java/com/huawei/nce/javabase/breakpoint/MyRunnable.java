package com.huawei.nce.breakpoint;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/5/25 23:59
 */
public class MyRunnable  implements  Runnable{

    public void run() {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName() + "------------进入");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(currentThread.getName() + "--------------离开");
        }
    }
}
