package com.huawei.nce.javabase.testyunsuanfu;

import org.junit.jupiter.api.Test;

/**
 * TODO
 *
 * @author Administrator
 * @date 2020/12/26 16:09
 */
public class TestYunSuanFu {
    @Test
    public void $_testDuanLuYu() {
        int a = 0;
        int b = 3;
        boolean b1 = (a >= 0) && (b > 0);
        //System.out.println(1&&2);
    }
    @Test
    public void testProcessControl(){
        // 流程控制的三大结构:顺序结构,条件结构,循环机构
        System.out.println("test process control : if");
        System.out.println("根据条件的不同来走不同的分支代码");
        int n = 2;
        //条件结构之if
        if (n > 0) {
            System.out.println("judge condition is: n>0");
        } else if (n > 1) {
            System.out.println("judge condition is: n>1");
        } else {
            System.out.println("None of the above conditions hold true");
        }
        System.out.println("==============================");
        System.out.println("test process control : switch");
        System.out.println("根据变量值的不同来走不同分支的代码.");
        int  week = 8;
        switch (week) {
            case 1:
                System.out.println("今天是星期一");
                break;
            case 2:
                System.out.println("今天是星期二");
                break;
            case 3:
                System.out.println("今天是星期三");
                break;
            case 4:
                System.out.println("今天是星期四");
                break;
            case 5:
                System.out.println("今天是星期五");
                break;
            case 6:
                System.out.println("今天是星期六");
                break;
            case 7:
                System.out.println("今天是星期日");
                break;
            default:
                System.out.println("以上条件都不满足");
        }
    }

private TestYunSuanFu(){}
}
