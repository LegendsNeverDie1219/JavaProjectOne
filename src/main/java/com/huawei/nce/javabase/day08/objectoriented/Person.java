package com.huawei.nce.javabase.day08.objectoriented;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/19 16:42
 */
public class Person {
    /**
     * 属性(成员变量) VS 局部变量
     * 相同点:
     * 1. 定义变量的格式  数据类型 变量名 = 变量值;
     * 2.先声明,后使用
     * 3. 变量都有 其对应的作用域,出了作用域,就失效了.
     *
     * 不同点:
     * 1.声明的位置不同
     * 成员变量: 类中方法外,
     * 局部变量: 方法内,方法形参, 代码块内,
     * 2.权限修饰符不同
     * 成员变量: public protected ,default ,private
     * 局部变量: 不可以使用权限修饰符
     * 3.默认的初始值情况
     * 成员变量: 根据数据类型 有默认的初始值
     * 局部变量: 没有默认的初始值,意味着,我们在调用局部变量之前,必须要先显式赋值.
     * 4.在内存中的位置
     * 成员变量: 堆内存中(非static)
     * 局部变量: 栈内存中
     *
     */

    String name;
    int age;
    String sex;

    public void eat() {
        System.out.println("吃饭");
    }
    public void sleep() {
        System.out.println("睡觉");
    }
    public void study() {
        System.out.println("学习");
    }
    public void talk(String language) {
        System.out.println("语言是: " +language);
    }
    public void addAge(int number) {
        age+=number;
    }

    public void showAge() {
        System.out.println("年龄为: " + age);
    }
}
