package com.huawei.nce.javabase.day23_24.map;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/22 22:44
 */
public class TreeMapTest {
    @Test
    public void test1() {
        Map<User,Integer> map = new TreeMap<>();
        map.put(new User("Tom", 23), 98);
        map.put(new User("Jerry", 32), 89);
        map.put(new User("Jack", 20), 76);
        map.put(new User("Rose", 18), 100);

        //User(name=Jack, age=20), 76
        //User(name=Jerry, age=32), 89
        //User(name=Rose, age=18), 100
        //User(name=Tom, age=23), 98
        map.forEach((key, value) -> {
            System.out.println(key +", " + value);
        });
    }
    @Test
    public void test2() {
        //User(name=Rose, age=18), 100
        //User(name=Jack, age=20), 76
        //User(name=Tom, age=23), 98
        //User(name=Jerry, age=32), 89
//        Map<User,Integer> map = new TreeMap<>(new Comparator<User>() {
//            @Override
//            public int compare(User o1, User o2) {
//                int number = Integer.compare(o1.getAge(), o2.getAge());
//                return number == 0 ? o1.getName().compareTo(o2.getName()) : number;
//            }
//        });

        Map<User,Integer> map = new TreeMap<>(Comparator.comparingInt(User::getAge).thenComparing(User::getName));
        map.put(new User("Tom", 23), 98);
        map.put(new User("Jerry", 32), 89);
        map.put(new User("Jack", 20), 76);
        map.put(new User("Rose", 18), 100);
        map.forEach((key, value) -> {
            System.out.println(key +", " + value);
        });
    }
}
