package com.huawei.nce.javabase.day08.objectoriented.encapsulation_inheritance;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/23 20:44
 */
public class Animal {
    private String name;
    private int age;
    private int legs;

    public Animal() {
    }

    public Animal(String name) {
        // Call to 'this()' must be first statement in constructor body
        this();
        this.name = name;
    }

    public Animal(String name, int age, int legs) {
        this.name = name;
        this.age = age;
        this.legs = legs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLegs(int legs) {
        if (legs >= 0 && legs % 2 == 0) {
            this.legs = legs;
        } else {
            this.legs = 0;
        }
    }

    public int getLegs() {
        return legs;
    }
}
