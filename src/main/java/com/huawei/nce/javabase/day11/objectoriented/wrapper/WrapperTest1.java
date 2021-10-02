package com.huawei.nce.javabase.day11.objectoriented.wrapper;

import org.junit.jupiter.api.Test;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/29 20:53
 */
public class WrapperTest1 {
    /**
     * 包装类: 针对八种基本数据类型定义的八种引用数据类型
     * 基本数据类型           包装类
     * byte                 Byte
     * short                Short
     * int                  Integer
     * long                 Long
     * float                Float
     * double               Double
     *
     * boolean              Boolean
     * char                 Character
     */
    @Test
    public void test1() {
        /**
         * 基本数据类型 -> 包装类
         * 1.调用包装类的构造器
         * 2.自动装箱
         */

        int  num1 = 10;
        //System.out.println(num1.toString());
        Integer intergerNum1 = new Integer(10);
        System.out.println(intergerNum1.toString());
    }

    @Test
    public static void test2() {
        /**
         * 包装类 -> 基本数据类型
         * 1.调用包装类的xxxValue()
         * 2.自动拆箱
         */
        Integer integerNum2 = 99;
        long l = integerNum2.longValue();
        System.out.println("l: " + l);

        double v = integerNum2.doubleValue();
        System.out.println("v: " + v);
    }
    /**
     * 包装类转化为String类  String.valueOf()
     */
    @Test
    public void test3() {
        Integer integer = 666;
        String s = String.valueOf(integer);
        System.out.println(s);
    }
    /**
     * String -> 包装类  调用包装类的XXX.parseXXX()
     */
    @Test
    public void test4() {
        String str = "10";
        int num = Integer.parseInt(str, 8);
        System.out.println(num);
    }
    @Test
    public void testMianShi1() {
        Object obj = true ? new Integer(1):new Double(2.0d);
        // 1.0
        System.out.println(obj);

        Object obj2;
        if (true) {
            obj2 = new Integer(1);
        } else {
            obj2 =  new Double(2.0d);
        }

        //1
        System.out.println(obj2);
    }

    @Test
    public void testMianShi2() {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        // false
        // i : Interger@1575  j : Integer@1576
        // 引用数据类型, == 比较的是堆内存中的地址. 不是一个对象.不相同.
        System.out.println(i == j);

        Integer m = 1;
        Integer n = 1;
        // true
        // m : Interger@1577  n : Integer@1577
        // 引用数据类型, == 比较的是堆内存中的地址.
        System.out.println(m == n);

        Integer x = 128;
        Integer y = 128;
        // false
        // x: Integer@1620  y:Integer@1621
        /**
         * 程序执行开始时.先执行MethodHandleStatics类中的方法
         * MethodHandleStatics里面有个static静态代码块,
         * 会调用 AccessController.doPrivileged(new PrivilegedActio())方法.
         * 入参是一个接口. 通过匿名内部类实现了run()方法.
         * 在run方法中.会调用 Integer.getInteger() 方法.
         * 此时,会加载Interger类内部的静态内部类IntegerCache.给内部类中有一个Interger[] cache数组,缓存了-128~127之间的数据
         * 接下来调用nteger.valueOf 方法,会判读该int变量是否在-128~127之前. 如果在,从cache数组中取.否则new对象.
         *  会调用Integer.valueOf() ->
         *  public static Integer valueOf(int i) {
         *         if (i >= IntegerCache.low && i <= IntegerCache.high)
         *             return IntegerCache.cache[i + (-IntegerCache.low)];
         *         return new Integer(i);
         *     }
         *
         */
        System.out.println(x == y);

    }
}
