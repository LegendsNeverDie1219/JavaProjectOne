package com.huawei.nce.javabase.day14.statictest;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/1 11:01
 */
public class StaticTest {
    /**
     * static 关键字 静态的
     * 可以修饰属性,方法,代码块,内部类这些结构 .表示这些结构是随着类的加载而加载, 存的位置是方法区静态域
     * static修饰属性,方法,可以直接通过类名.属性/方法的形式掉员工,不需要通过new 对象就可以调用
     *    static修饰属性 ,表示这些属性是在内存空间中只有一份,并且被所有该类的对象所共享
     *    static修饰方法,其中该方法体内只能调用的静态的属性和静态的方法
     *                  并且不能是用this/super关键字.可以从类/静态属性的声明周期和对象的声明周期去理解
     */
    public static void main(String[] args) {
        String nation = Chinese.nation;
        System.out.println(nation);

        Chinese.show();
    }

}

class Chinese {
    private String name;
    private int age;
    static String nation = "中国人";

    @Override
    public String toString() {
        return "Chinese{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void show () {
        System.out.println("我是一个: " + nation);
       // System.out.println(name + age);
    }
}