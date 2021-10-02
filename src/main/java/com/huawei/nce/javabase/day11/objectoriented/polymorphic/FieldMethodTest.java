package com.huawei.nce.javabase.day11.objectoriented.polymorphic;

/**
 * 继承成员变量和继承方法的区别
 *
 * @author Administrator
 * @date 2021/9/28 7:02
 */
public class FieldMethodTest {
    /**
     * 子类中如果方法名,参数列表和父类的相同,则子类中的该方法会覆盖父类中的该方法
     * 但是
     * 子类中如果属性名和父类的相同,则不会覆盖父类中同名的属性 (只会再存一份.)
     * @param args args
     */
    public static void main(String[] args) {
        Sub s = new Sub();
        // 20
        System.out.println(s.count);
        // 20
        s.display();
        Base b = s;
        // true
        System.out.println(b == s);
        // 10
        System.out.println(b.count);
        // 20
        b.display();
    }

     static class Base {
        int count = 10;

        public void display() {
            System.out.println(this.count);
        }
    }

    static class Sub extends Base {
        int count = 20;

        @Override
        public void display() {
            System.out.println(this.count);
        }
    }
}
