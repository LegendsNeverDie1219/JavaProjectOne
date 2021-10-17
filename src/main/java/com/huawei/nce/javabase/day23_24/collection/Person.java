package com.huawei.nce.javabase.day23_24.collection;

import lombok.*;

import java.util.Objects;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/17 16:23
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person implements Comparable {
    private String name;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Object obj) {
        if (!(obj instanceof Person)) {
            throw new RuntimeException("输入的数据类型不是Person类型");
        }
        Person person = (Person) obj;
        int result = Integer.compare(this.name.compareTo(person.name), 0);
        if (result == 0) {
            return Integer.compare(this.age, person.age);
        }
        return result;
    }
}
