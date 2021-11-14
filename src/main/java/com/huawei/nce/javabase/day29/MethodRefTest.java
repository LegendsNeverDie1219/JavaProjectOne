package com.huawei.nce.javabase.day29;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.*;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/11/14 15:29
 */
public class MethodRefTest {
    /**
     * 1.方法引用的使用情景:
     * 当lambda方法体的具体操作,已经有对应的实现方法的时候, 就可以使用方法引用了
     * 2.本质:
     * 方法引用: 本质上也是lambda表达式,而lambda表达式是接口的匿名实现类的匿名实例,
     *  所以方法引用也是 函数式接口的匿名实现类的匿名实例.
     *
     *  3.使用格式
     *  类/对象 ::方法名
     *
     *  4.具体分下面三种情况:
     *  对象 :: 非静态方法
     *  类 :: 静态方法
     *  类 :: 非静态方法\
     *
     *  5.方法引用的使用要求:
     *  要求接口中的抽象方法的形参列表,返回值  和 引用方法的形参列表,返回值类型一致.(针对情况1和2)
     */
    // 对象::非静态方法
    // Consumer中 void accept(T t)
    // PrintStream中 void println(T t)
    @Test
    public void test1() {
        Consumer<String> consumer = str -> System.out.println(str);
        consumer.accept("背景");

        System.out.println("**********************");
        PrintStream printStream = System.out;
        Consumer<String> consumer1 = printStream::println;
        consumer1.accept("shanghai");
    }
    // Supplier中的 T get();
    // Employee中的 String getName()
    @Test
    public void test2() {
        Employee employee = new Employee(1L, "hds", 25, 999999.9D);
        Supplier<String> supplier = () -> employee.getName();
        System.out.println(supplier.get());

        Supplier<String> supplier1 = employee::getName;
        System.out.println(supplier.get());
    }
    // 类:: 静态方法
    //Comparator中的 int compare(T t1,T t2)
    // Integer中的 static int compare(T t1,T t2)
    @Test
    public void test3() {
        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1,o2);
        System.out.println(comparator.compare(12, 21));

        System.out.println("******************************");

        Comparator<Integer> comparator1 = Integer::compare;
        System.out.println(comparator1.compare(21, 12));
    }
    // 类::实例方法
    // Comparator 中 int compare(T t1,T t2)
    // String 中的  int t1.compareTo(T t2)
    @Test
    public void test4() {
        Comparator<String> comparator = (t1,t2) -> t1.compareTo(t2);
        // -4
        System.out.println(comparator.compare("abc", "egc"));

        System.out.println("**********************");
        Comparator<String> comparator1 = String::compareTo;
        // 1
        System.out.println(comparator1.compare("dd", "cba"));
    }
    // BiPredicate boolean test(T t, U u)
    // String      boolean t.equals(U u)
    @Test
    public void test5() {
        BiPredicate<String,String> biPredicate = (s1,s2) -> s1.equals(s2);
        System.out.println(biPredicate.test("cnm", "ctm"));
        BiPredicate<String ,String> biPredicate2 = String::equals;
        System.out.println(biPredicate2.test("Cnm", "Cnm"));
    }
    // Function R apply(T t);
    // Employee String t.getName()
    @Test
    public void test6() {
        Employee employee = new Employee(1L, "hds", 25, 999999.9D);
        Function<Employee,String> function = (e) -> e.getName();
        System.out.println(function.apply(employee));

        Function<Employee,String> function2 = Employee::getName;
        System.out.println(function2.apply(employee));
    }
    // 构造器引用: 接口中抽象方法的形参列表和 引用方法的形参列表一致.
    // BiFunction  R apply(T t, U u)
    // Employee   Employee(Long id, String name)
    @Test
    public void test7() {
        BiFunction<Long,String, Employee> biFunction = (id,name) -> new Employee(id,name);
        Employee hds = biFunction.apply(1L, "hds");
        System.out.println(hds);
        System.out.println("**************************************");
        BiFunction<Long, String,Employee> biFunction2 = Employee::new;
        Employee zl = biFunction2.apply(2L, "zl");
        System.out.println(zl);
    }

    @Test
    public void test8() {
        Function<Integer, String[]> function = length -> new String[length];
        System.out.println(Arrays.toString(function.apply(3)));
        Function<Integer, String[]> function2 = String[] ::new;
        System.out.println(Arrays.toString(function2.apply(100)));
    }
}
