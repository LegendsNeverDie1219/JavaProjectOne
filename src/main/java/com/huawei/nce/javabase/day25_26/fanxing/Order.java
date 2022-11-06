package com.huawei.nce.javabase.day25_26.fanxing;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/28 22:26
 */
@Getter
@Setter
//public class Order<T, K,V> {
public class Order<T> {
    /**
     * 泛型类的说明:
     * 1. 泛型类可能有多个参数,此时需要将多个参数都放置到<>中,用,隔开
     *  如: Order<E1,E2,E3>
     *  2.泛型的构造无参构造器 依然不变
     *  3. 泛型不同的引用之间不能相互赋值
     *   尽管编译的时候ArrayList<String> 和ArrayList<Integer>是两种类型,但是
     *   在运行的时候只有一个ArrayList被加载到JVM中了.
     *   4.泛型如果不指定,将会被擦除. 此时泛型对应的类型都是按Object处理. 但不等于Object.
     *   比如 : Order Order = new Order();
     *  5.jdk1.7 引入了类型推断的新特性
     *  原来 :List<String> list = new ArrayList<String>();
     *  现在: List<String> list = new ArrayList<>();
     *  6.静态方法中不能使用泛型.
     *  原因:
     *  类的泛型指定的时间: 在new实例的时候指定
     *  静态方法: 在类加载的时候就一起加载了.
     */
    private String orderName;
    private int orderId;

    // 类的内部结构就可以使用类的泛型
    T orderT;

   // T[] arr1 = new T[10];
    private T[] arr = (T[]) new Object[10];

    public Order() {
    }

   // public Order<String,Integer,Object>() {
   // }

    public Order(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T  orderT) {
        this.orderT = orderT;
    }
    // 静态方法中不能使用泛型类的结构.
    //Order.this' cannot be referenced from a static context
//    public static void show (T orderT) {
//        System.out.println(orderT);
//    }
    // 泛型方法: 在方法中出现了泛型结构, 方法中的泛型参数 跟类中的泛型参数 没有任何联系
    // 即 泛型方法所在的类是不是泛型类都可以.
    // 静态方法可以使用泛型方法的结构. 原因: 泛型参数是在调用方法的时候由入参确定的. 并非实例化的时候确定.
    public <E> List<E> copyFromArrayToList(E[] arr) {
        List<E> list = new ArrayList<>();
        for (E e : arr) {
            list.add(e);
        }
        return list;
    }
}
@Setter
@Getter
class SubOrder extends Order<Integer> {
    // 如果子类在继承泛型父类的时候指明了泛型的类型,则子类就是一个普通的类, 不是泛型类.
    private String orderType;
}

@Setter
@Getter
class SubOrder2<T> extends Order<T> {
    // 依然是泛型类.
    private int orderNum;
}