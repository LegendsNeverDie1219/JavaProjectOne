package com.huawei.nce.javabase.day17.team.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/3 23:22
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Printer implements Equipment{
    private String name;
    private String type;

    /**
     * getDescription
     *
     * @return String
     */
    @Override
    public String getDescription() {
        return name + "(" + type +")";
    }
}
