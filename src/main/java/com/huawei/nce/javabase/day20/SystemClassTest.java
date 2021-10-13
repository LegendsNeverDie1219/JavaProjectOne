package com.huawei.nce.javabase.day20;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/12 20:49
 */
public class SystemClassTest {
    @Test
    public void test1() {
        SubObject sub = new SubObject("name", 12);
        // 把栈内存中变量sub的置为null ,此时,堆内存中SubObject类的对象就没有变量再引用
        // 则该对象会被垃圾回收器标记为垃圾对象,等待被回收释放内存空间,但是时间不确定,被动回收
        sub = null;
        // 请求系统进行垃圾回收, 至于是否立刻回收,则取决于系统中的垃圾回收算法以及系统此时的状态.
        System.gc();
    }
    @Test
    public void test2() {
        // java运行时环境版本  1.8.0_181
        System.out.println(System.getProperty("java.version"));
        // java安装目录  C:\Program Files\Java\jdk1.8.0_181\jre
        System.out.println(System.getProperty("java.home"));
        // 操作系统名称   Windows 10
        System.out.println(System.getProperty("os.name"));
        // 操作系统版本号  10.0
        System.out.println(System.getProperty("os.version"));
        // 用户账户名称  Administrator
        System.out.println(System.getProperty("user.name"));
        // 用户主目录   C:\Users\Administrator
        System.out.println(System.getProperty("user.home"));
        // 用户当前工作目录  E:\IdeaProjects\javaproject\JavaModuleOne
        System.out.print(System.getProperty("user.dir"));
       // System.getProperty("line.separator");
        System.out.println(System.getProperty("line.separator"));
        System.out.println("===============================");
    }
}
@Setter
@Getter
@AllArgsConstructor
class SubObject {
    private String name;
    private int age;

    // 垃圾收集器回收该对象之前.总会先调用该对象的finalize()方法.
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        // 对象被回收,释放内存空间:com.huawei.nce.javabase.day20.SubObject@25062e72
        System.out.println("对象被回收,释放内存空间:" + this);
    }
}
