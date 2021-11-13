package com.huawei.nce.javabase.day28.reflection;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/11/13 20:55
 */
public class OtherTest {
    @Test
    public void test1() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.huawei.nce.javabase.day28.reflection.Person");
        // public com.huawei.nce.javabase.day28.reflection.Person()
        // 获取当前运行时类中公有的的构造器
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println();
        //public com.huawei.nce.javabase.day28.reflection.Person()
        //private com.huawei.nce.javabase.day28.reflection.Person(java.lang.String)
        // 获取当前运行时类中所有的构造器
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
    }

    @Test
    public void test2() {
        Class<Person> clazz = Person.class;
        Class<? super Person> superclass = clazz.getSuperclass();
        Type genericSuperclass = clazz.getGenericSuperclass();
//        class com.huawei.nce.javabase.day28.reflection.Creature
//        com.huawei.nce.javabase.day28.reflection.Creature<java.lang.String>
        System.out.println(superclass);
        System.out.println(genericSuperclass);
    }

    // 获取运行时类中带泛型的父类 对应的泛型.
    @Test
    public void test3() {
        Class<Person> clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        // java.lang.String
        System.out.println(actualTypeArguments[0].getTypeName());
    }
    // 获取运行时类(父类)实现的接口
    @Test
    public void test4() {
        Class<Person> clazz = Person.class;
        Class<?>[] interfaces = clazz.getInterfaces();
        //interface java.lang.Comparable
        //interface com.huawei.nce.javabase.day28.reflection.MyInterface
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }
        System.out.println();

        Class<?>[] interfaces1 = clazz.getSuperclass().getInterfaces();
        //interface java.io.Serializable
        Arrays.stream(interfaces1).forEach(System.out::println);
    }
    // 获取运行时类所在的包.
    @Test
    public void test5() {
        Class<Person> clazz = Person.class;
        // package com.huawei.nce.javabase.day28.reflection
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
    }
    // 获取运行时类头顶声明的注解
    @Test
    public void test6() {
        Class<Person> clazz = Person.class;
        // @com.huawei.nce.javabase.day28.reflection.MyAnnotation(value=hi, valueArray=[hds, zl])
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
    // 如何操作运行时类中的属性
    @Test
    public void test7() throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();
        System.out.println(person);
        // 1.通过运行时类获取类中的某一个属性对象
        Field name = clazz.getDeclaredField("name");
        // 2.属性对象设置为可访问的
        name.setAccessible(true);
        // 3.设置指定对象的该属性值
        name.set(person, "hds");
        System.out.println(person);
    }
    // 如何调用运行时类中的某一个方法
    @Test
    public void test8() throws InstantiationException, IllegalAccessException, NoSuchMethodException,
            InvocationTargetException {
        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();
        Method show = clazz.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
//        我的国籍是: 中国人呢
//                中国人呢666
        Object result = show.invoke(person, "中国人呢");
        System.out.println(result);
        // Modifier.toString(show.getModifiers()): private
        System.out.println("Modifier.toString(show.getModifiers()): " + Modifier.toString(show.getModifiers()));

        Method info = clazz.getDeclaredMethod("info");
        //info.setAccessible(true);
        System.out.println("Modifier.toString(info.getModifiers()): " + Modifier.toString(info.getModifiers()));
        Object invoke = info.invoke(person);
        System.out.println(invoke);
    }
    // 如何调用运行时类中指定的构造器
    @Test
    public void test9() throws NoSuchMethodException, InvocationTargetException, InstantiationException,
            IllegalAccessException {
        Class<Person> clazz = Person.class;
        Constructor<Person> declaredConstructor = clazz.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Person person = declaredConstructor.newInstance("hds");
        System.out.println(person);

    }

}
