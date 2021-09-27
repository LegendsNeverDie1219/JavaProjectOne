package com.huawei.nce.javabase.day11.objectoriented.inheritance;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/27 20:02
 */
public class Student extends Person{
    private long number;
    private int math;
    private int english;
    private int computer;

    public Student(String name, char sex, int age) {
//        super();
        super(name, sex, age);
    }

    public Student(String name, char sex, int age, long number, int math, int english, int computer) {
        super(name, sex, age);
        this.number = number;
        this.math = math;
        this.english = english;
        this.computer = computer;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getComputer() {
        return computer;
    }

    public void setComputer(int computer) {
        this.computer = computer;
    }

    public double aver() {
        return (this.math + this.english + this.computer)/3;
    }

    public int max() {
        int tempMax = this.math > this.english ? this.math : this.english;
        return tempMax > this.computer ? tempMax : this.computer;
    }

    public int min() {
        int tempMin = Math.min(this.math, this.english);
        return Math.min(tempMin, this.computer);
    }

    @Override
    public String work() throws IllegalArgumentException{
        return "学生工作:即好好学习";
    }

    @Override
    public void eat() {

        System.out.println("学习应该多吃有营养的食物");
        sleep();

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() +
                "', sex=" + getSex() +
                ", age=" + getAge() +
                ", number=" + number +
                ", math=" + math +
                ", english=" + english +
                ", computer=" + computer +
                '}';
    }



}
