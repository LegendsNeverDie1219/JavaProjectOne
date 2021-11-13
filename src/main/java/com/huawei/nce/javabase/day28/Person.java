package com.huawei.nce.javabase.day28;

import lombok.*;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/11/9 21:57
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
    private String name;
    Integer age;

    public void show() {
        System.out.println("show ;;;;;;;;");
    }

    private String showNation(Integer age) {
        System.out.println("showNation 我是一个中国人");
        return "中华民族历史:" + age;
    }
}
