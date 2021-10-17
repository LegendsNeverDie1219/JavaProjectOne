package com.huawei.nce.javabase.day23_24.collection;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/17 17:35
 */
public class ListTest {
    /**
     * 1.|----Collection接口:单列集合,用来存储一个一个的对象
     *     |----List接口 存储有序的,可以重复的数据 -->"动态数组"
     *         |---- ArrayList:作为List接口的主要实现类.线程不安全,效率高. 底层使用Object[] elementData存储
     *         |----LinkedList,对于频繁的插入,删除数据.使用linkedList效率高.底层使用双向链表存储.
     *         |----Vector 作为List接口的古老实现类. 线程安全,效率低.底层使用Object[] elementData存储
     */
    /**
     * 2.ArrayList的源码分析:
     * 2.1jdk1.7情况下:
     * List list = new ArrayList(); // 底层创建了一个长度为10的Object[] elementData
     *
     * list.add(123) // elementData = new Integer(123);
     * ...
     * list.add(456) // 如果此次添加导致数组的容量不够用.则会扩容
     * 默认情况下,会扩容为原来的1.5倍,并且将原有数组中的元素copy到新的数组中.
     *结论: 开发过程中.如果知道大概要添加多少个元素. 应该使用带参构造器
     * List list = new ArrayList(int capacity);
     *
     * 2.2jdk1.8情况下:
     * ArrayList list = new ArrayList(); // 底层声明了Object[] elementData 初始化值为{}
     *
     * list.add(123) // 第一次调用add() 的时候,底层才创建一个长度为10的数组.并且将123添加到数组中
     * (懒加载,延迟了数组的创建,节省了内存空间)
     *
     * 3.linkedList的源码分析:
     * List list = new LinkedList(); // 内部声明了Node类型的first和last属性.默认值为:null
     * 其中,Node的定义,体现了LinkedList双向链表的说法.
     *     private static class Node<E> {
     *         E item;
     *         Node<E> next;
     *         Node<E> prev;
     *
     *         Node(Node<E> prev, E element, Node<E> next) {
     *             this.item = element;
     *             this.next = next;
     *             this.prev = prev;
     *         }
     *     }
     * 4.Vector的源码分析:
     * List vector = new Vector(); // jdk1.7/1.8底层都创建了一个长度为10的数组
     * 在扩容方面默认扩容为原来的2倍.
     *
     */
    /**
     * void add(int index, Object ele):在index位置插入ele元素
     * boolean addAll(int index, Collection eles):从index位置开始将eles中
     * 的所有元素添加进来
     * Object get(int index):获取指定index位置的元素
     * int indexOf(Object obj):返回obj在集合中首次出现的位置
     * int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
     * Object remove(int index):移除指定index位置的元素，并返回此元素
     * Object set(int index, Object ele):设置指定index位置的元素为ele
     * List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex
     * 位置的子集合
     */
    public static void main(String[] args) {
        List arrayList = new ArrayList<>();
        List linkedList = new LinkedList<>();
        List vector = new Vector();
    }

    /**
     * 增 : add(Object obj)
     * 删: remove(Object obj) remove(int index)
     * 改: set(int index ,Object obj)
     * 查: get(int index)
     * 插: add(int index ,Object obj)
     */
    @Test
    public void test1() {
        List arrayList = new ArrayList<>();
        arrayList.add(123);
        arrayList.add(456);
        arrayList.add("aa");
        arrayList.add(new Person("tom", 12));
        arrayList.add(456);
        arrayList.add(2, 789);
        System.out.println(arrayList);
        arrayList.addAll(3, Arrays.asList("hds", "zl"));
        System.out.println(arrayList);
        System.out.println("arrayList.get(int index): " + arrayList.get(3));
        // 1 返回obj在集合中首次出现位置的索引, 没有则返回-1
        System.out.println("arrayList.indexOf(obj): " + arrayList.indexOf(4567));
        // -1
        System.out.println("arrayList.indexOf(obj): " + arrayList.indexOf(4567));
        // 7
        System.out.println("arrayList.lastIndexOf(obj): " + arrayList.lastIndexOf(456));
        System.out.println("arrayList.remove(obj): " + arrayList.remove("hds"));
        System.out.println("arrayList.set(int index, Object obj): " + arrayList.set(3, "zouling"));
        System.out.println(arrayList);
        // [zouling, aa] 返回从[fromIndex,toIndex)索引范围的子集合. 原始集合没有变化.
        System.out.println(arrayList.subList(3,5));
        // [123, 456, 789, zouling, aa, Person(name=tom, age=12), 456]
        System.out.println(arrayList);
    }

    @Test
    public void test2() {
        List arrayList = new ArrayList<>();
        arrayList.add(123);
        arrayList.add(456);
        arrayList.add("aa");
        arrayList.add(new Person("tom", 12));
        arrayList.add(456);
        System.out.println(arrayList);
        // [123, 456, aa, Person(name=tom, age=12), 456]
        arrayList.remove(new Integer(456));
        // [123, aa, Person(name=tom, age=12), 456]
        System.out.println(arrayList);
        // java.lang.IndexOutOfBoundsException: Index: 4, Size: 4
        arrayList.remove(4);
        System.out.println(arrayList);
    }

    @Test
    public void test3() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        // [1,2]
        System.out.println(list);
    }

    private void updateList(List list) {
        list.remove(2);
    }
}
