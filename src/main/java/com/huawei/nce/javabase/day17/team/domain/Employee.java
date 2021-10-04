package com.huawei.nce.javabase.day17.team.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/3 23:24
 */
@Setter
@Getter
@AllArgsConstructor
public class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;

    @Override
    public String toString() {
        return getDetail();
    }


    public String getDetail() {
        return id + "\t" + name + "\t" + age + "\t" + salary;
    }
}
