package com.huawei.nce.javabase.day22.annotation;

import org.junit.jupiter.api.*;

import java.util.Arrays;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/17 14:24
 */
public class JunitTest {
    private static Object[] array;
    private static int total;

    /**
     * 初始化数据
     * 调用之前, total: 0
     * add():[hello, null, null, null, null]
     * 调用之后: total:1
     * 调用之前, total: 1
     * add2():[hello, world, null, null, null]
     * 调用之后: total:2
     * 销毁数组
     */

    // 相当于Junit4中的@BeforeClass 标记在静态方法上,在类加载的时候执行,只执行一次
    @BeforeAll
    public static void init() {
        System.out.println("初始化数据");
        array = new Object[5];
    }

    // 相当于JUnit4中的@Before 标记在实例方法上,在每个@Test方法之前都执行
    @BeforeEach
    public void before() {
        System.out.println("调用之前, total: " + total);
    }

    @Test
    public void add() {
        array[total++] = "hello";
        System.out.println("add():" + Arrays.toString(array));
    }

    @Test
    public void add2() {
        array[total++] = "world";
        System.out.println("add2():" + Arrays.toString(array));
    }

    // 相当于Junit4中的@After 标记在实例方法上,在每个@Test方法之后都执行
    @AfterEach
    public void after() {
        System.out.println("调用之后: total:" + total);
    }

    // 相当于Junit4中的@AfterClass 标记在静态方法上,在所有方法之后完成之后执行,只执行一次
    @AfterAll
    public static void destroy() {
        array = null;
        System.out.println("销毁数组");
    }
}
