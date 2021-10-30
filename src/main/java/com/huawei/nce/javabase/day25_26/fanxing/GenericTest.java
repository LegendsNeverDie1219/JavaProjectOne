package com.huawei.nce.javabase.day25_26.fanxing;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/27 21:59
 */
public class GenericTest<V> {
    /**
     * 集合中使用泛型之前
     */
    @Test
    public void test1() {
        List list = new ArrayList();
        list.add(78);
        list.add(79);
        list.add(80);
        list.add(81);
        // 问题一:什么类型的元素都可以装, 类型不安全
        list.add("tom");
        for (Object score : list) {
            // 问题二: 向下强转的时候,有可能会报异类型转化的异常.
            int stuScore = (int) score;

            System.out.println(stuScore);
        }
    }

    /**
     * 集合中使用泛型之后
     */
    @Test
    public void test2() {
        List<Integer> list = new ArrayList<>();
        list.add(78);
        list.add(79);
        list.add(80);
        list.add(81);
        // 编译报错
        // 1.不会产生类型安全问题
        // list.add("tom");
        for (Integer score : list) {
            // 2.不涉及类型强转
            System.out.println(score);
        }

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer score = iterator.next();
            System.out.println(score);
        }
    }

    /**
     * 泛型的使用:
     * 1.jdk5.0引入的新特性
     * 2. 在集合中使用泛型
     * ①集合接口和集合类都已经修改成了带泛型的结构 如ArrayList<E>
     * ②在实例化集合类的实例时,可以指明具体的泛型类型
     * ③泛型的类型只能是类,不能是基本数据类型
     * ④如果实例化的时候,没有指明泛型的类型,默认类型为java.lang.Object
     */
    @Test
    public void test3() {
        Map<String,Integer> map = new HashMap<>();
        map.put("tom", 17);
        map.put("jane", 18);
        map.put("jack", 19);
        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        Set<String> stringSet = map.keySet();
        Collection<Integer> integers = map.values();
        Iterator<Map.Entry<String,Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
