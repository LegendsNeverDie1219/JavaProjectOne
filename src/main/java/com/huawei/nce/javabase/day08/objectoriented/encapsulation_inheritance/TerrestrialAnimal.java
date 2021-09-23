package com.huawei.nce.javabase.day08.objectoriented.encapsulation_inheritance;

import com.huawei.nce.javabase.day08.objectoriented.Food;

import java.util.Objects;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/23 22:05
 */
public class TerrestrialAnimal {
    private String name;
    private int age;
    private int legs;
    private Food food;

    /**
     * 构造器(java会默认生成公有的无参构造器)
     * 目的: 1.用来创建对象 2. 用来给对象内部的属性初始化赋值
     * 属性赋值的先后顺序
     *  ① 默认初始化
     *  ② 显示初始化
     *  ③ 构造器初始化
     *  ④对象.set()方法初始化
     */
    public TerrestrialAnimal() {
        System.out.println("调用了无参构造");
    }

    public TerrestrialAnimal(String name) {
       // this();
        this.name = name;
        this.setAge(10000000);
        this.setLegs(2000000);

    }

    public TerrestrialAnimal(String name, int age, int legs) {
        this.name = name;
        this.age = age;
        this.legs = legs;
    }
    /**
     * this关键字的使用:
     * ① this可以理解为当前对象,或者当前正在创建的对象
     * ② this可以修饰/调用 属性,方法.构造器
     * ③ 在类的方法中,我们可以使用this.属性,或者this.方法 的形式,来调用当前对象的属性和方法. this一般可以省略.
     *  但是,如果方法的形参和属性重名,则需要显式的使用this.变量 来表明此变量是成员变量.
     * ④ 在构造器中,我们可以使用this(形参列表)来调用其他的构造器.但是调用其他构造器()必须声明在方法的首行.
     * @param name name
     * @param age age
     * @param legs legs
     */
    public TerrestrialAnimal(String name, int age, int legs, Food food) {
        this.name = name;
        this.age = age;
        this.legs = legs;
        this.food = food;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TerrestrialAnimal that = (TerrestrialAnimal) obj;
        return age == that.age && legs == that.legs && Objects.equals(name, that.name) && Objects.equals(food, that.food);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, legs, food);
    }

    // Animal{name='monkey', age=25, legs=0}
//    @Override
//    public String toString() {
//        return "TerrestrialAnimal{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", legs=" + legs +
//                '}';
//    }

    @Override
    public String toString() {
        return "TerrestrialAnimal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", legs=" + legs +
                ", food=" + food +
                '}';
    }
}
