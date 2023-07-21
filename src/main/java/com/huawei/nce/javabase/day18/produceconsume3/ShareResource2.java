package com.huawei.nce.javabase.day18.produceconsume3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO
 *
 * @author 胡东升
 * @date 2022/10/10 16:55
 */
public class ShareResource2 {
    private final AtomicInteger atomicInteger = new AtomicInteger();
    private BlockingQueue<String> blockingQueue = null;
    private volatile boolean flag = true;

    public ShareResource2(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void produce() throws InterruptedException {
        int i = atomicInteger.incrementAndGet();
        String data = String.valueOf(i);

        while (flag) {
            boolean isSuccess = blockingQueue.offer(data, 2, TimeUnit.SECONDS);
            if (isSuccess) {
                System.out.println(Thread.currentThread().getName() + "\t往队列中追加数据: " + data + " 成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t往队列中追加数据: " + data + " 失败");
            }
            TimeUnit.SECONDS.sleep(2);
        }
        System.out.println(Thread.currentThread().getName() + "\t大老板叫停了,flag=false,生产动作结束");
    }

    public void consume() throws InterruptedException {
        while (flag) {
            String data = blockingQueue.poll(2, TimeUnit.SECONDS);
            //String data = blockingQueue.poll();
            if (data == null || "".equals(data)) {
                System.out.println(Thread.currentThread().getName() + "\t超过2秒钟没有取到数据,消费退出");
                break;
            }
            System.out.println(Thread.currentThread().getName() + "\t从队列消费数据: " + data + " 成功");
        }
    }

    public void stop() {
        this.flag = false;
    }
}

