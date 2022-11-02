package com.huawei.nce.javabase.day23_24.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/17 17:01
 */
public class IteratorTest {
    private static Collection coll;

    static {
        coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("tom"));
        coll.add(new Person("jerry", 20));
        coll.add(false);
    }

    @Test
    public void test1() {
        Iterator iterator = coll.iterator();
        // 方式一:
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        // java.util.NoSuchElementException
//        System.out.println(iterator.next());

        // 方式二
//        for (int i = 0; i < coll.size(); i++) {
//            System.out.println(iterator.next());
//        }

        // 方式三
        // hasNext() : 判断集合中是否还有下一个元素
        // next() : 指针下移, 并且将下移后指针指向的集合元素返回.(指针初始位置指向集合中第一个元素的上面)
        while (iterator.hasNext()) {
            //在调用iterator.next() 方法的时候,必须要先调用iterator.hasNext()方法
            // 如果不调用,并且下一条记录为null时, 会报NoSuchElementException的运行时异常.
            System.out.println(iterator.next());
        }
        // 死循环: 会一直打印集合中的第一个元素.
        // 因为每一个循环都会得到一个全新的迭代器对象, 指针始终指向集合中第一个元素的上面
        while (coll.iterator().hasNext()) {
            System.out.println(coll.iterator().next());
        }
    }

    @Test
    public void test2() {
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            if (next.equals("tom")) {
                // 如果还未调用next()方法.或者连续执行了两次remove() 都会报illegalStatusException
                iterator.remove();
//                iterator.remove();
            }
        }

        Iterator iterator1 = coll.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        System.out.println(list);

        // for (Integer i : list) {
        //     if (i == 3) {
        //         list.remove(i);
        //     }
        // }

        Iterator it=list.iterator();
        while(it.hasNext()){
            if(it.next().equals(3)){
                it.remove();
            }
        }
        System.out.println(list);
    }

}

