package com.huawei.nce.javabase.day11.objectoriented.object;

import lombok.*;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/29 8:09
 */
public class FinalizeTest {
    /**
     * 程序员可以通过 System.gc() 或者Runtime.getRuntime().gc()来通知系统进行垃圾回收
     * 会有一些效果.但是系统是否进行回收,以及什么时间回收都是不确定的
     *
     * 垃圾收集器回收之前.总会先调用该对象的finalize()方法. (如果重写了该方法,并且让一个新的引用指向了这个对象
     *  则该对象会被重新激活.)
     *
     *  永远不要主动调用某个对象的finalize() 方法. 应该交给垃圾回收机制调用.
     *  但是子类可以重写此方法,可以在释放对象之前进行某些操作.
     * @param args args
     */
    public static void main(String[] args) {
        Human human = new Human("perter", 12);
        System.out.println(human);
        // 把栈内存中对象的应用置为null ,此时,堆内存中human对象就没有变量再引用
        // 则该对象会被垃圾回收器标记为垃圾对象,等待被回收释放内存空间,但是时间不确定
        human = null;
        //强制释放内存空间
        System.gc();
    }
}

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
class Human {
    private String name;
    private int age;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("对象被回收,释放内存空间->" + this);
    }
}
