package com.huawei.nce.javabase.day11.objectoriented.object;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/28 22:01
 */
public class CloneTest {
    /**
     * 浅拷贝和深拷贝的关系
     * 浅拷贝:
     * 即要进行复制的对象实现了cloneable形式接口, 以及重写了Object根父类的clone()方法
     * 这个时候, 复制后的对象中所有属性值都与原始对象一致.
     * 如果对象中的属性类型是引用类型
     * 如果对象中的属性类型是基本类型.则复制对象会基于原始对象拷贝一份属性数据.
     * 如果对象中的属性类型是引用类型,则复制对象和原始对象的引用都指向堆空间中的同一个对象.
     *
     * 深拷贝:
     * 如果想实现深拷贝,
     * 则需要对象中的引用类型的属性也实现cloneable形式接口,重写Object根父类的clone() 方法
     * 同时,该对象重写的clone()方法中
     * 对象本身先调用根父类的clone()方法. 得到拷贝对象
     * 然后对象的引用类型的属性再调用Object的clone()方法. 得到复制后的属性. 然后再将属性值赋值给拷贝对象的该属性名.
     *
     * @param args args
     */
    public static void main(String[] args) {
        Address address = new Address("home", "北京");

        Person person = new Person("乔峰", 20, address);
        Person clonePerson = null;
        try {
            clonePerson = (Person) person.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(person == clonePerson);

        assert clonePerson != null;
        clonePerson.getAddress().setType("office");
        clonePerson.getAddress().setValue("上海");

        System.out.println(person);
        System.out.println(clonePerson);
    }
}

