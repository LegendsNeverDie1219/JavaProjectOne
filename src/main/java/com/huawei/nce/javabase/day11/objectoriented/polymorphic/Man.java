package com.huawei.nce.javabase.day11.objectoriented.polymorphic;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/27 22:49
 */
public class Man extends  Person{
    @Override
    public void eat() {
        System.out.println("男人应该多吃");
    }
    public void earnMoney() {
        System.out.println("男人应该挣钱");
    }
}
