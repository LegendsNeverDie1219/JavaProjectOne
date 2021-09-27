package com.huawei.nce.javabase.day11.objectoriented.inheritance;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/27 21:21
 */
public class Cylinder extends Circle {
    private double length;

    public Cylinder() {
        this.length = 1.0;
    }

    public Cylinder(double length, double radius) {
        this.length = length;
    }

    public double findVolume() {
        // return Math.PI * getRadius() * getRadius() * length;
        return super.findArea() *length;
    }

    @Override
    public double findArea() {
        return super.getRadius() * 2 + 2 * Math.PI * getRadius() * length;
    }
}
