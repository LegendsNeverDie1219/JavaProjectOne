package com.huawei.nce.javabase.day14.abstracttest.salarysytem;

import java.util.Calendar;
import java.util.Locale;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/1 17:29
 */
public class PayrollSystem {
    public static void main(String[] args) {
        Employee[] employees = new Employee[2];
        employees[0] = new HourlyEmployee("hds", 11, new MyDate(1995, 12, 19), 50, 8);
        employees[1] = new SalariedEmployee("zl", 12, new MyDate(1995, 10, 19), 3000);

        Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
        int month = calendar.get(Calendar.MONTH);
        System.out.println(month);

        for (Employee employee : employees) {
            System.out.println(employee);
            double salary = employee.earnMoney();
            int birthdayMonth = employee.getBirthday().getMonth();
            if (month+1 == birthdayMonth) {
                System.out.println("'生日快乐,加薪100");
                salary += 100;
            }
            System.out.println("月工资为: " + salary);
        }



    }
}
