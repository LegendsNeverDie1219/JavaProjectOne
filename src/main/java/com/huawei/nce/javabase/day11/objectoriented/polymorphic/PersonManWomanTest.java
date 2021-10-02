package com.huawei.nce.javabase.day11.objectoriented.polymorphic;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/27 22:52
 */
public class PersonManWomanTest {
    public static void main(String[] args) {
        Person person = new Person();
        person.eat();

        System.out.println("===================");
        Person person2 = new Man();
        person2.eat();
        if (person2 instanceof  Man) {
            Man man = (Man)person2;
            man.earnMoney();
            System.out.println("man====================");
            // java.lang.ClassCastException
            // Woman woman = (Woman) person2;
            // woman.goShopping();
        }

        if(person2 instanceof Person) {
            System.out.println("person====================");
        }

        System.out.println("==================");
        Person person3 = new Woman();
        person3.eat();
        person3.walk();
    }
}
