package com.huawei.nce.javabase.day08.objectoriented;

import java.util.Arrays;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/19 15:52
 */
public class ObjectOrientedTest {
    /**
     * main
     *
     * @param args args
     */
    public static void main(String[] args) {
        // testObjectOriented1();
        // testObjectOriented2();
    }

    /**
     * 对象数组题目：
     * 定义类Student，包含三个属性：学号number(int)，年级state(int)，成绩
     * score(int)。 创建20个学生对象，学号为1到20，年级和成绩都由随机数确定。
     * 问题一：打印出3年级(state值为3）的学生信息。
     * 问题二：使用冒泡排序按学生成绩排序，并遍历所有学生信息
     */
    private static void testObjectOriented2() {
        Student[] studentArray = new Student[20];
        for (int i = 0; i < studentArray.length; i++) {
            Student student = new Student();
            student.setNumber(i+1);
            int randomState = (int)(Math.random() * 6+ 1);
            student.setState(randomState);
            // [0,101) -> [0, 100]
            int randomScore = (int)(Math.random() * 100 + 1);
            student.setScore(randomScore);
            studentArray[i] = student;
        }
        Arrays.stream(studentArray).filter(student -> student.getState() ==3)
                .forEach(System.out::println);
        System.out.println("==============================================");
        sortStudentByScore(studentArray);
        printStudentInfo(studentArray);
    }

    private static void sortStudentByScore(Student[] studentArray) {
        for (int i = 0; i < studentArray.length -1; i++) {
            for (int j = 0; j < studentArray.length -1 -i; j++) {
                if (studentArray[j].getScore() > studentArray[j+1].getScore()) {
                    Student temp =  studentArray[j];
                    studentArray[j] = studentArray[j +1];
                    studentArray[j +1] = temp;
                }
            }
        }
    }

    private static void printStudentInfo(Student[] studentArray) {
        for (Student student : studentArray) {
            System.out.println(student);
        }
    }

    private static void testObjectOriented1() {
        Person person = new Person();
        person.name = "hds";
        person.age = 25;
        person.sex = "male";
        person.eat();
        person.talk("汉语");

        person.addAge(2);
        person.showAge();

        Person personTwo = new Person();
        personTwo.name = "huge";
        personTwo.showAge();
    }
}
