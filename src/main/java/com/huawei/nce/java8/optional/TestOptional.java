package com.huawei.nce.java8.optional;

import com.google.common.collect.Lists;
import com.huawei.nce.pojo.Student;
import com.huawei.nce.pojo.StudentEnum;
import org.junit.jupiter.api.Test;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author Administrator
 * @date 2020/9/12 13:28
 */
public class TestOptional {
    private static List<Student> studentList;

    static {
        studentList = Lists.newArrayList(
                new Student(3, "HUOJIANHUA", 20),
                new Student(1, "HUGE", 19),
                new Student(2, "TANGYAN", 18)
                // new Student(4,"YANGMI",18)
        );
    }

    // 创建Optional
    @Test
    public void test1() {
        // 1.Optional.empty()创建一个空的optional实例
        System.out.println("Optional.empty() ========================");
        System.out.println(Optional.empty());

        // 2.Optional.of(T value)创建一个optional实例 当value值为空的时候,会抛异常
        System.out.println("Optional.of(value) value值为一个对象");
        Optional<Student> student1 = Optional.of(new Student(null, "赵敏", 18));
        System.out.println(student1.get());
        System.out.println("Optional.of(value) value值为一个null对象");
        //Optional<Student> student2 = Optional.of(null);
        //System.out.println(student2);

        // 3.Optional.ofNullable(T value) 如果value不为null,则创建一个Optional实例,否则创建一个空实例
        System.out.println("Optional.ofNullable(value) value值为一个对象 ");
        Optional<Student> student3 = Optional.ofNullable(new Student(null, "张无忌", 20));
        System.out.println(student3.get());
        System.out.println("Optional.ofNullable(value) value值为一个null对象 ");
        Optional<Object> student4 = Optional.ofNullable(null);
        System.out.println(student4);
        //System.out.println(student4.get());
    }

    //  判断Optional
    @Test
    public void test2() {
        // 1. isPresent() 判断optional对象是否为空,如果为空则返回false,否则则返回true
        System.out.println("isPresent() 传入null:  " + Optional.ofNullable(null).isPresent());
        System.out.println("isPresent() 传入对象: " + Optional.ofNullable(new Student()).isPresent());

        // 2.ifPresent(Consumer c) 如果optional对象不为空,则将optional对象中的值传给Consumer函数,否则不执行任何操作
        Optional<Student> studentOptional = Optional.ofNullable(null);
        studentOptional.ifPresent(student -> System.out.println("optional.ifPresent(c) optional为空不执行: " + student.getName()));
        Optional<Student> studentOptional2 = Optional.ofNullable(new Student());
        studentOptional2.ifPresent(student -> System.out.println("optional.ifPresent(c) optional不为空不执行: " + student.getName()));

        // 3.orElse(T other) 如果optional对象不为空,则返回optional对象中的值,否则返回other的默认值
        System.out.println("optional.orElse(other) optional为空,返回other: " +
                Optional.ofNullable(null).orElse("default"));
        System.out.println("optional.orElse(other) optional不为空,返回optional对象中的值: " +
                Optional.ofNullable(new Student()).orElse(null));

        // 4.orElseGet(Supplier<T> other) 如果optional对象不为空,则返回optional对象中的值.否则使用Suppier函数生成一个默认值
        Optional<Student> op1 = Optional.of(new Student(null, "张无忌", 20));
        //op1 = Optional.empty();
        Student student = op1.orElseGet(() -> new Student());
        System.out.println("测试optional.orElseGet(): " + student);
        // 5.orElseThrow(Supplier<X> exception)如果optional不为空，则返回optional中的对象；如果为null，则抛出Supplier函数生成的异常
        Optional<Student> op2 = Optional.of(new Student(null, "周芷若", 18));
        //op2 = Optional.empty();
        Student student2 = op2.orElseThrow(IllegalArgumentException::new);
        System.out.println("测试optional.orElseThrow(): " + student2);


    }

    // 过滤
    @Test
    public void test3() {
        //如果optional对象不为空(存在值)，并且值与给定谓词匹配，则返回描述该值的Optional，否则返回空Optional
        Optional<Student> userOptional = Optional.ofNullable(new Student(null, "周芷若", 18));
        //userOptional = Optional.empty();
        Optional<Student> result = userOptional.filter(student -> student.getName() == "周芷若");
        System.out.println(result);
    }

    // 映射
    @Test
    public void test4() {
        // 如果optional对象不为空(存在值),则将映射函数应用于该值,并返回描述结果的Optional,否则返回空的Optional  即使Optional.empty
        Optional<Student> userOptional = Optional.ofNullable(new Student(null, "周芷若", 18));
        userOptional = Optional.empty();
        Optional<String> s = userOptional
                .map(Student::getName);
        System.out.println(s);
    }

    // 过滤&映射
    @Test
    public void test5() {
        Integer age = 0;
        List<Student> fiterStudentList = studentList.stream()
                .filter(student -> StudentEnum.YANGMI.toString().equals(student.getName())).collect(Collectors.toList());
        // 集合的大小为0不代表集合为null
        System.out.println(fiterStudentList.size());
        if (!CollectionUtils.isEmpty(fiterStudentList)) {
             age = Optional.ofNullable(fiterStudentList.get(0)).map(Student::getAge).orElse(0);
        }
        System.out.println(age);
    }

    // 枚举
    @Test
    public void test6() {
        System.out.println(StudentEnum.HUGE);
        System.out.println(StudentEnum.HUGE.name());
        System.out.println(StudentEnum.HUGE.getValue());
    }

}
