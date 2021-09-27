package com.huawei.nce.javabase.day11.objectoriented.inheritance;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/27 21:23
 */
public class Circle {
    private double radius;
    public Circle() {
        radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    public  double findArea() {
        return Math.PI * radius * radius;
    }
}
