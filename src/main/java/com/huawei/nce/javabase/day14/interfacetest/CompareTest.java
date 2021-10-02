package com.huawei.nce.javabase.day14.interfacetest;

import lombok.Getter;
import lombok.Setter;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/2 10:20
 */
public class CompareTest {
    public static void main(String[] args) {
        CompareObject circle = new ComparableCircle(11);
        CompareObject circle2 = new ComparableCircle(11.1);
        if (circle.compareTo(circle2) > 0) {
            System.out.println("circle 大");
        } else if (circle.compareTo(circle2) < 0) {
            System.out.println("cicle2 大");
        } else {
            System.out.println("相等");
        }

    }
}

interface  CompareObject {
    /**
     * compareTo
     * 若返回值是 0 , 代表相等; 若为正数，代表当前对象大；负数代表当前对象小
     *
     * @param obj obj
     * @return int
     */
    int compareTo (Object obj);
}

@Setter
@Getter
class Circle {
    private double redius;

    public Circle(double redius) {
        this.redius = redius;
    }
}

class ComparableCircle extends  Circle implements  CompareObject {
    public ComparableCircle(double redius) {
        super(redius);
    }

    /**
     * compareTo
     *
     * @param obj obj
     * @return int
     */
    @Override
    public int compareTo(Object obj) {
        if (this == obj) {
            return 0;
        }
        if (obj instanceof Circle) {
            Circle circle = (Circle)obj;
            if (this.getRedius() > circle.getRedius()) {
                return 1;
            } else if (this.getRedius() < circle.getRedius()) {
                return -1;
            }
            return 0;
        } else {
            throw new RuntimeException();
        }
    }
}