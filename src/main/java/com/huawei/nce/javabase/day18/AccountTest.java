package com.huawei.nce.javabase.day18;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/6 12:17
 */
public class AccountTest {
    /**
     * 银行有一个账户。
     * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打
     * 印账户余额。
     * 问题：该程序是否有安全问题，如果有，如何解决？
     * 【提示】
     * 1，明确哪些代码是多线程运行代码，须写入run()方法
     * 2，明确什么是共享数据。
     * 3，明确多线程运行代码中哪些语句是操作共享数据的。
     */
    public static void main(String[] args) {
        Account account = new Account();
        new Thread(account, "储户hds").start();
        new Thread(account, "储户zl").start();
    }
}

class Account implements Runnable {
    private double balance;

    /**
     * ①涉及到多线程
     * ②涉及到多线程共享数据
     */
    @Override
    public void run() {
        // 1.多线程运行的代码
        // 2.共享数据 balance. -> 需要同步的代码
        // 3.同步监视器 this/ xxx.class
        for (int i = 0; i < 3; i++) {
            synchronized (this) {
                balance += 1000;
                System.out.println(Thread.currentThread().getName() + "往账户中存钱1000, 余额为: " + balance);
            }
        }
    }
}
