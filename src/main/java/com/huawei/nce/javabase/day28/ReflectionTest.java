package com.huawei.nce.javabase.day28;

import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/11/9 21:44
 */
public class ReflectionTest {
    /**
     * 反射: 是java被称为动态语言的核心,反射机制允许在jvm运行期,通过反射API,获取类的全部信息
     * 类加载到方法区之后,就可以在程序中运行了(运行时类). 也就产生了Class类的实例
     */
    // 反射之前,对Person类的操作.
    @Test
    public void test1() {
        //
        Person person = new Person("hds", 25);
        person.age = 26;
        System.out.println(person);
        person.show();
        // person.showNation()
    }

    @Test
    public void test2() throws InstantiationException, IllegalAccessException, NoSuchMethodException,
            InvocationTargetException, NoSuchFieldException {
        Class<Person> clazz = Person.class;
        // 1.通过反射,创建Perso类的对象
        // Person person =(Person) clazz.newInstance();
        Constructor<Person> declaredConstructor = clazz.getDeclaredConstructor(String.class, Integer.class);
        Person person = declaredConstructor.newInstance("tom", 12);

        // 2.通过反射,调用指定类内部的属性
        Field age = clazz.getDeclaredField("age");
        age.set(person, 100);

        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person, "一眼千山");
        System.out.println(person);
        //3.通过反射,调用指定类内部的方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(person);

        Method showNation = clazz.getDeclaredMethod("showNation", Integer.class);
        showNation.setAccessible(true);
        String invoke = (String) showNation.invoke(person, 5000);
        System.out.println(invoke);
    }
    /**
     * 1.可以通过new的方式或者反射来调用对象中的公共结构,但是开发中一般还是用new的方式.
     * 原因: 反射的方式速度慢
     * 2.反射机制和面向对象的封装性是否矛盾
     * 不矛盾,
     * 面向对象中属性和方法设置为private,目的是不想让外部去调用, 封装解决的是 想不想让外部调用的问题
     * 反射解决的是能不能调用的问题,并且反射的应用场景是:
     * 在编译期间,无法确定到底要实例化哪个类的对象. 只能在运行期间,才能确定.
     */

    /**
     * 关于java.lang.Class的理解:
     * 源码文件(.java)在执行过javac.exe编译命令之后,会产生对应的.class的字节码文件,
     * 接着执行java.exe的解释执行命令之后,会把.class的字节码文件加载到内存的方法区中,
     * 这个过程就是类的加载.
     * 加载到内存中的类  即  运行时类  即  Class类的一个实例.
     */

    /**
     * \
     * 获取Class类的实例的四种方法
     */
    @Test
    public void test3() throws ClassNotFoundException {
        // 方式一: 运行时类.class
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);
        // 方式二: 运行时类的对象.getClass()
        Person person = new Person();
        Class<? extends Person> clazz2 = person.getClass();
        System.out.println(clazz2);
        // 方式三: Class.forName("类全名")
        Class<?> clazz3 = Class.forName("com.huawei.nce.javabase.day28.Person");
        System.out.println(clazz3);
        // 方式四: 使用类的加载器
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("com.huawei.nce.javabase.day28.Person");
        System.out.println(clazz4);
    }
    /**
     * 那些类型可以有Class对象
     * 1.class: 外部类.内部类
     * 2.interface: 接口
     * 3.[]: 数组
     * 4.enum: 枚举
     * 5.annotation: 注解
     * 6.基本数据类型
     * 7.void
     */
    @Test
    public void test4() {
        // class java.lang.Object
        Class clazz1 = Object.class;
        // interface java.lang.Comparable
        Class clazz2 = Comparable.class;
        // class [Ljava.lang.String;
        Class clazz3 = String[].class;
        // class [[I
        Class clazz4 = int[][].class;
        // class java.lang.annotation.ElementType
        Class clazz5 = ElementType.class;
        // interface java.lang.Override
        Class clazz6 = Override.class;
        // int
        Class clazz7 = int.class;
        // void
        Class clazz8 = void.class;
        // class java.lang.Class
        Class clazz9 = Class.class;
        System.out.println(clazz1);
        System.out.println(clazz2);
        System.out.println(clazz3);
        System.out.println(clazz4);
        System.out.println(clazz5);
        System.out.println(clazz6);
        System.out.println(clazz7);
        System.out.println(clazz8);
        System.out.println(clazz9);

        int[] a = new int[10];
        int[] b = new int[100];
        Class clazz10 = a.getClass();
        Class clazz11 = b.getClass();
        System.out.println(clazz10 == clazz11);
        System.out.println("================");
        // class [I
        System.out.println(clazz10);
        Class clazzs = String[].class;
        // class [Ljava.lang.String;
        System.out.println(clazzs);
        // class [[Ljava.lang.String;
        Class clazzss = String[][].class;
        System.out.println(clazzss);
    }

    /**
     * clazz.newInstance() 创建运行时类的对象. 本质上是调用的运行时类的空参构造器.
     * 要求: 运行时类中有空参构造器,并且修饰符为public
     *
     * 这个时候就体现出了空参构造器的好处.
     * 可以基于反射的通用方法创建运行时类的对象
     * 并且可以提供给子类的构造器去调用 super()
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @Test
    public void testNewInstance() throws InstantiationException, IllegalAccessException {
        Class<Dog> clazz = Dog.class;
        // java.lang.InstantiationException: com.huawei.nce.javabase.day28.Dog
        // java.lang.IllegalAccessException: Class ReflectionTest can not access a
        // member of class com.huawei.nce.javabase.day28.Dog with modifiers "private"
        Dog dog = clazz.newInstance();
        System.out.println(dog);

    }
}
