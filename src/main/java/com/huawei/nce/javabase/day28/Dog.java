package com.huawei.nce.javabase.day28;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/11/13 16:54
 */
@Setter
@Getter
@AllArgsConstructor
@ToString
public class Dog {
    private String name;
    private Integer age;
    public Dog(){}
}
