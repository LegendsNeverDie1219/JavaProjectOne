package com.huawei.nce.javabase.day23_24.collection;


import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/17 16:07
 */
public class CollectionTest {
    /**
     * |----Collection接口:单列集合,用来存储一个一个的对象
     *     |----List接口 存储有序的,可以重复的数据 -->"动态数组"
     *         |---- ArrayList, LinkedList,Vector
     *     |----Set接口,存储无序的,不可重复的数据 --> 高中数学的"集合"
     *         |---- HashSet, LinkedHashSet,TreeSet
     * |----Map接口: 双列集合,用来存储一对数据(key-value) 高中数学的y=f(x)
     *     |----HashMap LinkedHashMap
     *     |----HashTable, Properties
     *     |---- TreeMap
     */
    @Test
    public void test1() {
        Collection collection = new ArrayList();
        // 1.add(Object e) 添加
        collection.add("AA");
        collection.add("BB");
        collection.add(new Date());
        collection.add(123);
        collection.add(456);
        // 2.size() 获取集合中实际元素个数
        System.out.println(collection.size());
        //3.addAll(Collection coll1)将coll1中的元素添加到collection中
        List<Object> coll1 = Arrays.asList(new Object[]{"CC", 789});
        collection.addAll(coll1);
        System.out.println(collection.size());
        // java.util.AbstractCollection.toString
        System.out.println(collection.toString());
        // 4.clear() 清空集合中的元素
        collection.clear();
        // 5.isEmpty(): 判断当前集合是否为空(是否没有元素)
        System.out.println(collection.isEmpty());
    }

    /**
     * 向Collection接口的实现类中添加自定义的Object类型的数据时,要求obj所在类的重写equals()方法.
     */
    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("tom"));
        coll.add(new String("jane"));
        coll.add(new Person("jerry", 20));
        // true
        System.out.println("coll.contains(123): " + coll.contains(123));
        // 6.contains(Object obj) 判断当前集合中是否包含obj在判断时,会调用ob对象所在类的equals()方法.
        // true java.util.ArrayList.indexOf()
        System.out.println("coll.contains(new String(\"tom\")): " +
                coll.contains(new String("tom")));
        // false
        System.out.println(" coll.contains(new Person(\"jerry\", 20)): " +
                coll.contains(new Person("jerry", 20)));
        // 7.containsAll(Collectinon coll)
        List<String> strings = Arrays.asList("tom", "jane","hds");
        System.out.println("coll.containsAll(strings): " + coll.containsAll(strings));
        // 8.remove(Object obj)
        coll.remove(123);
        System.out.println(coll);
        // 9.removeAll(Collection coll) 差集
        coll.removeAll(strings);
        System.out.println(coll);
    }
    @Test
    public void test3() {
        Collection currentList = new ArrayList();
        currentList.add(123);
        currentList.add(456);
        // currentList.add(new String("jane"));
        // currentList.add(new Person("jerry", 20));
        System.out.println("currentList1:" + currentList);
        // 10.retainAll(Collection coll) 取当前集合和coll的交集.并返回给当前集合. 如果当前集合存在移除元素的动作,则返回true,否则false
        List<Integer> coll = Arrays.asList(123, 456,789);
        boolean b = currentList.retainAll(coll);
        System.out.println(currentList); //[123, 456]
        System.out.println("currentList2:" + currentList);
        System.out.println(b); // true
        System.out.println(coll); // [123, 456, 789]
    }

    @Test
    public void test4() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("jane"));
        coll.add(new Person("jerry", 20));

        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add(123);

        coll1.add(new String("jane"));
        coll1.add(new Person("jerry", 20));
        // 11.equals(Object obj) 要想返回true.需要当前集合中的元素 和形参集合中的元素 顺序和个数都相同.
        // java.util.AbstractList.equals  false
        System.out.println(coll.equals(coll1));
        // 12.hashCode()
        // java.util.AbstractList.hashCode  1683510375
        System.out.println(coll.hashCode());
        // 13.toArray() 集合转换为数组
        Object[] objects = coll.toArray();
        for (Object object : objects) {
            System.out.println(object);
        }
    }
}
