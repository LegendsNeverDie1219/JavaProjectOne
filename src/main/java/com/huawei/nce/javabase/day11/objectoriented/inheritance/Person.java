package com.huawei.nce.javabase.day11.objectoriented.inheritance;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/27 19:55
 */
public class Person {
    private String name;
    private char sex;
    private int age;
    public Person() {}
    public Person(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void eat() {
        System.out.println("人吃饭");
    }

    public void sleep() {
        System.out.println("人睡觉");
    }
    public String work() throws RuntimeException{
        return "人工作";
    }

    private void breathe() {
        System.out.println("人呼吸");
    }

    @Override
    public String toString() {
        return "Person{name = '" + name +"', sex = " + sex + ", age = " + age + "}";
    }
}
