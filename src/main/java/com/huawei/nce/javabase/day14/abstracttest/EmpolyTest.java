package com.huawei.nce.javabase.day14.abstracttest;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/1 16:31
 */
public class EmpolyTest {
    /**
     编写一个Employee类，声明为抽象类，
     包含如下三个属性：name，id，salary。
     提供必要的构造器和抽象方法：work()。
     对于Manager类来说，他既是员工，还具有奖金(bonus)的属性。
     请使用继承的思想，设计CommonEmployee类和Manager类，要求类
     中提供必要的方法进行属性访问。
     */

    public static void main(String[] args) {
        // 创建Work类的匿名对象
        method1(new Manager(1000d));
        method1(new Worker());
        // 创建Employee抽象类的匿名子类的对象teacher
        Employee teacher = new Employee() {
            @Override
            public void work() {
                System.out.println("老师要好好教书");
            }
        };
        teacher.work();
        // 创建Employee抽象类的匿名子类的匿名对象并且调用work()方法.
        new Employee() {
            @Override
            public void work() {
                System.out.println("我是Employ抽象类的子类的work方法体");
            }
        }.work();

    }

    private static void method1(Employee employee) {
        employee.work();
    }
}

abstract class Employee {
    private String name;
    private int id;
    private double salary;
    public Employee() {
    }

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public abstract void work();
}


class Manager extends Employee {
    private double bonus;

    public Manager(double bonus) {
        this.bonus = bonus;
    }

    public Manager(double bonus, String name, int id, int salary) {
        super(name,id,salary);
        this.bonus = bonus;
    }
    @Override
    public void work() {
        System.out.println("管理公司,提高公司运行的效率");
    }
}

class Worker extends Employee {

    @Override
    public void work() {
        System.out.println("工人在车间生产产品");
    }
}