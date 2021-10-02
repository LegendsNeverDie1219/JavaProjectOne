package com.huawei.nce.javabase.day11.objectoriented.object;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Arrays;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/29 20:43
 */
@NoArgsConstructor
@AllArgsConstructor
public class MyString {
    private char[] value;

    @Override
    public boolean equals(Object obj) {
        // 是一个对象,则为true
        if (this == obj) {
            return true;
        }
        // 入参实例 是否为 该类/该类子类的对象
        if (obj instanceof MyString) {
            MyString anotherString = (MyString) obj;
            char[] charArray = anotherString.value;
            int length = this.value.length;
            // 长度是否相等
            if (length == charArray.length) {
                // 遍历两个数组相同下标的字符.
                for (int i = 0; i < length; i++) {
                    if (value[i] != charArray[i]) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(value);
    }
}