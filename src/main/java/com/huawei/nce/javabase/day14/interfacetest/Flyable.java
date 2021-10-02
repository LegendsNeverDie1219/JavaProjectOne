package com.huawei.nce.javabase.day14.interfacetest;/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/1 18:15
 */

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/1 18:15
 */
public interface Flyable {
    public static final  double MAX_SPEED = 7.9;
    public static final  double MIN_SPEED = 2.1;
//    protected static final double MIN1_SPEED = 7.9;

    /**
     * fly
     */
    public abstract  void fly();
}
interface Attackable {
    /**
     * 攻击
     */
    void attack();
}
class Plane implements Flyable {
    @Override
    public void fly() {
        System.out.println("飞机飞翔");

    }
}

class Bullet implements Flyable,Attackable {
    @Override
    public void fly() {
        System.out.println("风筝飞翔");

    }

    /**
     * 攻击
     */
    @Override
    public void attack() {
        System.out.println("子弹攻击");
    }
}