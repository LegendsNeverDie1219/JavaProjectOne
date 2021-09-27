package com.huawei.nce.javabase.day11.objectoriented.inheritance;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/27 22:05
 */
public class Account {
    private int id;
    /**
     * 余额
     */
    private double balance;
    /**
     * 年利率
     */
    private double annualInterestRate;

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public Account() {
        System.out.println("我是父类无参构造方法");
        this.id = 1122;
        this.balance = 20000;
        this.annualInterestRate = 0.045;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("您的余额不足, 您的余额为: " + balance);
            return;
        }
        balance -=amount;
        System.out.println("取钱成功,您的余额为: " + balance);
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("存钱成功,您的余额为: " + balance);
    }

    public double getMonthlyInterest() {
        return annualInterestRate/12;
    }

}
