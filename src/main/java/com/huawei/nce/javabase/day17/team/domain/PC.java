package com.huawei.nce.javabase.day17.team.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/3 23:19
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PC implements Equipment {
    /**
     * 机器型号
     */
    private String model;
    /**
     * 显示器名称
     */
    private String display;
    /**
     * '
     * getDescription
     *
     * @return String
     */
    @Override
    public String getDescription() {
        return model + "(" + display + ")";
    }
}
