package com.huawei.nce.javabase.day25_26.fanxing;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/27 23:14
 */
public class CollectorsToMapTest {
    private List<NeElement> neElements;

    @BeforeEach
    public void initData() {
        neElements = Lists.newArrayList(new NeElement(7758258L, "Aaa"), new NeElement(7758259L,
                "Bbb"));
    }
    @Test
    public void test1() {
        Map<Long, String> map = neElements.stream().collect(Collectors.toMap(NeElement::getNeId,
                NeElement::getNeName));
        // {7758258=Aaa, 7758259=Bbb}
        System.out.println(map);
    }

    @Test
    public void test2() {
        neElements = Lists.newArrayList(new NeElement(7758258L, "Aaa"), new NeElement(7758259L,
                null));
        //  <R, A> R collect(Collector<? super T, A, R> collector);
        // java.lang.NullPointerException at java.util.HashMap.merge(HashMap.java:1225)
//        Map<Long, String> mapOne = neElements.stream().collect(Collectors.toMap(neElement -> neElement.getNeId(),
//                NeElement::getNeName));
//        System.out.println(mapOne);

        // value 不能为null
         // 方式一:
        Map<Long, String> mapTwo = new HashMap<>();
        for (NeElement neElement : neElements) {
            mapTwo.put(neElement.getNeId(),neElement.getNeName());
        }
        // {7758258=Aaa, 7758259=null}
        System.out.println(mapTwo);
        System.out.println("=====================");
        // 方式二
        // {7758258=Aaa, 7758259=null}
        Map<Long, String> mapThree = neElements.stream().collect(HashMap::new,
                (hashMap, neElement) -> hashMap.put(neElement.getNeId(),
                        neElement.getNeName()), HashMap::putAll);
        System.out.println(mapThree);
    }

    @Test
    public void test3() {
        neElements = Lists.newArrayList(new NeElement(7758258L, "Aaa"), new NeElement(7758259L,
                "Bbb"),new NeElement(7758258L, "Ccc"));
        // java.lang.IllegalStateException: Duplicate key NeElement(neId=7758258, neName=Aaa)
//        Map<Long, NeElement> map = neElements.stream().collect(Collectors.toMap(neElement -> neElement.getNeId(),
//                neElement -> neElement));

        //7758258-> NeElement(neId=7758258, neName=Aaa)
        //7758259-> NeElement(neId=7758259, neName=Bbb)
//        Map<Long, NeElement> map = neElements.stream().collect(Collectors.toMap(neElement -> neElement.getNeId(),
//                neElement -> neElement, (oldValue, newValue) -> oldValue));

        // 7758258-> NeElement(neId=7758258, neName=Ccc)
        //7758259-> NeElement(neId=7758259, neName=Bbb)
        Map<Long, NeElement> map = neElements.stream().collect(Collectors.toMap(neElement -> neElement.getNeId(),
                neElement -> neElement, (oldValue, newValue) -> newValue));
        map.forEach((neId,neElement) -> {
            System.out.println(neId + "-> " + neElement);
        });
    }


    @Test
    public void test4() {
        TreeMap<Long, NeElement> collect = neElements.stream().collect(Collectors.toMap(NeElement::getNeId,
                Function.identity(),
                (oldValue, newValue) -> oldValue, TreeMap::new));
        // treeMap根据key来排序的. key为Long 类型,已经实现了 equals() hachcode() .compareTo() 方法
       // {7758258=NeElement(neId=7758258, neName=Aaa), 7758259=NeElement(neId=7758259, neName=Bbb)}
        System.out.println(collect);

        // Construction of sorted collection with non-comparable elements
        // 构建具有不可比较元素的排序集合
        // NeElement cannot be cast to java
        // .lang.Comparable
        TreeMap<NeElement, Long> treeMap = new TreeMap<>();
        treeMap.put(new NeElement(33L, "ccc"), 222L);
        treeMap.put(new NeElement(44L, "ccc"), 333L);
        treeMap.put(new NeElement(22L, "aaa"), 111L);
        // {NeElement(neId=22, neName=aaa)=111, NeElement(neId=33, neName=ccc)=222, NeElement(neId=44, neName=ccc)=333}
        System.out.println(treeMap);
    }
}
