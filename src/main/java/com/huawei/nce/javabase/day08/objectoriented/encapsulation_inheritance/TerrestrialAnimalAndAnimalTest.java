package com.huawei.nce.javabase.day08.objectoriented.encapsulation_inheritance;


import com.huawei.nce.javabase.day08.objectoriented.Food;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/23 20:45
 */
public class TerrestrialAnimalAndAnimalTest {
    public static void main(String[] args) {
        Animal animal = new Animal();
        // animal.setName("monkey");
        animal.setName(null);
        animal.setAge(25);
        // 'legs' has private access in 'com.huawei.nce.javabase.day08.objectoriented.encapsulation_inheritance.Animal'
        /**
         * 一.封装的体现 ---- 属性私有化
         * 当我们创建一个类的对象之后,我们可以是用对象.属性 = 属性值的方式给属性赋值,
         * 但是,实际情况中
         * 我们在给属性赋值的时候,需要添加额外的限制条件,
         * 同时属性是对象内部的,也不允许的直接通过对象.属性的方法的给属性赋值.
         * 所以需要让属性为对象私有. 并开放公共的get, set方法(里面可以加限制条件)让外部可以操作对象的这些属性.
         * 此时,针对属性就体现了封装性
         *
         * 二.封装的其他体现
         * 1.属性私有化  不对外暴露属性.
         * 2. 方法私有化, 不对外暴露私有的方法
         * 3. 构造方法私有化,(如单例模式.私有的构造方法.不允许外部直接new一个对象.)
         *
         * 三.封装的控制 (即使用权限修饰符)
         * private   类内部可见,
         * 缺省       同一个包下面可见
         * protected  同一个包下面可见,并且不同包下该类的子类也可见
         * public     同一个工程下可见.
         *
         */
        // animal.setLegs(3);
        animal.setLegs(2);
        Animal animal2 = new Animal(null, 25, 2);
        // false  原因: 父类Object中比较对象是否相等就是判断这两个对象的堆内存地址是否相等,即是不是一个对象,由于不是一个对象,所以为false
        System.out.println("父类Object的equals()方法: 对象1和对象2是否相等: " + animal.equals(animal2));

        TerrestrialAnimal terrestrialAnimal = new TerrestrialAnimal("monkey", 25, 2, new Food());
        TerrestrialAnimal terrestrialAnimal2 = new TerrestrialAnimal("monkey", 25, 2, new Food());
        // 返回false.
        // 重写了equals之后,
        // 首先判断是否是同一个对象,如果是.则为true. 否则继续判断
        // 其次判断对象的类型是否相同,如果不同,则返回false,否则继续判断
        // 最后判断对象的中的属性值是否相等.如果属性是基本数据类型,则判断属性值本身是否相等,如果属性是引用类型,则判断属性值的内存地址值是否相同(这里String要特殊对待.)

        System.out.println("重写父类Object的equals()方法: 对象1和对象2是否相等: " + terrestrialAnimal.equals(terrestrialAnimal2));


        // 104739310
        System.out.println("父类Object的hashCode()方法: " + animal.hashCode());
        // 203006237
        System.out.println("重写父类Object的hashCode()方法: " + terrestrialAnimal.hashCode());

        //  com.huawei.nce.javabase.day08.objectoriented.encapsulation_inheritance.Animal@63e31ee
        // 即: 类全名+ @ + 对象hashCode的十六进制的字符串.
        System.out.println("父类Object的toString()方法: " + animal);
        // TerrestrialAnimal{name='monkey', age=25, legs=2, food=com.huawei.nce.javabase.day08.objectoriented
        // .encapsulation_inheritance.Food@61bbe9ba}
        // 重写父类Object的toString()方法: TerrestrialAnimal{name='monkey', age=25, legs=2, food=Food{name='null', weight=0.0}}
        System.out.println("重写父类Object的toString()方法: " + terrestrialAnimal);

        System.out.println("==============================");
        TerrestrialAnimal terrestrialAnimal3 = new TerrestrialAnimal("hds");
        System.out.println(terrestrialAnimal3);
        com.huawei.nce.pojo.Animal animal1 = new com.huawei.nce.pojo.Animal("human",25, 1 );
        System.out.println("我是pojo中的animal: " + animal1);
    }
}
