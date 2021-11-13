package com.huawei.nce.javabase.day28.proxy;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/11/13 21:48
 */
public class StaticProxyTest {
    /**
     * 代理模式:
     * 首先有一个接口.代理类和原始类都是要实现这个接口
     * 代理类会将原始类包装起来.用代理类来代替原始类.
     * 凡是要调动原始类的一些方法的时候,都要通过代理类来实现.
     *
     * 静态代理的特点:
     * 代理类和被代理类在编译期间就确定下来了.
     * 缺点: 每一个代理类只能为一个接口服务. 这样势必会产生很多接口.
     * @param args args
     */
    public static void main(String[] args) {
        // 1.创建被代理的对象
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        // 2创建代理对象
        ClothFactory clothFactory = new ProxyClothFactory(nikeClothFactory);
        clothFactory.produceCloth();
    }
}
