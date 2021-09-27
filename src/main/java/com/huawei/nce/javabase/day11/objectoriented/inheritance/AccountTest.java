package com.huawei.nce.javabase.day11.objectoriented.inheritance;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/27 22:16
 */
public class AccountTest {
    public static void main(String[] args) {
//        Account account = new Account();
//        account.withdraw(20000);
//        account.deposit(2000);

        CheckAccount checkAccount = new CheckAccount(5000);
       // checkAccount.withdraw(20000);
        checkAccount.withdraw(25000);
        checkAccount.withdraw(2000);

    }
}
