package com.huawei.nce.javabase.day06.array;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/19 9:22
 */
public class RandomNoRepeatArrayTest {
    /**
     * 创建一个长度为6的int型数组，要求数组元素的值都在1-30之间，且是随机赋值。同时，要求
     * 元素的值各不相同。
     * @param args args
     */
    public static void main(String[] args) {
        int[] randomArray = new int[6];
        for (int i = 0; i < randomArray.length; i++) {
           int randomNumber =  (int)(Math.random() * 30)+ 1;
           // 随机数赋值给数组中的元素
           randomArray[i] = randomNumber;

           // 该下标的元素跟数组中前面的元素比较, 如果重复,则则重新给该下标的数组元素赋值. 否则不处理
            for (int j = 0; j < i; j++) {
                if (randomArray[i] == randomArray[j]) {
                    i --;
                    break;
                }
            }
        }

        for (int number : randomArray) {
            System.out.println(number);
        }
    }
}
