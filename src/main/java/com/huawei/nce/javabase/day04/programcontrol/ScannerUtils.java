package com.huawei.nce.javabase.day04.programcontrol;

import java.util.Locale;
import java.util.Scanner;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/10 21:22
 */
public class ScannerUtils {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static double readAmountMessage() {
        double amount = 0.0;
        while(SCANNER.hasNext()) {
            String amountMessage = readKeyBoardMessage(4);
            try {
                amount = Double.parseDouble(amountMessage);
                break;
            } catch (NumberFormatException e) {
                System.out.println("录入的金额信息不正确,请重新录入");
            }
        }
        return amount;

    }

    public static char readConfirmInformation() {
        char c = 0;
        while(SCANNER.hasNext()) {
            String confirmMessage = readKeyBoardMessage(1);
            c = confirmMessage.toUpperCase(Locale.ENGLISH).charAt(0);
            if (c != 'Y' && c != 'N') {
                System.out.println("你输入的退出确认信息有误,请重新输入");
                continue;
            }
            break;
        }
      return c;
    }

    /**
     * 读取菜单选项(字符长度限制  limit)
     *
     * @return String String
     */
    public static char readMenuOption() {
        //todo
        char c;
        for(;;) {
            String str = readKeyBoardMessage(1);
            c = str.charAt(0);
            if (c != '1' && c != '2' && c != '3' && c!= '4') {
                System.out.println("你输入的菜单选项不合法,请重新输入");
                continue;
            }
            break;
        }
        return c;
    }

    /**
     * 读取键盘录入信息(字符长度限制  limit)
     *
     * @param limit limit
     * @return String String
     */
    public static String readKeyBoardMessage(int limit) {
        // 首先选择nextLine()方法,只有键盘录入回车才会结束读取字符.
        // 其次是for循环/while循环 当键盘录入的字符范围正确,则通过break结束循环,否则打印提示信息,让用户重新输入.
        /*hasNext()方法,会扫描输入(缓冲区),判断是否有字符,如果有,返回true,如果没有,则将方法阻塞,并不返回false.
         * 所以需要使用它的重载方法 hasNext(String pattern)来指定结束字符,或者使用break关键字.*/
        String str = "";
        while (SCANNER.hasNext()) {
            str = SCANNER.nextLine();
            if (str.length() > limit) {
                System.out.println("你输入的字符长度不合法,请重新输入,字符长度限制为: 1 -" + limit);
                continue;
            }
            break;
        }

        return str;
    }
}
