package com.huawei.nce.javabase.day23_24.collection;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/17 20:31
 */
public class SetTest {
    /**
     * 1.set接口框架
     * |----Collection接口:单列集合,用来存储一个一个的对象
     * |----Set接口,存储无序的,不可重复的数据 --> 高中数学的"集合"
     * |---- HashSet,作为Set接口的主要实现类,线程不安全.效率高, 可以存储null值
     * |----LinkedHashSet 作为HashSet的子类.遍历其内部数据时.可以按照添加顺序进行遍历
     * |---- TreeSet 可以按照对象指定的属性,进行排序.
     * 2.set接口中没有定义额外的方法.都是collection中声明的方法
     * <p>
     * 3.无序性, 不可重复性
     * 3.1无序性: 不等于随机性,即存储数据时不是按照数组的索引的一个挨着一个存储的.
     * 而且先计算元素对应的哈希值, 根据哈希值在计算出应该放到数组的哪一个索引位置
     * 如果数组这个索引位置没有元素.直接存储
     * 如果数组的这个索引位置有元素,(1-n个) 则需要先跟这个已存在的元素进行哈希值的比较
     * 如果都不相同.则形成链表结构(jdk1.7 新加的元素会放到数组中, 新元素-> 老元素,
     * jdk1.8 老元素会放到数组中. 老元素 -> 新元素)
     * 如果跟其中一个元素的hashcode相同,则需要再进行equals的比较
     * 如果equals() 比较后,返回true,则不会添加成功
     * 如果equals()比较后.返回false.则添加成功.
     * 3.2不可重复性: 保证添加元素时,会按照equals()进行判断,如果返回true,则不会添加进去.
     * <p>
     * 4.添加元素的过程 以hashset为例.
     * 我们向hashset中添加元素a.
     * 首先调用元素a所在类的hashcode()方法,计算元素a对应的哈希值,
     * 然后基于哈希值通过某种算法计算出应该放到hashset底层数组的哪一个索引位置
     * 接着.判断这个索引位置是否有元素:
     * 如果数组这个索引位置没有元素.直接存储                         ---->情况1
     * 如果数组的这个索引位置有元素,(1-n个) 则需要先跟这个已存在的元素进行哈希值的比较
     * 如果都不相同.则形成链表结构                              ---->情况2
     * (jdk1.7 新加元素a会放到数组中, 新元素-> 老元素, jdk1.8 老元素会放到数组中. 老元素 -> 新元素)
     * 如果跟其中一个元素的hashcode相同,则需要再进行equals的比较
     * 如果equals()比较后.返回false.则添加成功.              ---->情况3
     * 如果equals() 比较后,返回true,则不会添加成功           ---->情况4
     * <p>
     * 5.存在Set容器中的自定义对象, 一定要重写equals() 和hashCode()方法.
     * 其中对象中用作equals() 比较的属性, 都要参与到计算hash值上.
     * <p>
     * 6.linkedHashset 在Hashset的基础上,每个元素上又维护一个prev.next的指针
     * 以便于元素遍历的顺序和添加的顺序相同,对于频繁的遍历, 可以提高遍历速度.
     * <p>
     * 7.TreeSet采用红黑树的结构进行存储,特点是有序
     */
    @Test
    public void test1() {
        Set hashSet = new HashSet();
        hashSet.add(new String("AA"));
        hashSet.add(new String("BB"));
        hashSet.add(new String("AA"));
        hashSet.add(456);
        hashSet.add(789);
        hashSet.add(new Person("tom", 20));
        hashSet.add(new Person("tom", 20));
        // [AA, BB, 789, Person(name=tom, age=20), 456]
        System.out.println(hashSet);
    }

    @Test
    public void test2() {
        Set linkedHashset = new LinkedHashSet();
        linkedHashset.add(new String("aa"));
        linkedHashset.add(456);
        linkedHashset.add(456);
        linkedHashset.add(new Person("刘德华", 65));
        // [aa, 456, Person(name=刘德华, age=65)]
        System.out.println(linkedHashset);
    }

    /**
     * 1.向TreeSet中添加的对象,要求必须是同类型的对象,否则无法进行排序,
     * 2.如果添加的是自定义对象, 则需要自定义对象所在的类实现comparable接口/comparator接口.
     * 3.两种排序: 自然排序,定制排序
     * 4.treeSet中比较两个对象是否相等的标准为: comparTo()/compare() 返回结果是否为0.不再是equals()
     */
    @Test
    public void test3() {
        Set treeSet = new TreeSet();
        // treeSet.add(123);
        // java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        // treeSet.add("456");
        // java.lang.ClassCastException: Person cannot be cast to java.lang.Comparable
        treeSet.add(new Person("tom", 12));
        treeSet.add(new Person("jerry", 32));
        treeSet.add(new Person("jim", 2));
        treeSet.add(new Person("jack", 33));
        treeSet.add(new Person("jack", 56));
        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test4() {
        //   public TreeSet(Comparator<? super E> comparator) {}
        Set treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (!(o1 instanceof Person || o2 instanceof Person)) {
                    throw new RuntimeException("输入的数据类型不是person类型");
                }
                Person personOne = (Person) o1;
                Person personTwo = (Person) o2;
                int result = Integer.compare(personOne.getAge(), personTwo.getAge());
                if (result != 0) {
                    return result;
                }
                return Integer.compare(personOne.getName().compareTo(personTwo.getName()), 0);
            }
        });
        treeSet.add(new Person("tom", 56));
        treeSet.add(new Person("jerry", 32));
        treeSet.add(new Person("jim", 32));
        treeSet.add(new Person("jack", 33));
        treeSet.add(new Person("jack", 56));


        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * 在list内去重.
     */
    @Test
    public void test5() {
        List<Integer> integers = Lists.newArrayList(1, 2, 2, 4, 4);
        Set<Integer> hashSet = new HashSet<>(integers);
        List<Integer> duplicateList = new ArrayList<>(hashSet);
        duplicateList.forEach(System.out::println);
    }
    
    @Test
    public void test6() {
        HashSet hashSet = new HashSet();
        Person  p1 = new Person("AA", 25);
        Person  p2 = new Person("BB", 24);
        hashSet.add(p1);
        hashSet.add(p2);
        // [Person(name=BB, age=24), Person(name=AA, age=25)]
        System.out.println(hashSet);

        p1.setName("CC");
        // 在删除某一元素的时候,也是先调用的hashcode(), 再调用equals方法
        // 此时由于属性值已经改变,则计算出来的hash值基于某种算法 算出来的hashmap的底层数组的索引很有可能不是存在原来数据的位置
        // 则此时找到的该索引为的元素 null, 删除失败.
        hashSet.remove(p1);
        // [Person(name=BB, age=24), Person(name=CC, age=25)]
        System.out.println(hashSet);
        hashSet.add(new Person("CC", 25));
        // [Person(name=BB, age=24), Person(name=CC, age=25), Person(name=CC, age=25)]
        System.out.println(hashSet);
        hashSet.add(new Person("AA", 25));
        // [Person(name=BB, age=24), Person(name=CC, age=25), Person(name=AA, age=25), Person(name=CC, age=25)]
        System.out.println(hashSet);
    }
}
