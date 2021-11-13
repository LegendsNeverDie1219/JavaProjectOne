package com.huawei.nce.javabase.day28.reflection;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/11/13 17:54
 */
public class MethodTest {
    @Test
    public void test() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.huawei.nce.javabase.day28.reflection.Person");
        // clazz.getMethods():  获取运行时类中的所有公有方法.包括所有父类,接口中的公有方法.
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            //public int com.huawei.nce.javabase.day28.reflection.Person.compareTo(java.lang.Object)
            //public int com.huawei.nce.javabase.day28.reflection.Person.compareTo(com.huawei.nce.javabase.day28
            // .reflection.Person)
            //public void com.huawei.nce.javabase.day28.reflection.Person.info()
            //public java.lang.String com.huawei.nce.javabase.day28.reflection.Person.display(java.lang.String)
            //public void com.huawei.nce.javabase.day28.reflection.Creature.eat(java.lang.Object)
            //public final void java.lang.Object.wait() throws java.lang.InterruptedException
            //public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
            //public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
            //public boolean java.lang.Object.equals(java.lang.Object)
            //public java.lang.String java.lang.Object.toString()
            //public native int java.lang.Object.hashCode()
            //public final native java.lang.Class java.lang.Object.getClass()
            //public final native void java.lang.Object.notify()
            //public final native void java.lang.Object.notifyAll()
            //public default void com.huawei.nce.javabase.day28.reflection.MyInterface.show()
            System.out.println(method);
        }
        System.out.println();
        // clazz.getDeclaredMethods() : 获取运行时类中的所有方法包括私有方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            //public int com.huawei.nce.javabase.day28.reflection.Person.compareTo(java.lang.Object)
            //public int com.huawei.nce.javabase.day28.reflection.Person.compareTo(com.huawei.nce.javabase.day28
            // .reflection.Person)
            //public void com.huawei.nce.javabase.day28.reflection.Person.info()
            //private java.lang.String com.huawei.nce.javabase.day28.reflection.Person.show(java.lang.String)
            //public java.lang.String com.huawei.nce.javabase.day28.reflection.Person.display(java.lang.String)
            System.out.println(declaredMethod);
        }
    }
    
    @Test
    public void test2() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.huawei.nce.javabase.day28.reflection.Person");
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            Annotation[] annotations = declaredMethod.getAnnotations();
            // 1.获取方法注解
            for (Annotation annotation : annotations) {
                System.out.print(annotation.toString() + '\t');
            }
            // 2.权限修饰符
            System.out.print(Modifier.toString(declaredMethod.getModifiers()) + '\t');
            //3.返回值类型
            System.out.print(declaredMethod.getReturnType().getName() + '\t');
            //4.方法名
            System.out.print(declaredMethod.getName() + '\t');
            // 5.形参列表
            System.out.print("(");
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            if(!(parameterTypes.length == 0)) {
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i == parameterTypes.length -1) {
                        System.out.print(parameterTypes[i].getName() + " args_" + i);
                        break;
                    }
                    System.out.print(parameterTypes[i].getName() + " args_" + i + ",");
                }
            }
            System.out.print(")");

            //6,抛出的异常
            Class<?>[] exceptionTypes = declaredMethod.getExceptionTypes();
            if (!(exceptionTypes.length == 0)) {
                System.out.print("throws: ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if (i == exceptionTypes.length -1) {
                        System.out.print(exceptionTypes[i].getName() + " args_" + i);
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName() + " args_" + i + ",");
                    
                }
            }

            System.out.println();
        }
    }
}
