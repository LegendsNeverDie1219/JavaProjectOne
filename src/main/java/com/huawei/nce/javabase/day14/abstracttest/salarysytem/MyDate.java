package com.huawei.nce.javabase.day14.abstracttest.salarysytem;

import lombok.Getter;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/1 17:14
 */
@Getter
public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
