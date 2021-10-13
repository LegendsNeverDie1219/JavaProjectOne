package com.huawei.nce.javabase.day20;

import org.junit.jupiter.api.Test;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/7 20:33
 */
public class StringTest {
    /**
     * 1.String声明为final,表示这个类是不可以被继承的.(即该有的方法的jdk开发者都已经写完了.不需要再拓展了)
     * 2.String实现了三个接口 implements java.io.Serializable, Comparable<String>, CharSequence
     *  实现Serializable接口,表示字符串是可以被序列化的
     *  实现Comparable接口,表示字符串是可以比较大小的
     *  实现CharSequence接口 表示String是一个字符序列.(StringBuffer,StringBuilder也都实现了.)
     *  3.String内部定义了一个private final char value[]的字符数组. 导致了string是一个不可变的字符序列
     *  原因:
     *  该value属性为private并且没有提供对应的set方法,所以在外部一旦初始化了一个String对象之后,就无法修改了
     *  同时该value属性被final修饰,即在内部一旦value对应的字符数组初始化赋值以后, 这个value引用就不能再指向其他数组了.
     *  体现:
     *  当对字符串重新赋值时,需要重新指定内存区域赋值,不能修改原有的value[]
     *  当对现有的字符串进行连接操作.替换操作.都需要重新指定内存区域赋值,不能修改原有的value[]
     *  4.通过字面量的方式(区别于new) 给一个字符串赋值,此时字符串值的声明是在方法区的字符串常量池中
     *  5.字符串常量池中不会存储相同内容的字符串
     *
     */
    @Test
    public void test1() {
        // 字面量的定义方式
        String str1 = "abc";
        String str2 = "abc";
        str1 = "hello";
        // false
        System.out.println(str1 == str2);
        // hello
        System.out.println(str1);
        // abd
        System.out.println(str2);
    }

    @Test
    public void test2() {
        String original = "hello";
        // 本质:this.value = new char[0];
        String s1 = new String();
        // this.value = original.value
        String s2 = new String(original);
        System.out.println(s2);
        char[] charArr = new char[]{'h','d','s','1','2','3'};
        //   this.value = Arrays.copyOf(value, value.length);
        String s3 = new String(charArr);
        System.out.println(s3);
        //  this.value = Arrays.copyOfRange(value, offset, offset+count);
        String s4 = new String(charArr, 2,3);
        System.out.println(s4);
    }
    @Test
    public void test3() {
        // 1.通过字面量的方式给一个字符串赋值, 此时字符串值的声明是在字符串常量池中
        String s1 = "javaEE";
        String s2 = "javaEE";
       // 2.通过new对象的方式给一个字符串赋值.首先会在堆内存中new一个String对象
        //然后会去字符串常量池查看是否存在对应内容的字符数组.
        // 如果存在,则将常量池中的字符数组的地址值赋值给String对象的字符数组类型的引用value
        // 如果不存在,则会在常量池中声明一个对应内容的字符数组.
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");

        //true
        System.out.println(s1 == s2);
        //false

        System.out.println(s1 == s3);
        //false

        System.out.println(s1 == s4);
        //false
        System.out.println(s3 == s4);
    }
    @Test
    public void test4() {
        String s1 = "javaEE";
        String s2 = "hadoop";
        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        // 反编译后的结果: new StringBuilder().append(s1).append("hadoop").toString();
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;
        // true
        System.out.println(s3 == s4);
        // false
        System.out.println(s3 == s5);
        // false
        System.out.println(s3 == s6);
        // false
        System.out.println(s3 == s7);
        // false
        System.out.println(s5 == s6);
        // false
        System.out.println(s5 == s7);
        // false
        System.out.println(s6 == s7);
        //str.intern() 会得到字符串对象在常量池中的引用
        // 如果该字符串对象在常量池中不存在,则会将该字符串添加到常量池中,然后返回.
        System.out.println(s3 == s5.intern());
        /**
         * 结论:
         * 字符串拼接过程中,常量与常量拼接的结果再常量池中
         * 只要有一个变量,就会new一个对象,其结果就是在堆中.
         */
    }

    String str = new String("good");
    char[] ch = {'t','e','s','t'};

    public static void main(String[] args) {
        StringTest stringTest = new StringTest();
        stringTest.change(stringTest.str, stringTest.ch);
        // "good" String的不可变性
        System.out.println(stringTest.str);
        // best
        System.out.println(stringTest.ch);
    }

    private void change(String str, char[] ch) {
        str = "test ok";
        ch[0]='b';
    }
}
