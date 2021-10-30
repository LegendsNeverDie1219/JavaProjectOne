package com.huawei.nce.javabase.day25_26.fanxing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/28 22:25
 */
public class GenericTestTwo {
    /**
     * 如何自定义泛型: 泛型类/泛型接口, 泛型方法
     */
    @Test
    public void test1() {
        Order order = new Order();
        order.setOrderId(123);
        order.setOrderName("orderName");
        order.setOrderT(new Object());

        // Order<String, Integer , Object> order2 = new Order<>();
        Order<String> order2 = new Order<>();
        order2.setOrderId(123);
        order2.setOrderName("orderName");
        order2.setOrderT("orderT");

        SubOrder subOrder = new SubOrder();
        subOrder.setOrderT(123);

        SubOrder2<Long> subOrder2 = new SubOrder2<>();
        subOrder2.setOrderT(123456L);
    }

    @Test
    public void test2() {
        List<String> list1 = null;
        List<Integer> list2 = new ArrayList<>();
        // 泛型不同的引用不能相互赋值.
       // list2 = list1;
    }

    @Test
    public void test3() {
        Order<String> order = new Order<>();
        order.setArr(new String[] {"aa", "bb"});

        List<String> strings = order.copyFromArrayToList(order.getArr());
        System.out.println(strings);
    }

}
