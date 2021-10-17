package com.huawei.nce.javabase.day22.annotation;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/17 14:47
 */

public class MyAnnnotationTest {
    @Test
    public void testMyAnnotaion() {
        Class clazz = Student.class;
        Annotation[] annotations = clazz.getAnnotations();
        // @com.huawei.nce.javabase.day22.annotation.MyAnnotation(value=hi)
        // @com.huawei.nce.javabase.day22.annotation.MyAnnotations(
        // value=[@com.huawei.nce.javabase.day22.annotation.MyAnnotation(value=123),
        // @com.huawei.nce.javabase.day22.annotation.MyAnnotation(value=456)]
        // )
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}
//@MyAnnotation(value = "hi")
// Java 8对注解处理提供了两点改进：可重复的注解及可用于类型的注解,在Java 8之前，
// @MyAnnotations({@MyAnnotation(value = "123"),@MyAnnotation(value = "456")})
// 在java8之后.
@MyAnnotation("123")
@MyAnnotation("456")
class Person {
    private String name;
    private int age;

    public Person() {
    }
}

class Student extends Person{
}