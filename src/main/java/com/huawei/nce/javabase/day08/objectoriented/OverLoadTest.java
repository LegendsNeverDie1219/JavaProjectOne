package com.huawei.nce.javabase.day08.objectoriented;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/19 15:52
 */
public class OverLoadTest {
    /**
     * 1.方法的重载: 一个类中如果存在方法名相同,但是参数列表不同的众多方法.则这些方法之间叫做重载
     * 2.可变个数的形参:
     * jdk1.5 新增的内容, 本质是形参中传入了某一种类型的数组而已.编译器优化为了 String ... 的结构.
     *   具体使用:
     *     2.1 形式  数据类型 ... 变量名
     *     2.2 调用的地方可以传入0~n该类型的实参.
     *     2.3 不可以存在方法名相同,形参为可变类型以及该类型的数组 的两个方法
     *     2.4可变形参必须在末尾,并且参数列表中只能有一个可变形参.
     *
     * @param args args
     */
    public static void main(String[] args) {
     OverLoadTest overLoadTest = new OverLoadTest();
     overLoadTest.show("aaa");
     overLoadTest.show("aaa", "bbb");
     overLoadTest.show("aaa", "bbb", "ccc");
    }
    public void show (String str) {
        System.out.println("show (String str)" +str);
    }

    public void show(String str1, String str2) {
        System.out.println("show(String str1, String str2)" + str1 + "," + str2);
    }

    public void show (String ... str) {
        System.out.println("show (String ... str)" + str[0] + "," + str[1] + "," + str[2]);
    }

    public void show (int[] str) {
        System.out.println("show (String[] str)");
    }
}
