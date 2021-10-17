package com.huawei.nce.javabase.day22.enumtest;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/17 11:49
 */
// 方式二: Jdk5.0的时候,可以使用enum关键字去定义枚举类
public enum EnumSeason implements Info {
    // 1.提供当前枚举类的多个对象 相同的地方全部省略.多个对象之间用,隔开, 最后一个对象用;结束.
    SPRING("春季", "春暖花开") {
        @Override
        public void show() {
            System.out.println("春天在哪里");
        }
    },
    SUMMER("夏天", "夏日炎炎") {
        @Override
        public void show() {
            System.out.println("宁夏");
        }
    },
    AUTUMN("秋天", "秋高气爽") {
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天", "冬雪皑皑") {
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };

    // 2.声明season对象的属性 private final
    private final String seasonName;
    private final String seasonDesc;

    // 3.私有的构造方法,给属性赋值.
    EnumSeason(String seasonName, String seasonDesc) {
        // Call to super is not allowed in enum constructor
        // 枚举构造函数中不允许调用 super
        // super("aaa",1);
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 4.其他诉求:获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    public static EnumSeason valuesOf(String seasonName) {
        EnumSeason[] values = EnumSeason.values();
        for (EnumSeason value : values) {
            if (value.getSeasonName().equals(seasonName)) {
                return value;
            }
        }
        return null;
    }

    // 提供toString()方法.

    @Override
    public String toString() {
        return "EnumSeason{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}

interface Info {
    void show();
}