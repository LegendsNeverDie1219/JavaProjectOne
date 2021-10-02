package com.huawei.nce.javabase.day11.objectoriented.polymorphic;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/28 8:04
 */
public class InterviewTest1 {
    public static void main(String[] args) {
        Base base = new Sub();
        // sub_1  多态,虚拟方法调用(调用子类重写的)
        base.add(1, 2, 3);

        Sub s = (Sub) base;
        // sub_2 方法重载,优先调用形参个数确定的方法.
        s.add(1,2, 3);
    }
}

class Base {
    public void add(int a, int ... arr) {
        System.out.println("base");
    }
}

class Sub extends Base{
    @Override
    public void add(int a, int[] arr) {
        System.out.println("sub_1");
    }

    public void add(int a, int b, int c) {
        System.out.println("sub_2");
    }
}