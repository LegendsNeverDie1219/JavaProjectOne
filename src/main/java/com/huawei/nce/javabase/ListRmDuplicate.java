package com.huawei.nce.javabase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author Administrator
 * @date 2022/9/9 19:47
 */
public class ListRmDuplicate {
    private List<String> list;
    private List<Player> playerList;


    @BeforeEach
    public void setup() {
        list = new ArrayList<>();
        list.add("kobe");
        list.add("james");
        list.add("curry");
        list.add("zimug");
        list.add("zimug");
        playerList = new ArrayList<>();

        playerList.add(new Player("kobe", "10000"));  //科比万岁
        playerList.add(new Player("james", "32"));
        playerList.add(new Player("curry", "30"));
        playerList.add(new Player("zimug", "27"));   // 注意这里名字重复
        playerList.add(new Player("zimug", "18"));   //注意这里名字和年龄重复
        playerList.add(new Player("zimug", "18")); //注意这里名字和年龄重复

        playerList = new ArrayList<>();
        playerList.add(new Player("kobe", "10000"));  //科比万岁
        playerList.add(new Player("james", "32"));
        playerList.add(new Player("curry", "30"));
        playerList.add(new Player("zimug", "27"));   // 注意这里名字重复
        playerList.add(new Player("zimug", "18"));   //注意这里名字和年龄重复
        playerList.add(new Player("zimug", "18")); //注意这里名字和年龄重复
    }

    @Test
    public void testRemove5() {
        //Set<Player> playerSet = new TreeSet<>((o1, o2) -> o1.getName().compareTo(o2.getName()));
        Set<Player> playerSet = new TreeSet<>(Comparator.comparing(Player::getName));
        playerSet.addAll(playerList);
        new ArrayList<>(playerSet).forEach(player -> {
            System.out.println(player.toString());
        });
    }

    @Test
    void testRemove6() {
        List<Player> newList = playerList.stream().collect(Collectors
                .collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Player::getName))),
                        ArrayList::new));
        newList.forEach(System.out::println);
    }

    @Test
    void testRemove7() {
        List<Player> newList = new ArrayList<>();
        // filter保留true的值
        playerList.stream().filter(this.distinctByKey(Player::getName))
                .forEach(newList::add);
        newList.forEach(System.out::println);
    }

    public  <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        //putIfAbsent方法添加键值对，如果map集合中没有该key对应的值，
        // 则直接添加，并返回null，如果已经存在对应的值，则依旧为原来的值。
        //如果返回null表示添加数据成功(不重复)，不重复(null==null :TRUE)
       // return new Predicate<T>() {
       //      @Override
       //      public boolean test(Object o) {
       //          return false;
       //      }
       //  };
        return t -> isaBoolean(keyExtractor, seen, t);
    }

    private static <T> boolean isaBoolean(Function<? super T, ?> keyExtractor, Map<Object, Boolean> seen, T t) {
        return seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}