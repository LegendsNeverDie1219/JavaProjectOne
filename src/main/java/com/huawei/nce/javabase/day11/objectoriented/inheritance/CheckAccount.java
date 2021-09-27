package com.huawei.nce.javabase.day11.objectoriented.inheritance;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/27 22:18
 */
public class CheckAccount extends Account{
    private double overdraft;
    public CheckAccount(double overdraft) {
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    @Override
    public void withdraw(double amount) {
//        super.withdraw(amount);
        if (getBalance() >= amount) {
            super.withdraw(amount);
            System.out.println("您的可透支余额为: " + overdraft);
        } else if (getBalance() + overdraft >= amount) {
            System.out.println("取钱成功,您的余额为: " + 0);
            overdraft -=(amount -getBalance());
            // 这个地方可能舒顺序容易写错.
            setBalance(0);
            System.out.println("您的可透支余额为: " + overdraft);
        } else {
            System.out.println("取钱失败.超过可透支余额");
        }
    }
}
