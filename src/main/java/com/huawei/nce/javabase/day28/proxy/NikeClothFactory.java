package com.huawei.nce.javabase.day28.proxy;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/11/13 21:43
 */
public class NikeClothFactory implements ClothFactory{
    @Override
    public void produceCloth() {
        System.out.println("NIke 工厂生产衣服");
    }
}
