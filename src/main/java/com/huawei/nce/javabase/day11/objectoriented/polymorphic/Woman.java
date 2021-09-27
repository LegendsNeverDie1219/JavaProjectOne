package com.huawei.nce.javabase.day11.objectoriented.polymorphic;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/27 22:51
 */
public class Woman extends  Person{
    @Override
    public void eat() {
        System.out.println("女人应该少吃,减肥");
    }
    public void goShopping() {
        System.out.println("女人喜欢逛街");
    }
}
