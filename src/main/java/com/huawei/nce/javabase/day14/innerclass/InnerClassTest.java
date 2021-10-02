package com.huawei.nce.javabase.day14.innerclass;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/2 10:50
 */
public class InnerClassTest {
    /**
     * 类的成员变量五: 内部类
     *
     * 1.内部类定义: java中允许将一个类B声明在类A中,其中类B就叫做内部类
     *
     * 2.分类:  成员内部类,  VS局部内部类
     *
     * 3.成员内部类:(静态,非静态)
     *
     * 一方面,作为外部类的一个成员,
     *   > 可以调用外部类的属性,方法
     *   >可以被static修饰
     *   > 可以被四种权限修饰符修饰
     *
     *   另一方面,作为一个类
     *   可以在类内部定义属性,构造器.方法
     *   可以被final修饰,被abstract修饰
     * 4.局部内部类(方法内,代码块内,构造器内)
     *
     * 5.关注三个问题
     * 1.如何实例化成员内部类对象
     * 2.如何在成员内部类中区分是调用内部类的结构.还是外部类的结构
     * 3.开发中局部内部类的使用
     */

    public static void main(String[] args) {
        new Person().check();
        // 静态成员内部类
        Person.Dog dog = new Person.Dog();
        dog.show();
        // 非静态成员内部类
        Person.Bird bird = new Person().new Bird();
        bird.sing();

    }
}

class Person {

    public void check() {
        Dog dog = new Dog();
        dog.show();
    }
    static class Dog {
        public void show() {
            System.out.println("我是一只狗,我会看门");
        }
    }

    class Bird {
        public void sing() {
            System.out.println("我是一只鸟,我会唱歌");
        }
    }
}


