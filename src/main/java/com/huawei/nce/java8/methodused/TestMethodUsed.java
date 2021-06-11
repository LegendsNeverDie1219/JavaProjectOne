package com.huawei.nce.java8.methodused;

import com.google.common.base.Supplier;
import com.huawei.nce.pojo.Product;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * TODO
 *
 * @author Administrator
 * @date 2020/9/7 21:32
 */
public class TestMethodUsed {
    /***
     * 构造方法引用 类名 :: new
     * 调用  变量名.接口方法(实参列表)
     *  根据lambda接口中的形参,去调用对应的构造方法
     **/
    @Test
    public void test1() {
        Supplier<Product> supplier1 = () -> new Product();
        System.out.println(supplier1.get());
        System.out.println("============================");
        Supplier<Product> supplier2 = Product::new;
        System.out.println(supplier2.get());
        System.out.println("============================");

        Function<Integer, Product> fun1 = (num) -> {
            return new Product(num);
        };
        System.out.println(fun1.apply(666));
        System.out.println("============================");
        Function<Integer, Product> fun2 = Product::new;
        System.out.println(fun2.apply(888));
    }

    /***
     *构造方法的引用2
     **/
    @Test
    public void test2() {
        LambdaTest5 lt5 = String::new;
        String string = lt5.createString(new char[]{'1', '2', '3', 'a'});
        System.out.println(string);
    }

    /***
     * 实例方法引用  实例名 :: 实例方法名
     * 调用  变量名.接口方法(参数列表)
     **/
    @Test
    public void test3() {
        Consumer con = (x) -> System.out.println(x);
        con.accept(100);
        Consumer con2 = System.out::println;
        con2.accept(200);
    }
    /***
     * 类的静态方法的引用  类名 :: 静态方法名
     * 调用   变量名.接口方法(参数列表)
     **/
    @Test
    public void test4() {
        //右边是函数式接口实现类的参数列表,方法体 左边是一个BiFunction接口的实现类实例
        BiFunction<Integer, Integer, Integer> biFun = (x, y) -> Integer.compare(x, y);
        System.out.println(biFun.apply(100, 200));
        BiFunction<Integer,Integer,Integer>  biFun2 = Integer::compare;
        System.out.println(biFun2.apply(200,100));
    }
    /***
     * @param
     * @return {}
     * 类的实例方法的引用 类名 :: 实例方法名
     * 调用   实现类实例名.接口方法
     **/
    @Test
    public void test5() {
        BiFunction<String,String,Boolean> biFun = (str1,str2) -> str1.equals(str2);
        System.out.println(biFun.apply("hello","world"));
        BiFunction<String,String,Boolean> biFun2 = String :: equals;
        System.out.println(biFun2.apply("hello","hello"));
    }
}

