package com.huawei.nce.java8.myinterface;

/**
 * TODO
 *
 * @author Administrator
 * @date 2022/11/3 11:13
 */
/**
 * @Author: posper
 * @Date: 2022/07/20 15:49
 */
public class FunctionalInterfaceTest {
    public static void main(String[] args) {
        Animal dog = new Dog();
        // 超类优先，所以这里调用的是父类 Animal 中的 run() 方法
        dog.run();
    }
}

// 验证“超类优先原则”，见 main() 中 dog.run() 方法.
class Dog extends Animal implements Run {
    int age;
    String name;
}

// 接口
@FunctionalInterface
interface Run {
    void run();

    // 这里类比 Comparator 中的 equals，`@FunctionalInterface` 不会将其不算作抽象方法
    @Override
    boolean equals(Object o);
}

// 父类
class Animal {
    public void run() {
        System.out.println("调用Animal的run()方法");
    }
}
