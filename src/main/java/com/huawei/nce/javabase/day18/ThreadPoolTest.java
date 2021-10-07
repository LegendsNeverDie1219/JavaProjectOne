package com.huawei.nce.javabase.day18;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/6 17:24
 */
public class ThreadPoolTest {
    /**
     * 背景:
     *  经常创建和销毁 使用资源特别多的线程,会对性能有很大影响
     *
     * 思路:创建一个线程池, 使用线程时,不用自己创建, 从线程纯池中获取
     *                   用完之后,不用去销毁.把该线程还到线程池中
     * 好处:
     *   ①提高响应速度(创建线程有时会很慢)
     *   ②降低资源消耗(之前一旦使用就需要创建线程,现在可以重复使用,不用再创建了)
     *   ③便于线程管理
     *     corePoolSize :核心池大小
     *     maximumPoolSize:最大线程大小
     *     keepAliveTime 线程没有任务时最多保持多长时间后会终止
     */
    /**
     *  JDK 5.0起提供了线程池相关API：ExecutorService 和 Executors
     *  ExecutorService：真正的线程池接口。常见子类ThreadPoolExecutor
     *  void execute(Runnable command) ：执行任务/命令，没有返回值，一般用来执行
     * Runnable
     *  <T> Future<T> submit(Callable<T> task)：执行任务，有返回值，一般又来执行
     * Callable
     *  void shutdown() ：关闭连接池
     *
     *
     *  Executors：工具类、线程池的工厂类，用于创建并返回不同类型的线程池
     *  Executors.newCachedThreadPool()：创建一个可根据需要创建新线程的线程池
     *  Executors.newFixedThreadPool(n); 创建一个可重用固定线程数的线程池
     *  Executors.newSingleThreadExecutor() ：创建一个只有一个线程的线程池
     *  Executors.newScheduledThreadPool(n)：创建一个线程池，它可安排在给定延迟后运
     * 行命令或者定期地执行。
     * @param args
     */
    public static void main(String[] args) {
        //  ExecutorService extends Executor
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // ThreadPoolExecutor extends AbstractExecutorService
        // public abstract class AbstractExecutorService implements ExecutorService
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
        threadPoolExecutor.setCorePoolSize(15);
        threadPoolExecutor.setMaximumPoolSize(20);
        // 适用于runnable
        executorService.execute(new Window4());

        // 适用于Callable
        executorService.submit(new NumberThread());
        executorService.shutdown();


    }
}
