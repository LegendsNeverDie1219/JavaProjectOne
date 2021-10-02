package com.huawei.nce.javabase.day11.objectoriented.object;

import lombok.*;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/28 22:19
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Person implements Cloneable {
    private String name;
    private Integer age;
    private Address address;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person person = (Person) super.clone();
        person.address = (Address) this.address.clone();
        return person;
    }
}