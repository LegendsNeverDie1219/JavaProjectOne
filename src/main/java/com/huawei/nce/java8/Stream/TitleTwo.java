package com.huawei.nce.java8.Stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author Administrator
 * @date 2022/2/24 22:29
 */
public class TitleTwo {
    /**
     * 给一个非空的单词列表, 返回前K个出现次数最多的单词(如果次数一样多,则按照单词顺序升序)
     * 输入样例:
     * 6
     * <p>
     * I
     * Love
     * Life
     * I
     * Love
     * Coding
     * <p>
     * 2
     * <p>
     * 输出样例:
     * I
     * Love
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入单词列表的个数:");
        int count = Integer.parseInt(scanner.nextLine());
        // key 为单词, value 为单词出现的次数
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < count; i++) {
            System.out.println("请输入单词");
            String inputStr = scanner.nextLine();
            Integer value = countMap.computeIfAbsent(inputStr, key -> 1);
            countMap.put(inputStr, ++value);
            // if (countMap.containsKey(inputStr)) {
            //     Integer value2 = countMap.get(inputStr);
            //     countMap.put(inputStr, ++value2);
            // } else {
            //     countMap.put(inputStr, 1);
            // }
        }

        // 先根据出现频率降序排序, 再根据字母升序排序
        LinkedHashMap<String, Integer> sortedMap = countMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println("请输入要截取的前?个单词");
        int firstFewWorld = scanner.nextInt();
        sortedMap.keySet().stream().limit(firstFewWorld).forEach(System.out::println);
    }
}
