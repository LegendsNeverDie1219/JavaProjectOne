package com.huawei.nce.javabase.day11.objectoriented.inheritance;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/27 20:15
 */
public class StudentTeacherPersonTest {
    public static void main(String[] args) throws Exception {
        Student student = new Student("小明同学", '男', 18, 007, 90, 95, 100);
        System.out.println(student);
        System.out.println(student.aver());
        System.out.println(student.max());
        System.out.println(student.min());
        student.eat();
        student.sleep();
        System.out.println(student.work());
        System.out.println("===============================");
        Teacher teacher = new Teacher("张老师", '女', 30, "数学", '优');
        System.out.println(teacher);
        teacher.eat();
        teacher.sleep();
        System.out.println(teacher.work());
    }
}
