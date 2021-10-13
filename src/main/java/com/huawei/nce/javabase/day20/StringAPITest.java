package com.huawei.nce.javabase.day20;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/7 22:49
 */
public class StringAPITest {
    /**
     *  int length()：返回字符串的长度： return value.length
     *  char charAt(int index)： 返回某索引处的字符return value[index]
     *  boolean isEmpty()：判断是否是空字符串：return value.length == 0
     *  String toLowerCase()：使用默认语言环境，将 String 中的所有字符转换为小写
     *  String toUpperCase()：使用默认语言环境，将 String 中的所有字符转换为大写
     *  String trim()：返回字符串的副本，忽略前导空白和尾部空白
     *  boolean equals(Object obj)：比较字符串的内容是否相同
     *  boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大
     * 小写
     *  String concat(String str)：将指定字符串连接到此字符串的结尾。 等价于用“+”
     *  int compareTo(String anotherString)：比较两个字符串的大小
     *  String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从
     * beginIndex开始截取到最后的一个子字符串。
     *  String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字
     * 符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。
     * **/
    @Test
    public void test1() {
        String s1 = "hello";
        // h
        System.out.println("str.charAt(index): " + s1.charAt(0));
        // StringIndexOutOfBoundsException: String index out of range: 10
        // System.out.println("str.charAt(index): " + s1.charAt(10));
        String s5 = "abc";
        String s6 = new String("abe");
        // -2
        System.out.println("str.compareTo(anotherStr):" + s5.compareTo(s6));

        String s7 = "北京尚硅谷教育";
        String s8 = s7.substring(2);
        System.out.println(s7);
        // 尚硅谷教育
        System.out.println("str.subString(beginIndex):" + s8);
        // 尚硅谷
        String s9 = s7.substring(2, 5);
        System.out.println("str.subString(beginIndex,endIndex):" + s9);
    }

    /**
     *      *  boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
     *      *  boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始
     *      *  boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的
     *      * 子字符串是否以指定前缀开始
     *      * <p>
     *      * <p>
     *      * boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列
     *      * 时，返回 true
     *      *  int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
     *      *  int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出
     *      * 现处的索引，从指定的索引开始
     *      *  int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
     *      *  int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后
     *      * 一次出现处的索引，从指定的索引开始反向搜索
     *      * 注：indexOf和lastIndexOf方法如果未找到都是返回-1
     */
    @Test
    public void test2() {
        String str1 = "helloworldlor";
        // true
        System.out.println(str1.startsWith("he"));
        // false
        System.out.println(str1.startsWith("He"));
        //true
        System.out.println(str1.startsWith("ll", 2));
        //true

        String str2 = "wor";
        System.out.println(str1.contains(str2));
        System.out.println("=================");
        // 3
        System.out.println("str.indexOf(str/char): " + str1.indexOf("lo"));
        // -1
        System.out.println("str.indexOf(): " + str1.indexOf("lol"));
        // 10
        System.out.println("str.indexOf(str/char, fromIndex): " + str1.indexOf("lo", 5));
        // 11
        System.out.println("str.indexOf(str/char, fromIndex): " + str1.lastIndexOf("or"));
        // -1
        System.out.println("str.indexOf(str/char, fromIndex): " + str1.lastIndexOf("or", 3));
        System.out.println(str1.length());
    }

    /**
     *      * String replace(char oldChar, char newChar)：返回一个新的字符串，它是
     *      * 通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
     *      *  String replace(CharSequence target, CharSequence replacement)：使
     *      * 用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
     *      *  String replaceAll(String regex, String replacement) ： 使 用 给 定 的
     *      * replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
     *      *  String replaceFirst(String regex, String replacement) ： 使 用 给 定 的
     *      * replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
     */
    @Test
    public void test3() {
        String str = "12hello34world5java7891mysql456";
        //  正则表达式中,\d 匹配一个数字字符。等价于 [0-9]
        // /把字符串中的数字替换成,，如果结果中开头和结尾有，的话去
        String anotherStr = str.replaceAll("\\d+", ",")
                .replaceAll("^,|,$", "");
        System.out.println(anotherStr);

        String str2 = "12345";
        //判断str字符串中是否全部有数字组成，即有1-n个数字组成
        boolean matches = str2.matches("\\d+");
        System.out.println(matches);

        String tel = "0571-4534289";
        // 判断这是否是一个杭州的固定电话
        boolean result = tel.matches("0571-\\d{7,8}");
        System.out.println(result);
    }

    /*
     *  boolean matches(String regex)：告知此字符串是否匹配给定的正则表达式。
     * <p>
     *  String[] split(String regex)：根据给定正则表达式的匹配拆分此字符串。
     *  String[] split(String regex, int limit)：根据匹配给定的正则表达式来拆分此
     * 字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中。
     */
    @Test
    public void test4() {
        String str = "hello|world|java";
        // 正则表达式中包含“|”时，用“\\|“代替，
        // 因为“|”在正则表达式中有或的含义，需要转义"\|"，“\“也需要转义，所以最后应该用“\\|”代替。
        String[] splitedArr = str.split("\\|");
        for (int i = 0; i < splitedArr.length; i++) {
            System.out.println(splitedArr[i]);
        }

        System.out.println();
        String str2 = "hello.world.java";
        String[] strs2 = str2.split("\\.");
        for (int i = 0; i < strs2.length; i++) {
            System.out.println(strs2[i]);
        }
    }
    
    @Test
    public void test5() throws UnsupportedEncodingException {
        // 字符串  -> 基本数据类型 ,包装类.   包装类.parseInt(String s)
        // 基本数据类型 ,包装类 ->字符串  String.valueOf(int n)
        String numberStr = "666";
        int number = Integer.parseInt(numberStr);
        String numberStr2 = String.valueOf(number);
        System.out.println(numberStr2);
        System.out.println("=====================================");
        // 字符串   -> 字符数组
        // str.toCharArray()  str.getChars(int srcBegin,int srcEnd,char[] dst,int dstBegin)
        // 字符数组  -> 字符串   String(char[]), String(char[],int offset,int length)
        String s = "abc123";
        char[] chars = s.toCharArray();
        // [a, b, c, 1, 2, 3]
        System.out.println(Arrays.toString(chars));
        char[] arr = new char[] {'h','e','l','l','o'};
        String s1 = new String(arr);
        String s2 = new String(arr,1,3);
        // hello
        System.out.println(s1);
        // ell
        System.out.println(s2);
        System.out.println("=====================================");
        // 字符串  -> 字节数组  str.getBytes();/str.getBytes(String charsetName)
        // 使用平台默认的字符集/指定的将该字符串编码成byte序列,并存入到一个字节数组中
        // 字节数组  -> 字符串  String(byte[] bytes)
        // String(byte[] bytes,int offset,int length) 即从数组起始位置offset开始取length个字节构造一个字符串对象。
        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes();
        // [97, 98, 99, 49, 50, 51, -28, -72, -83, -27, -101, -67]
        System.out.println(Arrays.toString(bytes));

        String str2 = new String(bytes);
        System.out.println(str2);

        /**
         * 编码: 字符串转化为字节数组, (看的懂的字符串 -> 看不懂的二进制)
         * 解码: 字节数组 转化为字符串(调用String()的构造器)
         * 要求解码的字符串和编码的字符集必须保持一致,否则会出现乱码.
         */
        // UnsupportedEncodingException
        byte[] bytes1 = str1.getBytes("GBK");
        // [97, 98, 99, 49, 50, 51, -42, -48, -71, -6]
        System.out.println(Arrays.toString(bytes1));
        String str3 = new String(bytes1,"gbk");
        // abc123中国
        System.out.println(str3);
    }
}
