package com.huawei.nce.javabase.day29;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Stream;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/11/14 16:53
 */
public class StreamTest {
    /**
     * Stream和Collection集合的区别:
     * Collection 是一种静态的内存结构,主要是面向内存
     * Stream  和计算有关, 主要是面向CPU,通过CPU实现计算
     * <p>
     * Stream 是数据流,数据渠道,用来操作集合,数组生成的元素序列.
     * ①Stream 自己不会存储元素
     * ②Stream  不会改变源对象
     * ③Stream 操作是延迟执行的,只有执行了终止操作/需要结果的时候,才会一股脑将前面的操作都执行一下.
     * <p>
     * Stream操作的三个步骤:
     * 1.创建Stream(实例化)
     * 2.中间操作(过滤,map)
     * 3.终止操作
     */
    // Stream的实例化
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();
        // 方式一: 通过集合,返回一个顺序流  default Stream<E> stream()
        Stream<Employee> stream = employees.stream();
        stream.forEach(System.out::println);
        // 返回一个并行流   default Stream<E> parallelStream()
        Stream<Employee> employeeStream = employees.parallelStream();
        employeeStream.forEach(System.out::println);

        // 方式二: 通过数组Arrays.stream(T[] arr)
        String[] strArr = new String[]{"aaa", "ccc", "bbb"};
        //  public static <T> Stream<T> stream(T[] array)
        Stream<String> stream1 = Arrays.stream(strArr);
        stream1.forEach(System.out::println);
        // 方式三: 通过Stream.of()
        Stream<String> stream2 = Stream.of("a", "c", "E");
        stream2.forEach(System.out::println);
        // 方式四: 通过Stream.iterate() (无限流) list.iterator();
        //   public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);
        // 方式五: 通过Stram.generate() (无限流)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

    @Test
    public void test2() {
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> stream = employees.stream();
        // filter
        stream.filter(employee -> employee.getSalary() > 7000).forEach(System.out::println);

        System.out.println();
        //java.lang.IllegalStateException: stream has already been operated upon or closed
       // stream.forEach(System.out::println); (包括第三个)
        // limit
        employees.stream().limit(3).forEach(System.out::println);
        System.out.println();
        // skip
        employees.stream().skip(3).forEach(System.out::println);

        System.out.println();
        employees.add(new Employee(1010L, "刘强东", 33, 3000.82));
        employees.add(new Employee(1010L, "刘强东", 33, 3000.82));
        employees.add(new Employee(1010L, "刘强东", 33, 3000.82));
        // distinct 筛选去重. 基于流中元素的equals() 和hashcode() 进行去重.
        employees.stream().distinct().forEach(System.out::println);
    }

    @Test
    public void test3() {
        List<String> stringList = Arrays.asList("ab", "cd", "ef");
        // map 接收一个函数形接口作为参数.将流中的每一个元素都映射成一个新的元素.
        stringList.stream().map(str -> str.toUpperCase(Locale.ROOT)).forEach(System.out::println);
        System.out.println(stringList);
        Stream<Stream<Character>> streamStream = stringList.stream().map(StreamTest::fromStringToStream);
        streamStream.forEach(stream ->
                stream.forEach(System.out::println));
        System.out.println("****************************************");
        // flatMap 接收一个函数型接口作为参数,将流中的每一个元素都映射成一个流. 然后把这些小的流连接成一个大的流
        Stream<Character> characterStream = stringList.stream().flatMap(StreamTest::fromStringToStream);
        characterStream.forEach(System.out::println);
    }

    @Test
    public void test4() {
        List<Integer> list = Lists.newArrayList(12, 43,65,34,87,0,-88, 7);
       // list.stream().sorted().forEach(System.out::println);

        List<Employee> employeeList = EmployeeData.getEmployees();
        // java.lang.ClassCastException: Employee cannot be cast to java.lang.Comparable
       // employeeList.stream().sorted().forEach(System.out::println);
        // 先按照id,再按照名称排序
        employeeList.stream().sorted((o1, o2) -> {
            int result = o1.getId().compareTo(o2.getId());
            if (result == 0) {
                return o1.getName().compareTo(o2.getName());
            }
            return result;
        }).forEach(System.out::println);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        // 先按照id倒叙.再按照名称
//        employeeList.stream().sorted(Comparator.comparing(Employee::getName)).sorted(Comparator.comparing(Employee::getId,
//                (id1,id2) -> -id1.compareTo(id2))).forEach(System.out::println);
        employeeList.stream().sorted(Comparator.comparing(Employee::getName)).sorted(Comparator.comparing(Employee::getId, Comparator.reverseOrder())).forEach(System.out::println);
        System.out.println("************************************************");
        employeeList.stream().sorted(Comparator.comparing(Employee::getId).thenComparing(Employee::getName)).forEach(System.out::println);
    }

    // 将一个字符串转化为一个流.
    public static Stream<Character> fromStringToStream (String str) {
        char[] chars = str.toCharArray();
        String[] arr = new String[3];
        //Arrays.stream(chars);
        List<Character> characterList = new ArrayList<>();
        for (char aChar : chars) {
            characterList.add(aChar);
        }
        return characterList.stream();
    }
}
