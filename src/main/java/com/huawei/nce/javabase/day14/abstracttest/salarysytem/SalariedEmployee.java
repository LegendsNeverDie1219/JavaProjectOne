package com.huawei.nce.javabase.day14.abstracttest.salarysytem;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/1 17:16
 */
public class SalariedEmployee extends Employee{
    // 月工资
    private double monthlySalary;

    public SalariedEmployee(String name, int number, MyDate birthday, double monthlySalary) {
        super(name, number, birthday);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double earnMoney() {
        return monthlySalary;
    }

    @Override
    public String toString() {
        String str = super.toString();
        return "SalariedEmployee{" + str +
                " monthlySalary=" + monthlySalary +
                '}';
    }
}
