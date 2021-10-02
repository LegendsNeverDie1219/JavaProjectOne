package com.huawei.nce.javabase.day14.block;


/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/1 15:30
 */
public class Son extends Father {
    static {
        System.out.println("4444444444444444");
    }

    {
        System.out.println("555555555555555555555");
    }
    public Son () {
        System.out.println("666666666666666");
    }
    //1111111111
    //4444444444444444
    //7777777777777777777
    //******************************************************************
    //222222222222222
    //33333333333333333
    //555555555555555555555
    //666666666666666
    //******************************************************************
    //222222222222222
    //33333333333333333
    //555555555555555555555
    //666666666666666
    //******************************************************************
    //222222222222222
    //33333333333333333
    public static void main(String[] args) {
        System.out.println("7777777777777777777");
        System.out.println("**************************");
        new Son();
        System.out.println("********************");

        new Son();
        System.out.println("*******************");

        new Father();
    }
}

class Father{
    static {
        System.out.println("1111111111");
    }

    {
        System.out.println("222222222222222");
    }

    public Father() {
        System.out.println("33333333333333333");
    }
}