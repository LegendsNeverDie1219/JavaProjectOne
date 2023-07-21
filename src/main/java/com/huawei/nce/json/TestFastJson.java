package com.huawei.nce.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * TODO
 *
 * @author Administrator
 * @date 2022/12/15 16:23
 */
public class TestFastJson {
    @Test
    public void test1() {
        Student student = getStudent();
        // {"age":20,"birthday":1671092841544,"email":"zs@qq.com","id":1,"name":"张三"}
        String objStr = JSON.toJSONString(student);
        System.out.println(objStr);
    }

    @Test
    public void test2() {
        Student student = getStudent();
        Student student2 = getStudent2();
        List<Student> students = Lists.newArrayList(student, student2);
        // [{"age":20,"birthday":1671093093130,"email":"zs@qq.com","id":1,"name":"张三"},{"$ref":"$[0]"}]
        // [{"age":20,"birthday":1671093153118,"email":"zs@qq.com","id":1,"name":"张三"},{"age":20,"birthday":1671093153118,"email":"zs@qq.com","id":1,"name":"张三"}]
        String listStr = JSON.toJSONString(students);
        System.out.println(listStr);

    }

    @Test
    public void test3() {
        Student student = getStudent();
        Student student2 = getStudent2();
        Map<String,Object> map = new HashMap<>();
        map.put("student1",student );
        map.put("student2",student2 );
    //{"student2":{"age":20,"birthday":1671093344560,"email":"ls@qq.com","id":2,"name":"李四"},"student1":{"age":20,"birthday":1671093344559,"email":"zs@qq.com","id":1,"name":"张三"}}
        String s = JSON.toJSONString(map);
        System.out.println(s);

    }


    @Test
    public void test4() {
        String str = "{\"age\":20,\"birthday\":1671092841544,\"email\":\"zs@qq.com\",\"id\":1,\"name\":\"张三\"}";
        Student student = JSON.parseObject(str, Student.class);
        System.out.println(student);
    }

    @Test
    public void test5() {
        String str = "[{\"age\":20,\"birthday\":1671093153118,\"email\":\"zs@qq.com\",\"id\":1,\"name\":\"张三\"}," +
                "{\"age\":20,\"birthday\":1671093153118,\"email\":\"zs@qq.com\",\"id\":1,\"name\":\"张三\"}]";
        List<Student> students = JSON.parseArray(str, Student.class);
        System.out.println(students);
    }

    @Test
    public void test6() {
        String str = "{\"student2\":{\"age\":20,\"birthday\":1671093344560,\"email\":\"ls@qq.com\",\"id\":2," +
                "\"name\":\"李四\"},\"student1\":{\"age\":20,\"birthday\":1671093344559,\"email\":\"zs@qq.com\"," +
                "\"id\":1,\"name\":\"张三\"}}";
        Map<String,Student> map = JSON.parseObject(str, new TypeReference<Map<String, Student>>() {
        });
        Set<Map.Entry<String, Student>> entries = map.entrySet();
        for (Map.Entry<String, Student> entry : entries) {
            String key = entry.getKey();
            Student value = entry.getValue();
            System.out.println(key + " -> " + value);

        }
    }


    @Test
    public void test7() {
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
        //student.setAge(20);
        //student.setEmail("zs@qq.com");
        student.setBirthday(new Date());

        // {"age":20,"birthday":1671094950031,"email":null,"id":1,"name":"张三"}
        // String s = JSON.toJSONString(student, SerializerFeature.WriteMapNullValue);
        // System.out.println(s);
        // // {"age":20,"birthday":1671094950031,"email":"","id":1,"name":"张三"}
        // String s2 = JSON.toJSONString(student, SerializerFeature.WriteNullStringAsEmpty);
        // System.out.println(s2);
        // // {"age":0,"birthday":1671095033122,"email":null,"id":1,"name":"张三"}
        // String s3 = JSON.toJSONString(student, SerializerFeature.WriteNullNumberAsZero);
        // System.out.println(s3);
        //{"birthday":"2022-12-15 17:06:49","id":1,"name":"张三"}
        //String s4 = JSON.toJSONString(student, SerializerFeature.WriteDateUseDateFormat,
                //SerializerFeature.PrettyFormat);
        String s4 = JSON.toJSONString(student, SerializerFeature.WriteDateUseDateFormat);
        System.out.println(s4);
    }

    @Test
    public void test8() {
        Student student = getStudent();
        // {"age":20,"birthday":"2022-12-15","email":"zs@qq.com","id":1,"studentName":"张三"}
        System.out.println(JSON.toJSONString(student));


    }

    private Student getStudent2() {
        Student student = new Student();
        student.setId(2);
        student.setName("李四");
        student.setAge(20);
        student.setEmail("ls@qq.com");
        student.setBirthday(new Date());
        return student;
    }

    private Student getStudent() {
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
        student.setAge(20);
        student.setEmail("zs@qq.com");
        student.setBirthday(new Date());
        return student;
    }

}
