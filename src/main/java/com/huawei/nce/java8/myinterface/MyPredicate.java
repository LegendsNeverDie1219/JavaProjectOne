package com.huawei.nce.myinterface;

/**
 * 定义一个过滤方法的接口
 * 其中类型参数T是在新建一个实现类的时候传过来的
 **/
//判断型接口,返回true/false ,主要是用来判断
@FunctionalInterface
public interface MyPredicate<T> {
    boolean fileter(T t);
}
