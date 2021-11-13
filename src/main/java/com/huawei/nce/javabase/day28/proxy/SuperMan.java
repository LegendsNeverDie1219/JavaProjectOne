package com.huawei.nce.javabase.day28.proxy;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/11/13 21:57
 */
// 被代理类
public class SuperMan implements Human{
    @Override
    public String getBelief() {
        return "I Believe I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃: " + food);
    }
    /**
     * 要实现动态代理,要解决2个问题:
     * 1.如何根据加载到内存中的被代理类.动态的创建一个代理类以及代理类的对象
     * 2.当通过代理类的对象去调用方法A的时候,如何去动态的调用被代理类中同名同参数列表的方法A.
     */
}
