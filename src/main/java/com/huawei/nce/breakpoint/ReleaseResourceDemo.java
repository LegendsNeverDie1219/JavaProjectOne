package com.huawei.nce.breakpoint;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/5/26 0:28
 */
public class ReleaseResourceDemo {
    public static void main(String[] args) {
        System.out.println("shit happens");
        System.out.println("已经找到了BUG");
        // 找到frames中的执行到的那一个栈针,然后右键force return ,这样后面的资源就不会操作了.
        System.out.println("DB操作");
        System.out.println("MQ 操作");
        System.out.println("Redis 操作");
    }
}
