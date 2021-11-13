package com.huawei.nce.javabase.day28.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/11/13 22:27
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object originObj;
    public void bind(Object originObj) {
        this.originObj = originObj;
    }
    @Override
    // proxy 代理对象  method: 代理对象/被代理对象对应接口中的方法对象, 代理对象/被代理对象对应接口中的方法的形参,
    // 当通过代理类对象调用方法a的时候,会自动去调用重写InvocationHandler接口的invoke()方法
    // 而invoke方法内部本质是调用原始对象的同名接口方法
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 动态代理增加通用的方法1
        HumanUtils.publicMethod1();
        // 回调目标(原始)对象的方法
        Object invoke = method.invoke(originObj, args);
        // 动态代理增加通用的方法2
        HumanUtils.publicMethod2();
        return invoke;
    }
}
