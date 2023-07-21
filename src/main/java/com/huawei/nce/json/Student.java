package com.huawei.nce.json;

import lombok.*;

import java.util.Date;

/**
 * TODO
 *
 * @author Administrator
 * @date 2022/12/15 16:19
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    private Integer id;
   // @JSONField(name = "studentName")
    private String name;
    private Integer age;
    private String email;
    // @JSONField(format = "YYYY-MM-dd")
    private Date birthday;
}
