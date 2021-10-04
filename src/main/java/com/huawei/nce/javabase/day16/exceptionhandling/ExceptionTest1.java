package com.huawei.nce.javabase.day16.exceptionhandling;


import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/2 16:42
 */
public class ExceptionTest1 {
    /**
     * 一.异常的处理:抓抛模型
     *  过程一: 抛异常.
     *        程序在执行的过程中,一旦出现异常,就会在出现异常的那一行代码处生成一个异常类的对象,并且抛出,后续的代码就不再执行.
     *        关于异常的产生:
     *        ①系统自动生成的异常对象
     *        ②手动new的的异常对象,并抛出(throw)
     *  过程二: 抓异常,即处理异常的两种方式: ①try-catch-finally ②throws
     *
     *  二.try-catch-finally的使用
     *  1.结构
     *  try {
     *     可能出现异常的代码块
     *  } catch(异常类  e) {
     *     处理异常
     *  } finally {
     *      // 一定会执行的代码块.
     *  }
     *  2.流程
     * 其中finally 是可选的,一旦程序中出现了异常.就会生成一个异常类的对象,
     * 然后就拿这个异常类对象的类型跟catch语句块中的类型进匹配,匹配到了,就会执行里面的处理异常的逻辑
       接着.会执行finally 语句块中的逻辑.
       最后退出try-catch-finally结构, 继续执行下面的代码.
     *3.finally
     * finally里面的代码是一定会执行的,即使catch语句块里面有异常,或者try /catch里面有return语句.
     * 像数据源连接,输入输出流.Socket这些资源,JVM是无法执行回收操作的,所有需要我们手动去释放这些资源.
     * 这个时候就要把语句写入到finally中.
     *
     *4.开发中,由于运行异常比较常见,所以通常就不针对运行时异常编写 try -catch -finally
     *
     * 三.throws的使用
     *1. throws + 异常类型 写在方法的声明处.指明此方法在执行时,可能会抛出该类型的异常
     * 一旦代码执行过程中出现异常,会生成一个异常类对象, 然后判断该对象的类型是否是throw 后面异常类型/子类
     *  如果是,则会向上抛出. 这个方法中后续的代码就不继续执行了.
     *
     *  2.try-catch -finally 是真正的把异常给处理掉了. throws只是把异常抛给了调用者而已
     *
     *  3.开发中如何选择处理异常的方式?
     *
     *  3.1 如果父类中被重写的方法上没有添加throws + 异常类型.则 子类重写该方法时产生的异常需要自己
     *  try-catch-finally 掉
     *  3.2如果是在执行方法a时 方法a内部连续的调用了 方法b, c,d (都有异常要处理) 而且上一个方法的返回值是下一个方法的入参.
     *  则此时方法b,c,d产生的异常需要向上抛出. 方法a中可以使用try -catch -finally 捕获.
     *
     */

    @Test
    public void test5() {
        String str = "123";
        str = "abc";
        int num = 0;
        try {
            num  = Integer.parseInt(str);
            System.out.println("hello -try");
            return;
        } catch (NumberFormatException e) {
            System.out.println("出现了数值转换异常了.请检查入参格式");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("hello- finally");
        }
        System.out.println("num: " + num);


    }
    @Test
    public void test6() {
        int num = testMethod();
        System.out.println("num is: " + num);
    }

    private int testMethod() {
        try {
            int[] arr = new int[10];
            System.out.println(arr[10]);
            return 1;
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            return 2;
        } finally {
            System.out.println("我一定会被执行");
           // return 3;
        }
    }

    @Test
    public void test7() {
       FileInputStream fileInputStream = null;
        File file = new File("hello.txt");
        try {
           fileInputStream = new FileInputStream(file);
            int data = fileInputStream.read();
            while (data != -1) {
                System.out.println((char)data);
                data = fileInputStream.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    @Test
    public void test8() {
        Student student = new Student();
        try {
            student.regist(313131);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class Student {
    private int id;

    public void regist(int id) {
        if (id > 0) {
            this.id = id;
            System.out.println(this.id);
        } else {
            throw new IllegalArgumentException("您输入的数据非法111");
        }
    }
}
