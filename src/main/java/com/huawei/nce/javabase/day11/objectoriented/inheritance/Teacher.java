package com.huawei.nce.javabase.day11.objectoriented.inheritance;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/27 20:30
 */
public class Teacher extends  Person{
    private String subject;
    private char performance;

    public Teacher(String name, char sex, int age) {
        super(name, sex, age);
    }

    public Teacher(String name, char sex, int age, String subject, char performance) {
        super(name, sex, age);
        this.subject = subject;
        this.performance = performance;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public char getPerformance() {
        return performance;
    }

    public void setPerformance(char performance) {
        this.performance = performance;
    }
    public void earnMoney() {
        System.out.println("老师挣钱养家");
    }

    @Override
    public String work() throws IllegalArgumentException{
        return "老师工作:即好好挣钱";
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + getName() +
                "', sex=" + getSex() +
                ", age=" + getAge() +
                "subject='" + subject + '\'' +
                ", performance=" + performance +
                '}';
    }
}
