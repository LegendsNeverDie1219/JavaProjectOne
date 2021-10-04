package com.huawei.nce.javabase.day17.team.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/3 23:05
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteBook implements Equipment{
    /**
     * 机器的型号
     */
    private String model;
    /**
     * 价格
     */
    private double price;
    /**
     * '
     * getDescription
     *
     * @return String
     */
    @Override
    public String getDescription() {
        return model + "(" + price + ")";
    }
}
