package com.huawei.nce.javabase.day08.objectoriented.encapsulation_inheritance;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/26 22:14
 */
public class ddd {
    private static final String ma = "dddd";
    public static void main(String[] args) {
        System.out.println(ma);

        Integer[] cache = new Integer[]{11,22};
        Integer cache2[] = new Integer[]{33,44};
        // 11
        System.out.println(cache[0]);
        // 33
        System.out.println(cache2[0]);

        Integer a = 11;
        Integer b = 11;
        System.out.println(a);
    }
}
