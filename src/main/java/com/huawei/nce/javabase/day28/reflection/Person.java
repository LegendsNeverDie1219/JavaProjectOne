package com.huawei.nce.javabase.day28.reflection;


import lombok.ToString;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/11/13 17:19
 */
@MyAnnotation(value = "hi", valueArray = {"hds", "zl"})
@ToString
public class Person extends Creature<String> implements Comparable<Person>,MyInterface {
    private String name;
    int age;
    public int id;
    public Person() {
    }

    @MyAnnotation(value = "abc", valueArray = {"123", "456"})
    private Person(String name) {
        this.name = name;
    }
    @Override
    public int compareTo(Person o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("我是一个人 info");
    }

    private String show(String nation) {
        System.out.println("我的国籍是: " + nation);
        return nation + "666";
    }

    public String display(String interests) {
        return interests;
    }
    @MyAnnotation(value = "abc", valueArray = {"123", "456"})
    public String convertString(String str1, Integer str2, int age) throws IndexOutOfBoundsException,ClassCastException{
        return null;
    }
}
