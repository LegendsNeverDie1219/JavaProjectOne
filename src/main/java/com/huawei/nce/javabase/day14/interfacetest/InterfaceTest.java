package com.huawei.nce.javabase.day14.interfacetest;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/1 17:52
 */
public class InterfaceTest {
    /**
     * 接口的使用:
     * 1.接口用interface 来定义
     *  现实生活中,如果多个事物的之间没有 is a 的关系
     *   但是这多个事物之间又具有相同的行为特性 :
     *   比如 飞机,子弹, 风筝, 热气球 都具有飞的行为特性,
     *   这个时候就可以把 这个行为特性抽象后放到一个接口中. 让其他事物去各自实现这个行为特性
     *   总之,接口定义的 就是一组规范.  体现的就是如果你要 XXX,则必须实现XXx
     *    比如String.java中 实现的 Comparable接口
     *     如果你要字符串能够比较, 则必须实现comparable接口中的compareTo()方法.
     *     继承刻画的是 是不是(is a)的关系   接口实现刻画的是 能不能(can do)的关系
     * 2.java中,接口和类是两个并列的结构
     * 3.如何定定义接口: 定义接口中的成员
     *   3.1 jDK1.7以及之前 : 只能定义全局常量, 和 抽象方法
     *      全局常量: public static final
     *      抽象方法: public abstract
     *
     *   3.2jDK1.8
     *    除了上面两种之外, 还可以定义默认方法, 和静态方法.
     *  4.接口不能够实例化,并且没有构造器
     *
     *  5.开发中,接口通过让类implement的方式去使用
     *   如果实现类全部实现了接口中的抽象方法,则可以的实例化
     *   否则该实现类仍然是一个是抽象类,不能被实例化
     *
     *  6.java类可以实现多个接口  -> 弥补了java单继承的局限性
     *  格式  class A extend BB implements CC ,DD
     *
     *  7.接口与接口之前可以继承, 并且可以多继承
     *   interface AA extends BB,CC
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Flyable.MIN_SPEED);
        System.out.println(Flyable.MAX_SPEED);

        Plane plane = new Plane();
        plane.fly();

        Bullet bullet = new Bullet();
        bullet.fly();
        bullet.attack();
    }
}
