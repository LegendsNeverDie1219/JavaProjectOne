package com.huawei.nce.javabase.day17.team.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/3 23:39
 */
@Getter
@Setter
public class Designer extends  Programmer{
    private double bonus;

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getDetail() + "\t设计师\t"
                + getStatus().getNAME() + "\t" + getEquipment().getDescription()+ "\t" +getBonus();
    }
    @Override
    public String toStringTeamInfo() {
        return super.toStringTeamInfo();
    }
}
