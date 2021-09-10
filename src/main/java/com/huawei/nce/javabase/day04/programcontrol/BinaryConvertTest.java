package com.huawei.nce.javabase.day04.programcontrol;


import org.junit.jupiter.api.Test;

/**
 * 进制转换测试
 *
 * @author Administrator
 * @date 2021/9/5 22:31
 */
public class BinaryConvertTest {
    /**
     * 将0-255之内的一个整数转换为对应的二进制, 八进制,十六进制
     * 例如 60 的十六进制是3C
     * 调用API
     */
    @Test
    public void testBinaryConvert() {
        // 111100
        String binaryString = Integer.toBinaryString(60);
        System.out.println(binaryString);
        // 74
        String octalString = Integer.toOctalString(60);
        System.out.println(octalString);
        // 3c
        String hexString = Integer.toHexString(60);
        System.out.println(hexString);
    }

    /**
     * 手动实现
     */
    @Test
    public void testBinaryConvert2() {
        // 0011 1100
        int number = 60;
        // 1.取出60对应的二进制的后四位
        int lastFour = number & 15;
        // s1  = 67
        int s1 = lastFour-10 + 'A';
        // s2 = 'C'
        char s2 = (char) (lastFour-10 + 'A');
        // 2.拿到之后进行转换
        String convertNumOne = lastFour > 9 ? (char)(lastFour-10 + 'A') + "" : lastFour + "";
        // 3.无符号右移4位,再获取60二进制的倒数4-8位
        int lastFour2 = number >>> 4;
        String convertNumberTwo = lastFour2 > 9 ? (char) (lastFour2-10 +'A') + "": lastFour2 + "";
        System.out.println(convertNumberTwo + convertNumOne);
    }
}
