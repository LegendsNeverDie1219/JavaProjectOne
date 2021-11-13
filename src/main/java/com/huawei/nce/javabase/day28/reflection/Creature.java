package com.huawei.nce.javabase.day28.reflection;

import java.io.Serializable;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/11/13 17:15
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;
    private void breath() {
        System.out.println("生物呼吸");
    }
    public void eat(T food) {
        System.out.println("生物进食" + food);
    }
}
