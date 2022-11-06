package com.huawei.nce.java8.myinterface;

/**
 * TODO
 *
 * @author Administrator
 * @date 2020/9/7 21:19
 */

/***
 * 函数式接口
 **/
@FunctionalInterface
public interface MyFunction<T, R> {
    //ALT+SHIFT+L 自动提取变量
//CTRL+ALT+L 格式化代码
    R apply(T t);
}
