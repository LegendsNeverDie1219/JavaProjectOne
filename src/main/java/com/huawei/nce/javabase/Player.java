package com.huawei.nce.javabase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * TODO
 *
 * @author Administrator
 * @date 2022/9/9 19:45
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    private String name;
    private String age;

    public String getName() {
        return name;
    }
}
