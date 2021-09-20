package com.huawei.nce.javabase.day08.objectoriented;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/20 10:42
 */
public class OtherTest {
    /**
     * 定义一个int型的数组：int[] arr = new int[]{12,3,3,34,56,77,432};
     * 让数组的每个位置上的值去除以首位置的元素，得到的结果，作为该位置上的
     * 新值。遍历新的数组。
     * @param args
     */
    public static void main(String[] args) {
       // testOther1();
        testOther2();
    }

    private static void testOther2() {
        int[] arr = new int[] {1,2,3};
        System.out.println(arr);

        char[] arr2 = new char[] {'a', 'b', 'c'};
        System.out.println(arr2);
    }

    private static void testOther1() {
        int[] arr = new int[]{12,3,3,34,56,77,432};
//        int temp = arr[0];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i]/= temp;
//            System.out.println(arr[i]);
//        }

        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i]/=arr[0];
            System.out.println(arr[i]);
        }
    }


}
