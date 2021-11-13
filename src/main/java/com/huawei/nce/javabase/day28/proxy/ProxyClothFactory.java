package com.huawei.nce.javabase.day28.proxy;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/11/13 21:44
 */
public class ProxyClothFactory implements ClothFactory{
    private ClothFactory clothFactory;
    public ProxyClothFactory(ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }
    @Override
    public void produceCloth() {
        System.out.println("代理衣服工厂做一些准备工作");
        clothFactory.produceCloth();
        System.out.println("代理衣服工厂做一些收尾工作");
    }
}
