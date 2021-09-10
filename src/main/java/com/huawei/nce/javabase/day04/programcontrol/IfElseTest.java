package com.huawei.nce.javabase.day04.programcontrol;

import java.util.Scanner;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/6 20:21
 */
public class IfElseTest {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {
        // testIfElseOne();

        // testIfElseTwo();

        // testIfExpr();

        //testIfElseThree();

        testIfElseFour();
    }

    /**
     * 彩票游戏
     * 假设你想开发一个玩彩票的游戏，程序随机地产生一个两位数的彩票，提示用户输入一个两位数，然后按照下面的规则判定用户是否能赢。
     *
     * 1)如果用户输入的数匹配彩票的实际顺序，奖金10 000美元。
     * 2)如果用户输入的所有数字匹配彩票的所有数字，但顺序不一致，奖金 3 000美元。
     * 3)如果用户输入的一个数字仅满足顺序情况下匹配彩票的一个数字，奖金1 000美元。
     * 4)如果用户输入的一个数字仅满足非顺序情况下匹配彩票的一个数字，奖金500美元。
     * 5)如果用户输入的数字没有匹配任何一个数字，则彩票作废
     */
    private static void testIfElseFour() {
        // 1.产生一个两位的随机数: [10,100)
        // Math.random 产生一个[0, 1)的随机数, (99 -10 +1)= 90  Math.random() * 90 + 10
        int randomNumber = (int) (Math.random() * 90) + 10;
        int tens  = randomNumber / 10;
        int digits = randomNumber % 10;
        // 2.接收用户猜测的十位数,个位数,并存入局部变量
        System.out.println("请输入猜测的十位数: ");
        String strOne = SCANNER.nextLine();
        if (!verifySuccess(strOne, true)) {
            System.out.println( "输入的十位数字校验失败");
            return;
        }

        System.out.println("请输入猜测的个位数: ");
        String strTwo = SCANNER.nextLine();
        if (!verifySuccess(strTwo, false)) {
            System.out.println( "个位数字校验失败");
            return;
        }

        int guessTens = Integer.parseInt(strOne);
        int guessDigits = Integer.parseInt(strTwo);
        int guessNumber = guessTens * 10 + guessDigits;
        // 3.执行判断,输出结果
        if (randomNumber == guessNumber) {
            System.out.println("一等奖, 奖金 10000美元");
        } else if (tens == guessDigits && digits == guessTens) {
            System.out.println("二等奖, 奖金 3000美元");
        } else if (tens == guessTens || digits == guessDigits) {
            System.out.println("三等奖, 奖金 1000美元");
        } else if (tens == guessDigits || digits == guessTens) {
            System.out.println("四等奖, 奖金 500美元");
        } else {
            System.out.println("感谢你为公益事业做出的贡献");
        }
        System.out.println("中奖号码是：" + randomNumber);
    }

    private static boolean verifySuccess(String str, boolean isTens) {
        if (str.length() != 1) {
            System.out.println("你输入的十位数字长度不正确, 长度为1");
            return false;
        }
        if (!isNum(str)) {
            System.out.println("你输入的十位数字字符不正确,非数字");
            return false;
        }
        if (isTens && Integer.parseInt(str) == 0) {
            System.out.println("你输入的十位数字范围不正确,正确范围: 1-9");
            return false;
        }
        return true;
    }

    private static boolean isNum(String str) {
        for (int i = 0; i < str.length(); i ++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 求ax2+bx+c=0方程的根。
     * （1）当b2-4ac>0，则有两个解；
     * （2）当b2-4ac=0，则有一个解；
     * （3）当b2-4ac<0，则无解；
     * 如果a=0,b≠0，那么，
     */
    private static void testIfElseThree() {
        System.out.println("一元二次方程: aX^2 + bX + c = 0");
        System.out.println("请输入a:");
        double paramA = SCANNER.nextDouble();
        System.out.println("请输入b:");
        double paramB = SCANNER.nextDouble();
        System.out.println("请输入c:");
        double paramC = SCANNER.nextDouble();
        // 是一元二次方程
        if (paramA != 0) {
            double variable = paramB * paramB - 4 * paramA * paramC;
            if (variable > 0) {
                double equationOne = (-paramB + Math.sqrt(variable))/(2 * paramA);
                double equationTwo = (-paramB - Math.sqrt(variable))/(2 * paramA);
                System.out.println("该一元二次方程有2个解: " + equationOne + ", " + equationTwo);
            } else if(variable == 0) {
                double equation = -paramB/(2 * paramA);
                System.out.println("该一元二次方程有一个解: " + equation);
            } else {
                System.out.println("该一元二次方程在实数范围内无解: ");
            }
        } else {
            // 是一元一次方程
            if (paramB != 0) {
                if (paramC == 0) {
                    System.out.println("该等式是一个一元一次方程,解为: "  + 0.0);
                } else {
                    System.out.println("该等式是一个一元一次方程,解为: "  + -paramC/paramB);
                }
            } else {
                // 常量式 不成立
                if (paramC != 0) {
                    System.out.println("该等式是一个常量式,且不成立");
                } else {
                    // 常量式 0 == 0
                    System.out.println("该等式是一个常量式, 0 == 0");
                }
            }
        }

    }

    private static void testIfExpr() {
        int x = 4;
        int y = 3;
        // 7
        // 4
        if (x > 2)
            if (y > 2)
                System.out.println( x + y);

            else
                System.out.println(x - y);
          System.out.println(x);

    }

    /**
     * 输入期末分数.输出月小鹏的奖励
     * [0,60) 无
     * [60,80) ipad
     * [80,90) iphone
     * [90, 100] BM
     */
    private static void testIfElseTwo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入月小鹏的成绩:范围是:0-100 ");
        int score = scanner.nextInt();
        if (score < 0 || score > 100) {
            System.out.println("你输入的成绩无效");
        } else if (score >= 90){
            System.out.println("BM");
        } else if (score >= 80) {
            System.out.println("iphone");
        } else if (score >= 60) {
            System.out.println("ipad");
        } else {
            System.out.println("nothing");
        }
    }

    /**
     * 输入三个随机数字,输出排序的结果.
     */
    private static void testIfElseOne() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入第一个整数");
        int firstNum = scanner.nextInt();
        System.out.println("第一个整数为:" + firstNum);

        System.out.println("输入第2个整数");
        int nextNum = scanner.nextInt();
        System.out.println("第二个整数为: " + nextNum);

        System.out.println("输入第3个整数");
        int lastNum = scanner.nextInt();
        System.out.println("第三个整数为: " + lastNum);

        System.out.println("寻找最大的数字: ....");

        int temporaryMax = firstNum > nextNum ? firstNum : nextNum;

        int finalMax = temporaryMax > lastNum ? temporaryMax : lastNum;

        System.out.println("最大数是: " + finalMax);
        System.out.println("排序的结果: ....");
        if (firstNum > nextNum) {
            //  ? nextNum ? firstNum ?
            if (lastNum >= firstNum) {
                System.out.println( nextNum + ", " + firstNum + ", " + lastNum);
            } else if (lastNum <= nextNum) {
                System.out.println(lastNum + ", " + nextNum + "," + firstNum);
            } else {
                System.out.println(nextNum + "," + lastNum + ", " + firstNum);
            }
        } else {
            if (lastNum >= nextNum) {
                System.out.println(firstNum + ", " + nextNum + ", " + lastNum);
            } else if (lastNum <= firstNum) {
                System.out.println(lastNum + ", " + firstNum + ", " + nextNum);
            } else {
                System.out.println(firstNum + ", " + nextNum + ", " + nextNum);
            }
        }

    }
}
