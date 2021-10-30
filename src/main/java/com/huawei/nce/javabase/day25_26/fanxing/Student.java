package com.huawei.nce.javabase.day25_26.fanxing;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/29 8:03
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student extends Person{
    /**
     * 学号
     */
    private int number;
    /**
     * 年级
     */
    private int state;
    /**
     * 分数
     */
    private int score;
}
