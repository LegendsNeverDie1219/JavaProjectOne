package com.huawei.nce.javabase.day18;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/6 16:57
 */
public class CallableTest {
    /**
     * JDK5.0新增了创建线程的两种方式
     * 1.实现了Callable接口的步骤
     *  ①新增一个Callable接口的实现类
     *  ②new一个Callable接口的实现类实例
     *  ③new一个FutureTask实例.通过构造方法把CallablleImpl对象传递给futureTask对象
     *  ④new一个线程,通过构造方法把futureTask对象传递给thread对象,并start()
     * 2.实现Callable 接口VS实现Runnable接口
     * 相比run() 方法,call()方法,可以有返回值,可以抛出异常,支持泛型 功能更强大
     * 但是实现Callable接口的方式,需要额外借助FutureTask类.(FutureTask 实现了RunnableFuture接口.
     * Runnable接口继承了Runnable接口,Future接口.)
     * RunnableFuture
     */
    public static void main(String[] args) {
        NumberThread callableImpl = new NumberThread();
        FutureTask<Integer> futureTask = new FutureTask<>(callableImpl);

        new Thread(futureTask).start();

        try {
            Object sum = futureTask.get();
            System.out.println("总和为: " + sum);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class NumberThread implements Callable<Integer> {

    /**
     * Computes a result, or throws an exception if unable to do so.
     * 计算结果，如果无法计算则抛出异常。 计算0-100所有偶数的和.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "-> " + i);
                sum += i;
            }
        }
        return sum;
    }
}
