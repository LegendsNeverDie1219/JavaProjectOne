package com.huawei.nce.myinterface;

/**
 * TODO
 *
 * @author Administrator
 * @date 2020/9/7 21:29
 */
//供给型接口 (无参数,有返回值)
@FunctionalInterface
public interface MySupplier<T> {
    T get();
}
