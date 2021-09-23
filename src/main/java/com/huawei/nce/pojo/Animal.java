package com.huawei.nce.pojo;

import lombok.*;

/**
 * TODO
 *
 * @author Administrator
 * @date 2020/9/12 17:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Animal {
    private String name;
    private Integer age;
    private Integer type;
}
