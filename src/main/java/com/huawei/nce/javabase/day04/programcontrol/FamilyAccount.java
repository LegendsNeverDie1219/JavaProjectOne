package com.huawei.nce.javabase.day04.programcontrol;

/**
 * FamilyAccountHds
 *
 * @author Administrator
 * @date 2021/9/10 16:44
 */
public class FamilyAccount {
    private static final String DETAILS = "收支\t\t账户金额\t\t收支金额\t\t说 明";

    public static void main(String[] args) {
        // 定义余额.
        double balance = 10000.0;
        StringBuilder detailsStingBuilder = new StringBuilder(DETAILS);
        boolean loopFlag = true;
        while (loopFlag) {
            System.out.println("-----------------家庭收支记账软件-----------------");
            System.out.println("                 1 收支明细");
            System.out.println("                 2 登记收入");
            System.out.println("                 3 登记支出");
            /* \n换行  \r回车.  System.getProperty("line.separator"); */
            System.out.println("                 4 退   出\n");
            System.out.print("请选择(1-4)：");
            /*
            nextInt()  读取键盘输入的 (tab, 回车, 空格)之前的字符,也就是遇到 \t,空格 \n \r, 这些空白字符结束
            nextLine()  读取键盘输入的(回车)之前的字符, 也就是遇到 \r \n结束
            */
            char c = ScannerUtils.readMenuOption();
            switch (c) {
                // 收支明细列表
                case '1': {
                    System.out.println("-----------------当前收支明细记录-----------------");
                    System.out.println(detailsStingBuilder);
                    System.out.println("--------------------------------------------------\n\n");
                    break;
                }
                // 收入登记
                case '2': {
                    System.out.print("本次收入金额: ");
                    double amount = ScannerUtils.readAmountMessage();
                    System.out.print("本次收入说明: ");
                    String descriptionInformation = ScannerUtils.readKeyBoardMessage(8);

                    balance += amount;
                    detailsStingBuilder.append("\n收入\t\t").append(balance)
                            .append("\t\t").append(amount).append("\t\t").append(descriptionInformation);
                    System.out.println("---------------------登记完成---------------------\n\n");
                    break;
                }
                // 支出登记
                case '3': {
                    System.out.print("本次支出金额: ");
                    double amount = ScannerUtils.readAmountMessage();
                    System.out.print("本次支出说明: ");
                    String descriptionInformation = ScannerUtils.readKeyBoardMessage(8);

                    balance -= amount;
                    detailsStingBuilder.append("\r\n支出\t\t").append(balance)
                            .append("\t\t").append(amount).append("\t\t").append(descriptionInformation);
                    System.out.println("---------------------登记完成---------------------\n\n");
                    break;
                }
                // 退出
                case '4': {
                    System.out.print("确认是否退出:(Y/N) ");
                    char confirmInformation = ScannerUtils.readConfirmInformation();
                    if (confirmInformation == 'Y') {
                        loopFlag = false;
                    }
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }
}
