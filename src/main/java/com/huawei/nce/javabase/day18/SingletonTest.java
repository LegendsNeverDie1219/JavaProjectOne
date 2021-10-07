package com.huawei.nce.javabase.day18;


/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/6 11:23
 */
public class SingletonTest {

}
class Singleton{
    private static Singleton singleton;
    private  Singleton() {}

    public static Singleton getInstance() {
        // 如果不为空,就不让众多线程阻塞排队了.直接返回对象的引用地址.  目的: 提高效率.
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
//
//    @Override
//    public void run() {
//        super.run();
//    }
}