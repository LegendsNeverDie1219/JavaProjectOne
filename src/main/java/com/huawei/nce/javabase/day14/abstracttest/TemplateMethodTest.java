package com.huawei.nce.javabase.day14.abstracttest;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/1 16:54
 */
public class TemplateMethodTest {
    /**
     * 多态的应用：模板方法设计模式(TemplateMethod)
     *
     * 软件开发中实现一个算法, 整体的流程是固定的,通用的,
     * 那整个的流程会在父类中写好.
     * 其中某一步骤是易变的,则需要把该步骤抽象出来. 让不同的子类去实现.
     * 这就是模板的设计模式.
     */

    /**
     * 模板方法设计模式是编程中经常用得到的模式。各个框架、类库中都有他的
     * 影子，比如常见的有：
     *  数据库访问的封装
     *  Junit单元测试
     *  JavaWeb的Servlet中关于doGet/doPost方法调用
     *  Hibernate中模板程序
     *  Spring中JDBCTemlate、HibernateTemplate等
     * @param args
     */
    public static void main(String[] args) {
        Template template = new SubTemplate();
        template.getTime();
    }

}

abstract class Template {
    public final void getTime() {
        long start = System.currentTimeMillis();
        code();
        long end = System.currentTimeMillis();
        System.out.println("执行时间为: " + (end-start));
    }

    protected abstract void code();
}

class SubTemplate extends Template {

    @Override
    protected void code() {
        for(int i = 0; i < 100000; i++) {
            System.out.println(i);
        }
    }
}
