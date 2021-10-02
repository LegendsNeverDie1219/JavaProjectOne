package com.huawei.nce.javabase.day11.objectoriented.object;

import lombok.*;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/28 22:20
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Address implements Cloneable {
    private String type;
    private String value;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}