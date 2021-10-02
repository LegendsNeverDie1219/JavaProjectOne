package com.huawei.nce.javabase.day14.statictest;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/1 11:47
 */
public class SingletonTest {
    /**
     * 一.单例模式: 即一个类只能创建一个对象
     * 二.如何实现:  饿汉式 VS懒汉式
     * 三. 区别
     * 饿汉式:
     *    坏处: 对象加载时间过长
     *    好处: 线程安全
     * 懒汉式:
     *   坏处: 线程不安全
     *   好处: 延迟对象的创建,优化内存.
     *
     * @param args
     */
    public static void main(String[] args) {
        //com.huawei.nce.javabase.day14.staticpackage.Bank@1d44bcfa
        //com.huawei.nce.javabase.day14.staticpackage.Bank@1d44bcfa
        Bank instance1 = Bank.getInstance();
        System.out.println(instance1);

        Bank instance2 = Bank.getInstance();
        System.out.println(instance2);

        Order instance3 = Order.getInstance();
        System.out.println(instance3);

        Order instance4 = Order.getInstance();
        System.out.println(instance4);
    }
}
// 饿汉式
class Bank {
    // 1.私有个构造方法
    // 2.类内部实例化一个对象
    // 3.暴露公有的静态方法,返回类的对象, 供外部调用

    private Bank () {
    }

    private static Bank bank = new Bank();

    public static Bank getInstance () {
        return bank;
    }
}
// 懒汉式
class Order {
    private  Order() {
    }
    private static Order order = null;

    // 本质: 延迟创建对象,只有当外部调用getInstance()静态方法的时候,才会创建对象
    public static Order getInstance() {
        if (order == null) {
            order = new Order();
        }
        return order;
    }
}