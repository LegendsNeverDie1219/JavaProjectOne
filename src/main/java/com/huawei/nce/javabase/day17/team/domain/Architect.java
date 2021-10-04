package com.huawei.nce.javabase.day17.team.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/3 23:45
 */
@Setter
@Getter
public class Architect extends Designer {
    private int stock;

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getDetail() + "\t架构师\t" + getStatus().getNAME() + "\t" + getEquipment().getDescription() +
                "\t" + getBonus() + "\t" + getStock();
    }
    @Override
    public String toStringTeamInfo() {
        return super.toStringTeamInfo();
    }
}
