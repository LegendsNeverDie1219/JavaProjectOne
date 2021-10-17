package com.huawei.nce.javabase.day23_24.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/17 17:27
 */
public class ForTest {
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
        // for(集合中的元素类型  局部变量 : 集合对象)
        // 内部还是调用了迭代器
        for (Object obj : coll) {
            System.out.println(obj);
        }
    }
    
    @Test
    public void test2() {
        String[] arr = new String[] {"MM","MM","MM"};
        // 普通for循环
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = "GG";
//        }
        // 增强for循环.
        for (String s : arr) {
            s = "GG";
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    
    @Test
    public void test3() {
        
    }
}
