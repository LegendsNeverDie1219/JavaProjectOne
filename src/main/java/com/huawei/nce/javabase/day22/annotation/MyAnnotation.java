package com.huawei.nce.javabase.day22.annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/17 14:47
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Inherited
@Repeatable(MyAnnotations.class)
public @interface MyAnnotation {
    /**
     * 如何自定义注解:
     * ①注解声明为@interface  如@SuppressWarnings
     * ②内部定义成员,如果只有一个成员变量,则通常用value表示
     * ③可以指定成员的默认值, 用default 表示
     * ④如果自定义注解没有成员变量, 则表明是一个标识作用 如@Override
     *   如果自定义注解有成员变量,并且没有默认值,则在使用在注解的时候需要指明成员变量的值.
     * ⑤自动实现了java.lang.annotation.Annotation 接口
     * ⑥自定义注解必须配置上注解的信息处理流程(反射)才有效.
     */
    /**
     * JDK中的4个元注解:
     * @Retention: 修饰一个Annotation, 用来指定该注解的声明周期
     *
     * RetentionPolicy.SOURCE 在源文件(.java)中有效.编译时编译器会丢掉
     * RetentionPolicy.CLASS 在字节码文件(.class)中有效.运行时,JVM会丢掉.默认值
     * RetentionPolicy.RUNTIME 在运行时也有效 程序可以通过反射获取该注解
     *
     * @Target: 用来指定该注解可以修饰那些程序元素.
     *
     * @Documented 用来表明该注解类将被javadoc.exe工具提取成文档.
     *  如果一个自定义注解了被@Documented 修饰.则它的@RetenTion 必须是RUNTIME
     *
     *
     * @Inherited 用来表明该注解具有继承性, 如果一个类A.class使用该注解.则类A的子类也具有这个注解.
     */
    String value() default "hello";
}
