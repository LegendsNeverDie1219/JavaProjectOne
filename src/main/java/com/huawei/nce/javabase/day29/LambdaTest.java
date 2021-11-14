package com.huawei.nce.javabase.day29;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/11/14 14:32
 */
public class LambdaTest {
    /**
     * Lambda表达式的本质: 函数式接口的匿名实现类的匿名实例
     * Lambda表达式的使用:
     * 1.举例: (o1, o2) -> Integer.compare(o1,o2);
     * 2.格式:
     * ->:  Lambda操作符/箭头符号
     * ->的左边:  lambda的形参列表(即函数式接口中抽象方法的形参列表)
     * ->的右边: lambda方法体(即函数式接口中抽象方法的具体实现)
     * 3.lambda表达式的使用(分六种情况)
     */
    @Test
    public void test1() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门广场");
            }
        };

        runnable.run();
        System.out.println("***********************************************");
        // 情况一: 无参数,无返回值
        Runnable runnable2 = () -> System.out.println("我爱北京故宫");
        runnable2.run();
    }

    @Test
    public void test2() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        int compare = comparator.compare(12, 21);
        System.out.println(compare);

        System.out.println("***************************");
        // Lambda表达式的写法
        Comparator<Integer> comparator2 = Comparator.naturalOrder();
        // 方法引用的写法
        int compare1 = comparator2.compare(21, 12);
        System.out.println(compare1);
        Comparator<Integer> comparator3 = Integer::compare;
    }

    // 情况二: lambda有参数,但是没有返回值.(消费型接口)
    @Test
    public void test3() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        consumer.accept("谎言和和誓言的区别是什么?");
        System.out.println("*******************************");
        Consumer<String> consumer2 = s -> System.out.println(s);
        consumer2.accept("一个是听得人当真了,一个是说的人当真了.");
    }

    // lambda无参数,但是有返回值 (供给型接口)
    @Test
    public void test4() {
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "cmd";
            }
        };
        System.out.println(supplier.get());

        Supplier<String> supplier1 = () -> {
            return "cnm";
        };
        Supplier<String> supplier2 = () -> "草泥马";
        System.out.println(supplier1.get());
        System.out.println(supplier2.get());
    }

    // lambda有参数有返回值 (函数型接口)
    @Test
    public void test5() {
        Function<String, Integer> function = new Function<String, Integer>() {

            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };

        System.out.println(function.apply("7758258"));

        Function<String, Integer> function2 = s -> s.length();
        System.out.println(function2.apply("cmd"));
    }

    // 有参数有返回值(返回值为boolean) 断言形接口
    @Test
    public void test6() {
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.equals("hds");
            }
        };
        System.out.println(predicate.test("dfa"));
        Predicate<String> predicate2 = s -> s.equals("hds");
        System.out.println(predicate2.test("hds"));
    }

    @Test
    public void test7() {
        happyTime(500, money -> System.out.println("学习太累.去天上人间买了一瓶矿泉水,价格为: " + money));
        List<String> list = Arrays.asList("北京", "南京", "上海", "东京", "西京", "普京");
        List<String> strings1 = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("海");
            }
        });
        System.out.println(strings1);
        List<String> strings = filterString(list, s -> s.contains("京"));
        System.out.println(strings);
    }

    public List<String> filterString(List<String> list, Predicate<String> predicate) {
        List<String> filterList = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)) {
                filterList.add(s);
            }
        }

        return filterList;
    }
    public void happyTime(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }
}
