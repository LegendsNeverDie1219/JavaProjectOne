package com.huawei.nce.javabase.breakpoint;

import com.google.common.collect.Lists;
import com.huawei.nce.pojo.Product;


import java.util.List;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/5/25 23:04
 */
public class BreakPointTypeDemo {
    private static final List<Product> productList;

    static {
        productList = Lists.newArrayList(
                new Product("红色商品", "红色", 6000D, 1),
                new Product("蓝色商品", "蓝色", 7000D, 2),
                new Product("黄色商品", "黄色", 6000D, 3));
    }

    public static void main(String[] args) {
//        line();
//        detailLine(productList);
//        method();
//        exception();
        field();
    }

    private static void field() {
        // run -> reload Changed Classes(在调试的过程中修改类中的代码.)
        Person person = new Person("字段断点", 10);
        person.setAge(100);
        System.out.println(person.getAge());
    }
    //异常断点 哪里有异常停留在哪里
    private static void exception() {
        Object o  =  null;
        o.toString();
        System.out.println("this line can never be reached coz the exception");
    }
    // 方法断点 (接口会跳转至具体的实现类)
    private static void method() {
        System.out.println("this is from method");
        IService iService = new IServiceImplOne();
        iService.execute();
    }
    // 可详细设置的断点(条件断点)
    private static void detailLine(List<Product> productList) {
        for (Product product : productList) {
            // Breakpoint reached at breakpoint.TestBreakPoint.detailLine(TestBreakPoint.java:49)
            String name = product.getName();
            System.out.println(name + " ->: " + product.toString());
        }
        System.out.println("this is from detail line");
    }
    // 行断点
    private static void line() {
        System.out.println("this is from line");
    }
}
