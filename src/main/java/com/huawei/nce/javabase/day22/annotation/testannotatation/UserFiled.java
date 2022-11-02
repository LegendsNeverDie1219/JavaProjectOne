package com.huawei.nce.javabase.day22.annotation.testannotatation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TODO
 *
 * @author Administrator
 * @date 2022/10/12 15:02
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public@interface UserFiled {
    String name();
    String type();
    int length();
}
