package com.huawei.nce.javabase.day14.abstracttest;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/1 15:56
 */
public class AbstractTest {
    /**
     * abstract关键字的使用
     * 1.abstract: 抽象的
     * 2.abstract可以用来修饰类, 方法
     * 3.abstract 修饰的类 -> 抽象类
     *    此类不能被实例化.
     *    但是提供了构造方法,目的是便于子类实例化的时候调用(涉及: 子类实例化的全过程)
     * 4.abstract 修饰的方法  -> 抽象方法
     *    > 抽象方法只有方法的声明,没有方法体
     *    > 包含抽象方法的类一定是一个抽象类, 但是抽象类中可以没有抽象方法
     *    > 若子类重写了父类中的所用抽象方法,该子类才能被实例化, 否则该子类依然是一个抽象类.
     *
     */
}

abstract class Person {

    public void eat() {
        System.out.println("eat");
    }

    public abstract void walk();

    public abstract void sleep();
}

abstract class Man extends  Person {

    @Override
    public void sleep() {

    }
}

