package com.huawei.nce.javabase.day29;

import lombok.*;

import java.util.Objects;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/11/14 15:43
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    private Long id;
    private String name;
    private Integer age;
    private Double salary;

    public String getName() {
        return name;
    }

    public Employee(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(age,
                employee.age) && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, salary);
    }
}
