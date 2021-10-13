package com.huawei.nce.javabase.day20;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/12 21:12
 */
public class BigDecimalTest {
    /**
     * 一般的Float类和Double类可以用来做科学计算或工程计算，但在商业计算中，
     * 要求数字精度比较高，故用到java.math.BigDecimal类。
     *  BigDecimal类支持不可变的、任意精度的有符号十进制定点数。
     *  构造器
     *  public BigDecimal(double val)
     *  public BigDecimal(String val)
     *  常用方法
     *  public BigDecimal add(BigDecimal augend)
     *  public BigDecimal subtract(BigDecimal subtrahend)
     *  public BigDecimal multiply(BigDecimal multiplicand)
     *  public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode
     */
    @Test
    public void testBigInteger() {
        BigInteger bi = new BigInteger("12433241123");
        BigDecimal bigDecimalOne = new BigDecimal("12435.351");
        BigDecimal bigDecimalTwo = new BigDecimal("11");
        System.out.println(bi);
        // System.out.println(bd.divide(bd2));
        System.out.println(bigDecimalOne.add(bigDecimalTwo));
        System.out.println(bigDecimalOne.subtract(bigDecimalTwo));
        System.out.println(bigDecimalOne.multiply(bigDecimalTwo));
        System.out.println(bigDecimalOne.divide(bigDecimalTwo, BigDecimal.ROUND_HALF_UP));
        System.out.println(bigDecimalOne.divide(bigDecimalTwo, 15, BigDecimal.ROUND_HALF_UP));
    }
}
