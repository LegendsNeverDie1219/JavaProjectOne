package com.huawei.nce.javabase.day28.proxy;

import org.junit.jupiter.api.Test;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/11/13 22:27
 */
public class DynamicProxyTest {
    @Test
    public void test() {
        SuperMan superMan = new SuperMan();
        Object proxyInstance = DynamicProxyFactory.getProxyInstance(superMan);
        Human human = (Human)proxyInstance;
        // 当调用代理对象的方法getBelief() .本质是调用的原始代理的getBelief()
        String belief = human.getBelief();
        System.out.println(belief);
        human.eat("四川麻辣烫");
        System.out.println("=================");
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyInstance1 = (ClothFactory)DynamicProxyFactory.getProxyInstance(nikeClothFactory);
        proxyInstance1.produceCloth();

    }
}
