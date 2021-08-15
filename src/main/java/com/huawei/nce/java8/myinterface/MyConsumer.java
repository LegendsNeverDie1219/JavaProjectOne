package com.huawei.nce.myinterface;

/**
 * TODO
 *
 * @author Administrator
 * @date 2020/9/7 21:26
 */
//消费型接口(有参数,无返回值,经常用于迭代)
@FunctionalInterface
public interface MyConsumer<T> {
    void accept(T t);
}
