package com.huawei.nce.javabase.day18;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/6 11:38
 */
public class DeadLockTest {
    /**
     * 1.死锁的理解:
     * 不同的线程分别占用对方需要的同步的资源不放弃,
     * 都在等待对方放弃自己需要的同步资源.就形成了死锁.
     * <p>
     * 2.出现死锁之后,程序不会出现异常,不会出现提示,只不过所有的线程都处于阻塞状态.无法继续
     * <p>
     * 3.实际开发中,要避免死锁
     * ①专门的算法
     * ②尽量减少同步资源的定义
     * ③尽量避免嵌套同步
     *
     * @param args
     */
    public static void main(String[] args) {
        StringBuffer stringBuffer1 = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        // 共享数据和同步监视器可以一致.也可以不一致
        //比如之前的 ticket, Window.class
        // 现在的stringBuffer1 stringBuffer2
        new Thread() {
            @Override
            public void run() {
                synchronized (stringBuffer1) {
                    stringBuffer1.append("a");
                    stringBuffer2.append("1");
                    synchronized (stringBuffer2) {
                        stringBuffer1.append("b");
                        stringBuffer2.append("2");
                        System.out.println(stringBuffer1);
                        System.out.println(stringBuffer2);
                    }
                }
            }
        }.start();


        new Thread() {
            @Override
            public void run() {
                synchronized (stringBuffer2) {
                    stringBuffer1.append("c");
                    stringBuffer2.append("3");
                    synchronized (stringBuffer1) {
                        stringBuffer1.append("d");
                        stringBuffer2.append("4");
                        System.out.println(stringBuffer1);
                        System.out.println(stringBuffer2);
                    }
                }
            }
        }.start();

        /**
         * 情况一:
         *  ab
         * 12
         * abcd
         * 1234
         * 情况二:
         * cd
         * 34
         * cdab
         * 3412
         *
         * 情况三:
         * 死锁.
         */
    }
}
