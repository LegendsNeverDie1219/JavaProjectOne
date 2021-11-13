package com.huawei.nce.javabase.day28;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/11/13 17:00
 */
public class ReflectionTest2 {
    // 体会反射的动态性 : 即在编译期间无法确定要创建那个类的对象. 只有在运行期间才可以确定. 这个时候就要用到了反射这个技术.
    @Test
    public void test() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        for (int i = 0; i < 10; i++) {
            // [0,3)
            int num = new Random().nextInt(3);
            String classpath = getClassPathByNum(num);
            //
            Object obj = getInstance(classpath);
            System.out.println(obj);
        }
    }

    private String getClassPathByNum(int num) {
        String classpath = "";
        switch (num) {
            case 0:
                classpath = "java.util.Date";
                break;
            case 1:
                classpath = "com.huawei.nce.javabase.day28.Dog";
                break;
            case 2:
                classpath = "com.huawei.nce.javabase.day28.Person";
                break;
            default:
                break;
        }
        return classpath;
    }

    private Object getInstance(String classpath) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException {
        Class<?> clazz = Class.forName(classpath);
        return clazz.newInstance();
    }
}
