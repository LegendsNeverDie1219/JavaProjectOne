package com.huawei.nce.javabase.day14.abstracttest.salarysytem;


/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/1 17:22
 */
public class HourlyEmployee extends Employee{
    // 每小时的工资
    private double wage;
    private  int hour;

    public HourlyEmployee(String name, int number, MyDate birthday, double wage, int hour) {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }


    @Override
    public double earnMoney() {
        return wage * hour;
    }

    @Override
    public String toString() {
        String str = super.toString();
        return "HourlyEmployee{" + str +
                " wage=" + wage +
                ", hour=" + hour +
                '}';
    }
}
