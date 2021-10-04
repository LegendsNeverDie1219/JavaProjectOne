package com.huawei.nce.javabase.day17.team.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/3 23:25
 */
@Setter
@Getter
public class Programmer extends Employee {
    /**
     * 员工加入开发团队之后的在团队的id
     */
    private int memberId;

    private Status status = Status.FREE;

    private Equipment equipment;

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return getDetail() + "\t程序员\t" + status.getNAME() + "\t" + equipment.getDescription();
    }
    public String toStringTeamInfo() {
        return memberId+ "/" + toString();
    }
}
