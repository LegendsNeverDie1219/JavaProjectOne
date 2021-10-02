package com.huawei.nce.javabase.day14.statictest;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/1 11:24
 */
public class CircleTest {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        Circle circle2 = new Circle();
        Circle circle3 = new Circle(2);
        //circile1 id is: 1001
        //circile2 id is: 1002
        //circile3 id is: 1003
        //创建圆形的总个数为: 3
        System.out.println("circile1 id is: " + circle1.getId());
        System.out.println("circile2 id is: " + circle2.getId());
        System.out.println("circile3 id is: " + circle3.getId());
        System.out.println("创建圆形的总个数为: " + Circle.getTotal());
    }

}

class Circle {
    private double radius;
    // 自动加一
    private int id;
    // 记录创建圆形对象的个数
    private static int total;
    private static int initId = 1001;

    public Circle() {
        id = initId++;
        total++;
    }

    public Circle(double radius) {
        id = initId++;
        total++;
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getTotal() {
        return total;
    }

    public static void setTotal(int total) {
        Circle.total = total;
    }

    public static int getInitId() {
        return initId;
    }

    public static void setInitId(int initId) {
        Circle.initId = initId;
    }
}