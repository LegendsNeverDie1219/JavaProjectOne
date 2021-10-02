package com.huawei.nce.javabase.day11.objectoriented.polymorphic;

import java.util.Random;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/28 7:50
 */
public class InterviewTest {
    public static void main(String[] args) {
        // [0,3)
        int key = new Random().nextInt(3);
        System.out.println("key: " + key);
        Animal animal = getInstance(key);
        animal.eat();
    }

    private static Animal getInstance(int key) {
        Animal animal;
        switch (key) {
            case 0: {
                animal = new Cat();
                break;
            }
            case 1: {
                animal = new Dog();
                break;
            }
            default: {
                animal = new Sheep();
                break;
            }
        }
        return animal;
    }
}

class Animal {
    protected void eat() {
        System.out.println("animal eat food");
    }
}

class Cat extends Animal {
    @Override
    protected void eat() {
        System.out.println("cat eat fish");
    }
}

class Dog extends Animal {
    @Override
    protected void eat() {
        System.out.println("dog eat bone");
    }
}

class Sheep extends Animal {
    @Override
    protected void eat() {
        System.out.println("sheep eat grass");
    }
}
