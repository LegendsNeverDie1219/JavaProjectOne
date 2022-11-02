package com.huawei.nce.javabase.day22.enumtest;

import org.junit.jupiter.api.Test;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/13 20:38
 */
public class EnumTest {
    /**
     * 枚举类的使用场景:
     * 一.枚举类的使用
     * 1.枚举类的理解: 类的对象是有限个的.并且是确定的
     * 比如:季节: 四季 星期: 1-7
     * 2.当需要定义一组常量的时候,强烈建议使用枚举类
     * 3.如果枚举类中只有一个对象,则可以使用单例模式去实现
     * <p>
     * 二.如何定义枚举类
     * 方式一: jdk5.0之前,自定义枚举类
     * 方式二: Jdk5.0的时候,可以使用enum关键字去定义枚举类
     * <p>
     * 三.枚举类的常用方法:
     * // 1.toString(): 返回当前枚举类中某一个对象的名称.
     * // 2.values()方法: 返回枚举类型的对象数组
     * // valueOf(String objName)返回枚举类中对象名为objName的对象.
     *
     * 四.枚举类实现接口的情况
     * 情况一: 枚举类本身实现接口中的抽象方法
     * 情况二:枚举类中的众多对象,分贝实现接口中的抽象方法
     */
    public static void main(String[] args) {
       // Season.SPRING = null;
        Season spring = Season.SPRING;
        // Season{seasonName='春季', seasonDesc='春暖花开'}
        System.out.println(spring.toString());
        // 春季
        System.out.println(spring.getSeasonName());
        // 春暖花开
        System.out.println(spring.getSeasonDesc());
        System.out.println("************************************");
    }

    @Test
    public void test2() {
        EnumSeason spring = EnumSeason.SPRING;
        // SPRING
        // 1.toString(): 返回当前枚举类中某一个对象的名称.
        System.out.println("winter.toString()");
        System.out.println(spring.toString());
        // class java.lang.Enum
        System.out.println(spring.getClass().getSuperclass());
        // 冬天
        System.out.println(spring.getSeasonName());
        // 冬雪皑皑
        System.out.println(spring.getSeasonDesc());
        // 2.values()方法: 返回枚举类型的对象数组
        System.out.println("EnumSeason.values()");
        EnumSeason[] values = EnumSeason.values();
        StringBuilder stringBuilder = new StringBuilder();
        for (EnumSeason value : values) {
            stringBuilder.append(value).append(',');
        }
        // SPRING,SUMMER,AUTUMN,WINTER
        System.out.println(stringBuilder.toString().replaceAll("^,|,$", ""));
    }

    @Test
    public void test3() {
        // ava.lang.IllegalArgumentException:
        // No enum constant com.huawei.nce.javabase.day22.enumtest.EnumSeason.autumn
        // EnumSeason autumn = EnumSeason.valueOf("autumn");
        // valueOf(String objName)返回枚举类中对象名为objName的对象.
        EnumSeason autumn = EnumSeason.valueOf("AUTUMN");
        // AUTUMN
        String name = autumn.name();
        System.out.println(name);

        int ordinal = autumn.ordinal();
        System.out.println(ordinal);

        EnumSeason summer = EnumSeason.valuesOf("夏天");
        System.out.println(summer.toString());
    }

    @Test
    public void test4() {
        // SUMMER
        EnumSeason summer = EnumSeason.valueOf("SUMMER");
        summer.show();
    }
}

// 方式一: jdk5.0之前,自定义枚举类
class Season {
    // 1.声明season对象的属性
    private final String seasonName;
    private final String seasonDesc;

    // 2.私有个构造方法
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 3.提供当前枚举类的多个对象  ,public  static final
    // 能够被外部通过类名.属性的方式调用, 同时外部又不能修改对象引用的指向   因此要用public static fianl
    public static final Season SPRING = new Season("春季", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "夏日炎炎");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "冬雪皑皑");

    // 4.其他诉求:获取枚举类对象的属性

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    // 提供toString()方法.
    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}

