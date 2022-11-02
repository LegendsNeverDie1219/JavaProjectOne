package com.huawei.nce.javabase.day22.annotation.fruit;

/**
 * TODO
 *
 * @author Administrator
 * @date 2022/10/12 15:08
 */


import java.lang.annotation.*;

/**
 * 水果颜色注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
    /**
     * 颜色枚举
     */
    public enum Color {BLUE, RED, GREEN}

    ;

    /**
     * 颜色属性
     */
    Color fruitColor() default Color.GREEN;

}
