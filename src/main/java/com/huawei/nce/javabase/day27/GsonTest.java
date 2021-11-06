package com.huawei.nce.javabase.day27;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/11/2 22:27
 */
public class GsonTest {
    @Test
    public void testGsonToJson() throws IOException {
        Gson gson = new Gson();
        List<Person> personList = Lists.newArrayList(new Person("huge", 30), new Person("yangmi", 25));
        List<Person> personList2 = Lists.newArrayList(new Person("qiaofeng", 30), new Person("yuyan", 25));
        Map<Integer, List<Person>> map = new HashMap<>();
        map.put(1,personList);
        map.put(2,personList2);
        Set<Map.Entry<Integer, List<Person>>> entries = map.entrySet();
        List<Map.Entry<Integer, List<Person>>> list = new ArrayList<>(entries);

        String jsonStr = gson.toJson(list);
        System.out.println(jsonStr);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("abc.txt"));
        bufferedWriter.write(jsonStr);
        bufferedWriter.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("abc.txt")));
        String oneRowStr = bufferedReader.readLine();
        StringBuilder sb = new StringBuilder();
        while (oneRowStr != null) {
            sb.append(oneRowStr);
            oneRowStr = bufferedReader.readLine();
        }
        String jsonStrTwo = sb.toString();
//        new Gson(Excluder.DEFAULT, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false,
//                false, false, LongSerializationPolicy.DEFAULT, (String)null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
        List<Map.Entry<Integer, List<Person>>> listTwo = gson.fromJson(jsonStrTwo, new ComplexObj().getType());
        /**
         * java.lang.RuntimeException: Unable to invoke no-args constructor for java.util.Map$Entry<java.lang
         * .Integer, java.util.List<com.huawei.nce.javabase.day28.Person>>. Registering an InstanceCreator with Gson
         * for this type may fix this problem.
         */
        /**
         * 无法为 java.util.MapEntry<java.lang.Integer, java.util.List<Person>>
         *   调用无参数构造函数。向 Gson 注册此类型的 InstanceCreator 可能会解决此问题。
         */
        System.out.println(listTwo);


    }

    @Test
    public void testGsonFromJson() throws IOException {
        Gson gson = new Gson();
        List<Person> personList = Lists.newArrayList(new Person("huge", 30), new Person("yangmi", 25));
        List<Person> personList2 = Lists.newArrayList(new Person("qiaofeng", 30), new Person("yuyan", 25));
        Map<Integer, List<Person>> map = new HashMap<>();
        map.put(1,personList);
        map.put(2,personList2);
        List<Map<Integer, List<Person>>> list = new ArrayList<>();
        list.add(map);
        testGsonFromJson(gson, list);
    }

    private void testGsonFromJson(Gson gson, List<Map<Integer, List<Person>>> list) throws IOException {
        String jsonStr = gson.toJson(list);
        System.out.println(jsonStr);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("abc_def.txt"));
        bufferedWriter.write(jsonStr);
        bufferedWriter.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("abc_def.txt")));
        String oneRowStr = bufferedReader.readLine();
        StringBuilder sb = new StringBuilder();
        while (oneRowStr != null) {
            sb.append(oneRowStr);
            oneRowStr = bufferedReader.readLine();
        }
        String jsonStrTwo = sb.toString();
        List<Map<Integer, List<Person>>> listTwo = gson.fromJson(jsonStrTwo, new ComplexObj2().getType());
       // listTwo.forEach(System.out::println);
        for (Map<Integer, List<Person>> integerListMap : listTwo) {
            System.out.println(integerListMap);

        }
    }

    private static  class  ComplexObj extends TypeToken<List<Map.Entry<Integer, List<Person>>>> {
    }

    private static  class  ComplexObj2 extends TypeToken<List<Map<Integer, List<Person>>>> {
    }
}
