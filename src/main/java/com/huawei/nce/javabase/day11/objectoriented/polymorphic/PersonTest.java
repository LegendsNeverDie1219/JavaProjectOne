package com.huawei.nce.javabase.day11.objectoriented.polymorphic;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/27 22:52
 */
public class PersonTest {
    public static void main(String[] args) {
        Person person = new Person();
        person.eat();

        System.out.println("===================");
        Person person2 = new Man();
        person2.eat();
        System.out.println("==================");
        Person person3 = new Woman();
        person3.eat();
        person3.walk();
    }
}
