package com.huawei.nce.javabase.day14.finaltest;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/1 15:40
 */
public class FinalTest {
    /**
     * 一.final :最终的
     * 二.final 可以用来修饰类,方法,变量
     * 三.final 修饰一个类. 表示这个类不能不继承
     *      如: String类,System类,StringBuffer类
     *  四.final 修饰一个方法,表示这个方法不能被覆盖
     *     比如: Object类中的getClass()
     *  五.final 修饰变量
     *      5.1final 修饰属性, 可以考虑初始化赋值的地方有: 显示赋值.代码块中赋值, 构造方法中赋值(只要在对象出生之前都可以.)
     *      5.2final 修饰局部变量: 表示该局部变量在初始化赋值的之后,就不能再被修改了.
     *
     */
    final int WIDTH = 1;
    final int LEFT;
    final int RIGHT;

    {
        LEFT = 2;
    }

    public FinalTest(){
        RIGHT = 3;
    }

    public void doWidth() {
       final int num = 3;
//       num+= 10;
    }
//    public final void eat() {
//
//    }
}
class SubFinalTest extends FinalTest {
//    @Override
//    public void eat() {
//        super.eat();
//    }
}