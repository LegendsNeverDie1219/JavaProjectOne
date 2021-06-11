package com.huawei.nce.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @author Administrator
 * @date 2020/9/12 16:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    private Integer id;
    private String name;
    private Integer age;
}
