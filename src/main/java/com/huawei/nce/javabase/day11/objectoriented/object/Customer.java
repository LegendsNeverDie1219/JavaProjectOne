package com.huawei.nce.javabase.day11.objectoriented.object;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/29 20:43
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Customer {
    private String name;
    private int age;

    @Override
    public boolean equals(Object obj) {
        // 如果是一个对象. 则为true
        if (this == obj) {
            return true;
        }
        // 如果入参为null,或者不是同一个类型
        // class com.huawei.nce.javabase.day11.objectoriented.object.GoodCustomer
        // class com.huawei.nce.javabase.day11.objectoriented.object.Customer
        if (obj instanceof Customer) {
            System.out.println("我是Customer类的对象/或者Customer子类的对象");
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Customer customer = (Customer) obj;
        // 分别比较两个对象的每个属性是否都相同.
        //拍除两种特殊情况(都为null .或者为一个对象 this.name == customer.name)
        return this.age == customer.age && (this.name == customer.name ||
                (this.name != null && this.name.equals(customer.name)));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class GoodCustomer extends Customer {
    public GoodCustomer(String name, int age) {
        super(name, age);
    }
}