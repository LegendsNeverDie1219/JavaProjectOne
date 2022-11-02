package com.huawei.nce.javabase.day23_24.collection;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/24 16:06
 */
public class CollectionsTestOne {
    /**
     * Collections 一个操作List, Set .Map的工具类.
     * 排序操作:
     * reverse(List) 反转List集合.
     * shuffle(List) 对List集合中的元素进行随机排序
     * sort(List) 根据元素的自然排序.对List集合中的元素进行排序
     * sort(List, Comparator)根据元素的定制排序,对List集合中的元素进行排序
     * swap(List, int i, int j) 将List集合中i处位置的元素和j处位置的元素进行交换顺序
     */
    private static List<String> stringList;

    @BeforeEach
    public void initData() {
        stringList = Lists.newArrayList("aa", "dd", "cc", "bb", "gg", "zz", "gg", "gg");
    }

    @Test
    public void test1() {

        System.out.println("原始list: " + stringList);
       // List<String> strings = Collections.synchronizedList(stringList);


        Collections.reverse(stringList);
        System.out.println("Collections.reverse: " + stringList);

        Collections.shuffle(stringList);
        System.out.println("Collections.shuffle: " + stringList);

        Collections.sort(stringList);
        System.out.println("Collections.sort(List list): " + stringList);
        Collections.sort(stringList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });
        stringList.sort((o1, o2) -> -o1.compareTo(o2));
        System.out.println("Collections.sort(List list, Comparator comparator): " + stringList);

        Collections.swap(stringList, 0, stringList.size() - 1);
        System.out.println("Collections.swap(List list, int i, int j): " + stringList);
    }

    /**
     * 查找、替换
     * Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
     * Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回
     * 给定集合中的最大元素
     * Object min(Collection)
     * Object min(Collection，Comparator)
     * int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
     * void copy(List dest,List src)：将src中的内容复制到dest中
     * boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换
     * List 对象的所有旧值
     */

    @Test
    public void test2() {
        String max = Collections.max(stringList);
        System.out.println(" Collections.max(stringList): " + max);
        String max1 = Collections.max(stringList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });
        System.out.println("Collections.max(stringList, new Comparator): " + max1);

        String min = Collections.min(stringList);
        System.out.println(" Collections.min(stringList): " + min);
        int count = Collections.frequency(stringList, "gg");
        System.out.println("Collections.frequency(stringList, \"gg\"): " + count);
    }

    @Test
    public void test3() {
        List<String> destList1 = new ArrayList<>(8);
        List<String> destList = Arrays.asList(new String[stringList.size()]);
        Collections.copy(destList, stringList);
        // java.lang.IndexOutOfBoundsException: Source does not fit in dest
        System.out.println("Collections.copy(destList, stringList): " + destList);

        boolean b = Collections.replaceAll(destList, "gg", "cmd");
        System.out.println("Collections.replaceAll(): " + destList);
        System.out.println("Collections.replaceAll(): " + stringList);
    }


    @Test
    public void test4() {
        List<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");
        // java.util.ConcurrentModificationException
        /**
         * modCount是集合添加元素、删除元素的次数，expectedModCount是预期的修改次数。
         * 因为我们增加了2个元素，所以，modCount是2，预期修改的次数expectedModCount也是2
         * 现在解释一下，为什么“1”时没有出错，2是却出错了。
         * “1”时，第一次循环后，光标变为1，第一个元素已经移除，所以元素个数是1；
         * 进入第二次循环，判断hasNext（）由于光标=元素个数，所以，终止循环，所以，就结束了。
         * “2”时，第二次循环后，光标变为2，此时元素个数是1，光标!=元素个数，所以进入next()
         * 方法，next（）中调用checkForComodification，modCount是3，expectedModCount是2，两者不相等，所以抛出异常。
         */
        for (String temp : a) {
            if ("2".equals(temp)) {
                a.remove(temp);
            }
        }
        System.out.println(a);
    }
}
