package com.huawei.nce.javabase.day18.produceconsume2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 *
 * @author 胡东升
 * @date 2022/10/10 11:05
 */
public class ShareResource {
    private  Integer number = 0;
    private final Lock reentrantLock = new ReentrantLock();
    private final Condition condition=  reentrantLock.newCondition();
    // 线程 操作 资源类
    // 判断 干活 通知.
    public void increaseNumber() {
        reentrantLock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            number++;
            System.out.println("线程: " + Thread.currentThread() + "生产了一个产品,number为: " + number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void decreaseNumber() {
        reentrantLock.lock();
        try {
            while (number == 0) {
                condition.await();
            }
            number--;
            System.out.println("线程: " + Thread.currentThread() + "消费了一个产品,number为: " + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }
}




