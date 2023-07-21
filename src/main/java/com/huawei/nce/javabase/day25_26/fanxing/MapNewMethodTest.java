package com.huawei.nce.javabase.day25_26.fanxing;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/27 22:43
 */
public class MapNewMethodTest {
    Map<String, Integer> unsortMap = new HashMap<>();

    @BeforeEach
    public void initData() {
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 99);
        unsortMap.put("g", 50);
        unsortMap.put("m", 2);
        unsortMap.put("f", 9);
    }

    @Test
    public void test() {
        System.out.println("original ...");
        // {a=6, b=5, c=20, d=1, e=7, f=9, g=50, y=8, z=10, m=2, n=99}
        System.out.println(unsortMap);
    }

    @Test
    public void testSortedByKey() {
        //  java.util.HashMap$Node cannot be cast to java.lang.Comparable
//        LinkedHashMap<String, Integer> collect =
//                unsortMap.entrySet().stream().sorted()
//                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
//                                (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        // {a=6, b=5, c=20, d=1, e=7, f=9, g=50, y=8, z=10, m=2, n=99}
        HashMap<String, Integer> collect2 =
                unsortMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue, HashMap::new));

    // {a=6, b=5, c=20, d=1, e=7, f=9, g=50, m=2, n=99, y=8, z=10}
        LinkedHashMap<String, Integer> collect3 =
                unsortMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println(collect2);
        System.out.println(collect3);

        unsortMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEachOrdered(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }

    @Test
    public void testSortedByValue() {
        // {d=1, m=2, b=5, a=6, e=7, y=8, f=9, z=10, c=20, g=50, n=99}
        LinkedHashMap<String, Integer> collect1 =
                unsortMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        System.out.println(collect1);
        // {n=99, g=50, c=20, z=10, f=9, y=8, e=7, a=6, b=5, m=2, d=1}
        LinkedHashMap<String, Integer> collect2 =
                unsortMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println(collect2);
        AtomicReference atomicReference = new AtomicReference();
    }

    @Test
    public void test3() {
        Integer integer1 = unsortMap.computeIfAbsent("aafsdf", key -> this.genValue(key));
        // 6
        System.out.println(unsortMap);
        System.out.println(integer1);
        Integer integer2 = unsortMap.computeIfAbsent("n", this::genValue);
        // 99
        System.out.println(integer2);
        List<String> list = Lists.newArrayList("aa", "Bb", "CC");
        list.removeIf(str -> "aaa".equals(str));
        list.remove("aaa");
        list.forEach(System.out::println);
    }

   public int  genValue(String str) {
        return str.length();
   }
    @Test
    public void test4() {
        //List<String> sourceList = Lists.newArrayList("aa", "bb", "cc");
        List<String> sourceList = new ArrayList<>();
        sourceList.add("aa");
        sourceList.add("bb");
        sourceList.add("cc");
        // Arrays.asList 得到的 new ArrayList() 是Arrays工具类内部声明的一个内部类
        //     private static class ArrayList<E> extends AbstractList<E>
        //        implements RandomAccess, java.io.Serializable
        // 它本身没有remove() 方法, AbstractList父类中有一个remove() 方法体是  throw new UnsupportedOperationException();
        List<String> targetList = Arrays.asList(new String[sourceList.size()]);
        Collections.copy(targetList, sourceList);
        // [aa, bb, cc]
        System.out.println(targetList);

        List<String> minusList = new ArrayList<>();

        // java.lang.UnsupportedOperationException
        //	at java.util.AbstractList.add(AbstractList.java:148)
        minusList.add("aa");

        // java.lang.UnsupportedOperationException
        //	at java.util.AbstractList.remove(AbstractList.java:161)

       // boolean b = targetList.removeAll(minusList);
      //  boolean b = targetList.addAll(minusList);
        // 结论: Arrays.asList(E[] array) 得到的ArrayList ,不支持 add, remove操作. 支持 get() set() 操作.
        String b = targetList.set(1,"99");
        System.out.println(b);
        System.out.println(targetList);
    }
}

