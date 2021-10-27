package com.huawei.nce.javabase.day23_24.map;

import lombok.*;

import java.util.Objects;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/22 22:45
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements Comparable<User>{
    private String name;
    private Integer age;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }


    @Override
    public int compareTo(User user) {
        int number = this.name.compareTo(user.name);
        return number == 0 ? Integer.compare(this.age, user.age) : number;
    }
}
