package com.huawei.nce.javabase.day28.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/11/13 17:35
 */
public class FieldTest {
    Class<Person> clazz = Person.class;
    @Test
    public void test() {
        System.out.println("clazz.getFields(): ==================");
        // getFields(): 获取当前运行时类的中的公有属性以及所有父类中的公有属性
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            //public int com.huawei.nce.javabase.day28.reflection.Person.id
            //public double com.huawei.nce.javabase.day28.reflection.Creature.weight
            System.out.println(field);
        }

        System.out.println("clazz.getDeclaredFields(): ===========================");
        // getDeclaredFields(): 获取当前运行时类中的所有属性包括私有属性.
        Field[] fields1 = clazz.getDeclaredFields();
        for (Field field : fields1) {
            //private java.lang.String com.huawei.nce.javabase.day28.reflection.Person.name
            //int com.huawei.nce.javabase.day28.reflection.Person.age
            //public int com.huawei.nce.javabase.day28.reflection.Person.id
            System.out.println(field);
        }
    }

    @Test
    public void test2() {
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            // 1.权限修饰符
            int modifiers = declaredField.getModifiers();
            System.out.print(Modifier.toString(modifiers) + '\t');
            // 2.数据类型
            Class<?> type = declaredField.getType();
            System.out.print(type.getName() + "\t");
            // 变量名
            String name = declaredField.getName();
            System.out.print(name);
            System.out.println();
        }
    }
}
