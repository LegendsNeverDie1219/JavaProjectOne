package com.huawei.nce.javabase.day25_26.fanxing;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/29 8:34
 */
public class TongPeiFuTest {
    /**
     * 泛型在继承方面的应用:
     * 虽然 A是B的父类, 但是G<A>,  G<B>却是并列关系. 不能相互赋值
     * 如果A是 B的父类. 则A<G>   是B<G>的父类.
     */
    @Test
    public void test1() {
        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        // 编译报错
        // 反证法: 如果可以成功,则 list2中会混入非String类型的数据.
        //  list1 = list2;


        List<String> list3 = new ArrayList<>();
        AbstractList<String> list4 = new ArrayList<>();
        ArrayList<String> list5 = new ArrayList<>();
        list3 = list4;
        list3 = list5;
    }

    /**
     * 为了解决泛型在继承中的局限性(虽然 A是B的父类, 但是G<A>,  G<B>却是并列关系. 不能相互赋值),
     * G<?> 是G<A>和G<B>的父类.
     * 引入了通配符. ?
     */
    @Test
    public void test2() {
        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        // list1 = list2;
        List<?> list = null;
        list = list1;
        list = list2;
        // print(list1);
        // print(list2);

        List<String> list3 = Lists.newArrayList("AA", "BB");
        list = list3;
        // 添加(写入) : 对于List<?> list 除了添加null之外, 不能向该集合中添加任何类型的元素.
       // list.add("DD");
       // list.add(1);
        list.add(null);
        // 获取(读取) 对于List<?> list 允许读入数据.读取的数据类型为Object
        System.out.println(list.get(0));
        for (Object o1 : list) {
            System.out.println(o1);
        }
    }

    // private void print(List<?> list) {
    //     while (iterator.hasNext()) {
    //         Iterator<?> iterator = list.iterator();
    //         Object next = iterator.next();
    //         System.out.println(next);
    //     }
    // }

    /**
     * 通配符的上限:
     *  举例: <? extends T> (无穷小, T]
     *   表示 ? 是 T的一个未知子类.
     * 通配符的下限:
     * 举例: <? super T> [T,无穷大) [Number,Object)
     * 表示 ? 是T的一个未知的父类.
     */
    @Test
    public void test3() {
        List<? extends Person> list1 = new ArrayList<>();
//        List<? extends Person> list1_1 = new ArrayList<Student>();
//        List<? extends Person> list1_2 = new ArrayList<Person>();
        Person person1 = new Student();
        Person person2 = new Person();
        // 通配符的上限的形式,即List<? extends T> ,除了null之外.不可以往集合中添加任何类型的元素.(原因:?不确定是T/T的那个子类.)
        // 但是可以获取元素.获取的元素类型为 : T
//        list1.add(person1);
//        list1.add(person2);
        Person person = list1.get(0);

        // list1.add(new Object());
        // 通配符的下限形式: 即List<? super T>,可以往集合中添加 T类型/T子类型的元素. (原因: ? 不确定是T/T的那个父类.)
        // 也可以获取元素.但是获取的元素类型为Object.
        List<? super Person> list2 = new ArrayList<>();
        list2.add(person1);
        list2.add(person2);
        // list2.add(new Creature());
        Object object = list2.get(0);
    }
}
