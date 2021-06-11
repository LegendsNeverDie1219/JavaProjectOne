package com.huawei.nce.pojo;

import lombok.*;


/**
 *
 *
 * @author Administrator
 * @date 2020/9/6 15:03
 */
/***
 * @Data注解相当于下面的四个注解,五合一
 **/
@Setter
@Getter
@ToString
@EqualsAndHashCode

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    private String name;
    private String color;
    private Double price;
    private Integer num;

    public Product(Integer num) {
        this.num = num;
    }
}
