package com.huawei.nce.javabase.day20;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/11 8:11
 */
@Setter
@Getter
@AllArgsConstructor
@ToString
public class Goods implements Comparable {
    private String name;
    private double price;

    @Override
    public int compareTo(Object obj) {
        if (!(obj instanceof Goods)) {
            throw new RuntimeException("该对象不是Goods类型/Goods子类型的对象");
        }
        Goods goods = (Goods) obj;
        if (this.price > goods.price) {
            return 1;
        } else if (this.price < goods.price) {
            return -1;
        } else {
            if (this.name.compareTo(goods.name) > 0) {
                return 1;
            } else if (this.name.compareTo(goods.name) < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }
//
//    @Override
//    public int compareTo(Goods o) {
//        return 0;
//    }
}
