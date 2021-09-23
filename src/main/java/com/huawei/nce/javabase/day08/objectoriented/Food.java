package com.huawei.nce.javabase.day08.objectoriented;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/23 22:26
 */
public class Food {
    private String name;
    private double weight;

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    public static void eatFood() {
        System.out.println("所有动物都要进食");
    }
}
