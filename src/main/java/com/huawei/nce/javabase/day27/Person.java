package com.huawei.nce.javabase.day27;

import lombok.*;

import java.io.Serializable;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/11/2 22:29
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person implements Serializable {
    /**
     * serialVersionUID:用于表明类的不同版本的兼容性.
     * 如果没有定义serialVersionUID,它也会在java runtime根据类的内部细节自动生成一个,
     * 但是如果类的实例变量作了修改.那么在实例序列化的时候serialVersionUID 也会变化.
     *
     * 在反序列化的时候,JVM会将字节流中的序列化ID,和类中定义/生成的序列化ID 进行比较.
     * 如果类的版本更新了,则会产生不相等的问题,会报InvalidCastException
     */
    private static final long serialVersionUID = -8074329006016353957L;
    private String name;
    private Integer age;
}
