package com.huawei.nce.javabase.day11.objectoriented.polymorphic;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/27 23:02
 */
public class AnimalTest {
    public static void main(String[] args) {
        AnimalTest animalTest = new AnimalTest();
//        Dog dog = new Dog();
//        animalTest.function(dog);
//        Cat cat = new Cat();
//        animalTest.function(cat);
//
        Animal animal1 = new Dog();
        animalTest.function(animal1);
        System.out.println("=============");
        Animal animal2 = new Cat();
        animalTest.function(animal2);
        System.out.println("===========================");
        System.out.println(animal1.name);
        System.out.println(animal2.name);
        Dog dog = new Dog();
        System.out.println(dog.name);
        Cat cat = new Cat();
        System.out.println(cat.name);
    }


    public void function(Animal animal) {
        animal.eat();
        animal.shout();
    }

//    public void function(Dog dog) {
//        dog.eat();
//        dog.shout();
//    }
//    public void function(Cat cat) {
//        cat.eat();
//        cat.shout();
//    }

    private static class Animal{
        private String  name = "animal";
        public void eat() {
            System.out.println("animal eat");
        }

        public void shout() {
            System.out.println("animal shout");
        }
    }

    private static class Dog extends  Animal {
        private String  name = "dog";
        @Override
        public void eat() {
            System.out.println("狗吃狗粮");
        }
        @Override
        public void shout() {
            System.out.println("dog wang wang wang");
        }
    }

    private static class Cat extends  Animal {
        private String  name = "cat";
        @Override
        public void eat() {
            System.out.println("猫吃鱼");
        }

        @Override
        public void shout() {
            System.out.println("cat miao miao miao");
        }
    }
}
