package com.huawei.nce.javabase.day14.abstracttest.salarysytem;

import lombok.Getter;
import lombok.Setter;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/1 17:12
 */
@Setter
@Getter
public abstract class Employee {
    private String name;
    private int number;
    private MyDate birthday;

    public abstract double earnMoney();

    public Employee(String name, int number, MyDate birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", number=" + number +
                ", birthday=" + birthday;
    }
}
