package com.huawei.nce.javabase.day14.statictest;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/1 12:09
 */
public class MainTest {
    /**
     * main方法:
     * 1.程序的入口
     * 2.也是一个普通的静态方法
     * 3.可以实现用户与控制台的交互.
     * @param args
     */
    public static void main(String[] args) {
        Main.main(new String[100]);
    }
}

class Main {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
//            args[i] = "args_" + i;
            System.out.println(args[i]);
        }
    }
}
