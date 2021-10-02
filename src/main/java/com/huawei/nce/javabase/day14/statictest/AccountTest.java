package com.huawei.nce.javabase.day14.statictest;

import lombok.Getter;
import lombok.Setter;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/1 11:35
 */
public class AccountTest {
    /**
     * 编写一个类实现银行账户的概念，包含属性有“帐号”、密码”、“存款余额利率最小”，定义封装这些属性的方法。 账号要自动生成。
     * 编写主类，使用银行账户输入、出 编写主类，使用银行账户输入、出 编写主类，使用银行账户输入、出 编写主类，使用银行账户输入、出 编写主类，使用银行账户输入、出 编写主类，使用银行账户输入、出
     * 编写主类，使用银行账户输入、出 编写主类，使用银行账户输入、出 3个储户的上述信息。
     * 考虑：哪些属性可以设计成 考虑：哪些属性可以设计成 考虑：哪些属性可以设计成 考虑：哪些属性可以设计成 static属性
     * @param args
     */
    public static void main(String[] args) {
        Account account1 = new Account();
        Account account2 = new Account("7758258",2000);

        System.out.println("最小余额利率: " + Account.getInterestRate());
        System.out.println("最小存款金额: " + Account.getMinMoney());
        System.out.println(account1);
        System.out.println(account2);

    }
}
@Setter
@Getter
class Account {
    private int id;
    private String passWord;
    private double balance;

    @Getter
    private static double interestRate = 0.005;
    @Getter
    private static double minMoney= 1.0;

    private static int initId;

    public Account() {
        id = initId++;
    }

    public Account(String passWord, double balance) {
        id = initId++;
        this.passWord = passWord;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", passWord='" + passWord + '\'' +
                ", balance=" + balance +
                '}';
    }
}
