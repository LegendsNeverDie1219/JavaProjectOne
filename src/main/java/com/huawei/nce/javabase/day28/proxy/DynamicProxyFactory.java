package com.huawei.nce.javabase.day28.proxy;

import java.lang.reflect.Proxy;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/11/13 22:03
 */
public class DynamicProxyFactory {
    /**
     * 通过此方法,传入一个被代理的对象.生成一个代理的对象,解决问题一
     * @param obj 被代理的对象
     * @return 生成一个代理的对象
     */
    public static Object getProxyInstance(Object obj) {
        MyInvocationHandler invocationHandler = new MyInvocationHandler();
        invocationHandler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
                invocationHandler);
    }
}
