package com.huawei.nce.javabase.day23_24.map;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/22 21:00
 */
public class MapTest {
    /**
     * 一.Map接口的继承树
     * Map: 双列数据的容器,存储key-value对,--- 类似于高中的函数: y = f(x)
     *      HashMap:作为Map接口的主要实现类,线程不安全,但是效率高.可以存储null的key 和value
     *          LinkedHashMap:保证在遍历Map的时候,可以按照添加的顺序去遍历
     *          原因: 在原有的HashMap的底层结构基础上,添加了一对指针,指向前一个和后一个元素
     *          对于频繁的遍历操作,此类的执行效率要高于HashMap
     *      TreeMap:保证在添加key-value的时候,能够对Map中的key进行排序.(如果key是自定义类型的对象时,需要
     *      该类实现Comparable接口或者Comparator接口 重写 compareTo()/compare()) 底层使用的是红黑树
     *      Hashtable:作为Map接口的古老实现类,线程安全,几乎所有的方法是synchronized的同步方法, 效率低.
     *      不可以存储null的key和value.
     *          Properties:其中key和value都是string类型的.所以常用来处理配置文件.
     *  面试题:
     *  1.HashMap的底层
     *  2.HashMap和Hashtable的异同
     *  3.ConcurrentHashMap和hashtable的异同?
     *  二.Map结构的理解:
     *  Map中的key:
     *      无序的,不可重复的, 使用Set存储Map中的所有key
     *      其中key所在对象的类需要重写equals() hashCode()方法, 基础类底层已经重写好了.自定义类需要我们手动重写.
     *  Map中的value
     *      无序的,可重复的,使用Collection存储Map中的所有value.
     *      其中value所在对象的类需要重写equals()方法
     *  Map中的entry(一对key-value 是一个entry对象)
     *      无序的,不可重复的,使用Set存储Map中的所有的entry
     *  三.HashMap的底层:
     *      3.1数组+ 链表(jdk7.0以及之前)
     *    HashMap map = new HashMap()
     *    在实例化之后,底层创建了一个长度为16的一维数组 transient Entry<K,V>[] table = new Entry[16]
     *    ...可能已经执行官过了多次put
     *    map.put(key1,value1)
     *    首先,调用key1对象所在类的hashCode() 方法.得到一个哈希值,然后基于某种算法,得到这个哈希值对应Entry[]数组的索引
     *    接着, 判断这个索引位置是否为空
     *      如果为空, 则将这个Entry对象放到该数组位置 ------情况一
     *      如果不为空,则意味着该索引位置存在1-多个元素(其中以链表形式存在),其次,拿key1的哈希值与该位置其他元素的哈希值进行比较
     *          如果都不相同, 则将这个Entry对象,存储成功  ----情况二
     *          如果有一个相同, 则需要调用key1.equals(obj)进行比较.
     *              如果不相等,则将这个Entry对象存储成功 ------ 情况三
     *              如果相同,则是更新操作.将新的entry对象,替换之前的entry对象.-------情况四
     *                  其中 新的entry对象放到数组中,新元素 -> 老元素.
     *                  在不断添加的过程,只要超过了阈值(当前数组容器*0.75),就会扩容,默认扩容方式为原来的2倍.
     *  3.2 数组+ 链表+ 红黑树(jdk8.0)
     *  1.Hash map = new HashMap()
     *    在实例化之后,底层没有创建一个 Entry[]数组,而是在第一次put(key,value)的时候,才创建一个长度的是16的一维Node[]
     *  2.底层结构是数组+链表+红黑树
     *  链表 转化为  红黑树的 条件
     *    当数组中某一个索引位置上的数据个数> 8 && 数组.length > 64 
     */
    /**
     * 增删改
     * 添加
     * Object put(Object key, Object value)
     * 其中,如果添加的key在Map中不存在,则是添加操作, 返回值为null
     * 如果添加的key在Map中存在,则是更新操作, 返回值为原来的key对应的value.
     * 删除 Object remove(Object key) 移除指定key对应的key-value,返回对应的value.
     * 修改 Object put(Object key, Object value)
     */

    private static final Map<Integer, String> staticMap = new HashMap<>();

    static {
        staticMap.put(123, "AA");
        staticMap.put(345, "BB");
        staticMap.put(789, "GG");
    }

    @Test
    public void test1() {
        // null
        System.out.println(staticMap.put(12, "CC"));
        // CC
        System.out.println(staticMap.put(12, "DD"));
        // 3
        System.out.println(staticMap.size());
        // DD
        System.out.println(staticMap.remove(12));
        // 2
        System.out.println(staticMap.size());
    }

    /**
     * 查询
     * Object get(Object key) 获取Map中指定key 对应的value
     * boolean containKey(Object key) 判断Map中是否包含该key.
     * boolean containValue(Object value) 判断Map中是否包含该value
     * int size() 返回Map中的key-value 的个数
     * boolean isEmpty() 判断当前Map是否为null(即容器中没有元素)
     * boolean equals(Object obj): 判断当前Map和目标obj是否相等.
     * <p>
     * 元视图的操作
     * Set keySet() : 获取所有key组成的集合
     * Collection values() 获取所有value组成的集合.
     * Set entrySet() 获取所有key-value组成的集合.
     */
    @Test
    public void test2() {
        Set<Integer> set = staticMap.keySet();
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer key : set) {
            // System.out.print("{" + key + " : " + map.get(key) + "}, ");
            stringBuilder.append('{').append(key).append(" : ").append(staticMap.get(key)).append("}, ");
        }
//        Iterator iterator = set.iterator();
//        while (iterator.hasNext()) {
//            Object key = iterator.next();
//            stringBuilder.append('{').append(key).append(" : ").append(map.get(key)).append("}, ");
//        }
        // {789 : GG}, {345 : BB}, {123 : AA}
        String str = stringBuilder.toString().replaceAll("^, |, $", "");
        System.out.println(str);
        System.out.println("========================");
        Collection<String> values = staticMap.values();
        StringBuilder stringBuilder2 = new StringBuilder();
        for (Object value : values) {
            stringBuilder2.append(value).append(", ");
        }
        // GG, BB, AA
        System.out.println(stringBuilder2.toString().replaceAll(", $", ""));

        System.out.println("========================");
        StringBuilder stringBuilder3 = new StringBuilder();
        for (Map.Entry<Integer, String> entry : staticMap.entrySet()) {
            stringBuilder3.append('{').append(entry.getKey()).append(" : ").append(entry.getValue()).append("}, ");
        }
        System.out.println(stringBuilder3.toString().replaceAll(", $", ""));

        System.out.println("map.containsKey(\"123\")" + staticMap.containsKey(123));
        System.out.println("map.containsValue(\"AA\")" + staticMap.containsValue("AA"));
        Map<Integer, String> instanceMap = new HashMap<>();
        instanceMap.put(345, "BB");
        instanceMap.put(123, "AA");
        instanceMap.put(789, "GG");
        // true
        System.out.println("instanceMap.equals(MapTest.staticMap)" + instanceMap.equals(MapTest.staticMap));
    }
}
