package com.huawei.nce.java8.Stream;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

/**
 * TODO
 *
 * @author Administrator
 * @date 2020/9/13 15:55
 */
public class TestString {
    public static final  char value[] = {'a', 'b', 'c', 'd'};
    /***
     * String API :
     * 1.基本操作方法
     * 2.字符串比较
     * 3.字符串与其他数据类型之间的转换
     * 4.字符与字符串的查找
     * 5.字符串的截取与拆分
     * 6.字符串的替换与修改
     **/
    // 基本操作方法
    @Test
    public void test1() {
        // 1.获取字符串的长度
        String str = "abcdef";
        System.out.println("字符串的长度为: " + str.length());
        // 2.获取字符串中第i个字符
        System.out.println("字符串中第3个字符为: " + str.charAt(2));
        // 3.获取字符串中起始位置到终止位置(左闭右开)中的字符
        char[] chars = new char[80];
        str.getChars(1,3,chars,0);
        System.out.println(chars);
    }
    // 字符串比较
    @Test
    public void test2() {
        String str1 = "elephants";
        String str2 = "ELEPHANTS";
        String str3 = "Apple";
        String str4 = "apple";
        // 1.不忽略大小写字符串的大小比较(每一个字符按照字典顺序逐个进行比较)
        // 我们比较常用的类像 String Integer 都是实现了Comparable排序接口,重写了compareTo()方法
        // 我们自己定义的类的如果也想支持排序,一般是实现Comparator比较器接口(函数式接口),重写compare()方法
        if (str1.compareTo(str2) > 0) {
            System.out.println(str1 + " > " + str2);
        } else if (str1.compareTo(str2) == 0) {
            System.out.println(str1 + " = " + str2);
        } else {
            System.out.println(str1 + " < " + str2);
        }
        // 2.忽略大小写字符串的大小比较
        if (str1.compareToIgnoreCase(str2) > 0) {
            System.out.println(str1 + " > " + str2);
        } else if (str2.compareToIgnoreCase(str2) == 0) {
            System.out.println(str1 + " = " + str2);
        } else {
            System.out.println(str1 + " < " + str2);
        }
        //3.不忽略大小写判断字符串是否相等
        if (str3.equals(str4)) {
            System.out.println(str3 + " = " +str4);
        } else {
            System.out.println(str3 + " != " +str4);
        }
        // 4.忽略大小写判断字符串是否相等
        if (str3.equalsIgnoreCase(str4)) {
            System.out.println(str3 + " = " +str4);
        } else {
            System.out.println(str3 + " != " +str4);
        }
    }
   //  字符串与其他数据类型之间的转换
    @Test
    public void test3() {
        System.out.println("字符串转化为boolean类型: " + Boolean.parseBoolean("true"));
        System.out.println("字符串转化为boolean类型2: " + Boolean.valueOf("true").booleanValue());
        System.out.println("字符串转化为int类型1: "+ Integer.parseInt("100"));
        System.out.println("字符串转化为int类型2: " + Integer.valueOf("200").intValue());
        System.out.println("字符串转化为char类型: " + "abc".charAt(1));
        System.out.println("字符串转化为字符数组: " + "abc".toCharArray());
    }
    // 字符与字符串的查找
    @Test
    public void test4() {
        String str = "How qi bocome handsome like qi ge"; //定义一个长字符串
        System.out.println("第一个空格字符所在的索引: " + str.indexOf(" "));
        System.out.println("索引4以后第一个空格字符所在的索引: " + str.indexOf(' ',4));
        System.out.println("最后一个空格字符所在的索引: " + str.lastIndexOf(" "));
        System.out.println("索引10以前最后一个空格字符所在的索引: " + str.lastIndexOf(' ',10));
        System.out.println("子字符串qi第一次出现位置的索引: " + str.indexOf("qi"));
        System.out.println("索引5以后子字符串第一次出现位置的索引: " + str.indexOf("qi",5));
        System.out.println("字符串qi最后一次出现位置的索引: " + str.lastIndexOf("qi"));
        System.out.println("索引号5之前子字符串qi最后一次出现位置的索引号为："+str.lastIndexOf("qi",5));
    }
    // 字符串的截取与拆分
    @Test
    public void test5() {
        String str = "How to cut and split  strings"; //定义字符串
        // 截取subString() 左闭右开
        System.out.println("截取字符串中第一个单词: " + str.substring(0,str.indexOf(" ")));
        System.out.println("截取字符串中最后一个单词: " + str.substring(str.lastIndexOf(" ")));
        //拆分:split()
        System.out.println("拆分字符串");
        // 正则中用 \s 匹配任何空白字符, \s+是匹配一个或者多个空白字符 因为反斜杠在java中是转义字符,所以要用 \\s+
        System.out.println(str);
        String newStr = str.replaceAll("\\s+", " ");
        System.out.println(newStr);
        String[] strArr = newStr.split(" ");
        for (String s : strArr) {
             System.out.print(s + " ");
            //System.out.print(s+System.lineSeparator());
        }
    }
    // 字符串的替换与修改
    @Test
    public void test6() {
        String str1 = "hello";
        String str2 = "world";
        String str3 = "nihao";
        System.out.println("字符串的拼接1: " + str1.concat(" ").concat(str2).concat(" ").concat(str3));
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("字符串的拼接2: " + stringBuilder.append(str1).append(" ").append(str2).append(" ").append(str3).toString());
        System.out.println("字符串的拼接3: ==================================");
        List<String> stringList = Lists.newArrayList("hello", "world", "nihao");
        Optional.ofNullable(stringList).ifPresent(strings -> System.out.println(String.join(" ", strings)));
        System.out.println("字符串的拼接4: =======================");
        List stringList2 = null;
        Optional<String> s = Optional.ofNullable(stringList).map(strings -> String.join(",", strings));
        if (!s.equals(Optional.empty()) ) {
            System.out.println(s.get());
        }
        System.out.println("大小写转化");
        System.out.println(str1.toLowerCase().toUpperCase());
        System.out.println("1111111111111");
    }
    @Test
    public void test7() {
        char[] values = {'a', 'b', 'c', 'd'};
    }
}
