package com.huawei.nce.javabase.day08.objectoriented.encapsulation_inheritance;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/23 23:15
 */
public class GirlAndBoyTest {
    public static void main(String[] args) {
        Boy boy = new Boy("hds", 25);
        Girl girl = new Girl("whf", 25);
        boy.marry(girl);
        System.out.println("============");
        girl.marry(boy);
        System.out.println("======================");

        Girl girl2 = new Girl("祝英台", 24);
        Girl girl3 = new Girl("朱丽叶", 24);
        int result = girl2.compare(girl3);
        if (result == 1) {
            System.out.println("当前对象祝英台,大");
        } else if (result == 0) {
            System.out.println("当前对象祝英台,和目标对象相等");
        } else {
            System.out.println("当前对象祝英台, 小");
        }
    }

    private static class Boy {
        private  String name;
        private  int age;

        public Boy(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void marry(Girl girl) {
            System.out.println("我想娶的女孩的名字: " + girl.name);
        }
    }

    private static class Girl {
        private  String name;
        private  int age;

        public Girl(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void marry(Boy boy) {
            System.out.println("我想嫁的男孩的名字: " + boy.name);
            boy.marry(this);
        }

        /**
         * compare :
         * 正数: 当前对象大.
         * 负数: 当前对象小
         * @param girl
         * @return
         */
        public int compare(Girl girl) {
            //   return  this.age < girl.age ? -1 : ((this.age == girl.age) ? 0 : 1);
            return Integer.compare(this.age, girl.age);
        }
    }
}
