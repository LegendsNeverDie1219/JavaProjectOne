package com.huawei.nce.javabase.day20;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/11 7:57
 */
public class CompareTest {
    private static final Goods[] goods;
    static {
        goods = new Goods[5];
        goods[0] = new Goods("lenovoMouse", 34);
        goods[1] = new Goods("dellMouse", 43);
        goods[2] = new Goods("xiaomiMouse", 12);
        goods[3] = new Goods("huaweiMouse", 65);
        goods[4] = new Goods("huaweiMouse", 12);
    }

    /**
     * 一.背景
     * java中的对象,正常情况下,只能用 == != 比较堆内存中的地址值  ,不能用>  < 来进行比较
     * 但是实际开发中我们需要根据对象的中的属性值进行排序,那么就需要实现Comparable接口 重写compareTo方法
     * 或者实现Comparator接口, 重写compare方法.
     * 二.Comparable接口的使用
     * 1.想我们常用的String类,包装类, 都实现了Comparable接口,重写的compareTo()方法,默认排序方式是从小到大排序
     * 2.重写compareTo(obj)的规则是
     * 如果当前对象的属性值 大于 形参对象的obj  则返回正整数
     * 如果当前对象 小于形参对象obj, 则返回 负整数.
     * 如果当前对象  等于形参对象obj ,则返回0
     * <p>
     * 三.Comparator接口的使用
     * 1.如果当前对象所属的类没有实现Comparable接口并且不方便修改代码的时候
     * 或者当前对象所属的类实现了Compareable接口,但是对应的自然排序规则不是我们现在所想要的.
     * 这个时候就需要考虑使用Comparator接口来进行排序
     * 2.重写Compare(obj1, obj2)方法的规则是
     * 如果返回值为正整数,则 表示obj1 大于obj2
     * 如果返回负整数,则表示obj1 小于obj2
     * 如果返回是0, 则相等.
     *
     * 四.两种方式的对比
     * 如果需要该对象在任何地方都可以进行大小比较, 则实现Comparable接口
     * 如果只是临时比较一下大小, 则只用实现的Comparator接口
     */
    @Test
    public void test1() {
        String[] strArr = new String[]{"AA", "CC", "UU", "KK", "FF"};
        Arrays.sort(strArr);
        System.out.println(Arrays.toString(strArr));
        // java.lang.ClassCastException: day20.Goods cannot be cast to java.lang.Comparable
        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));
    }

    @Test
    public void test2() {
        // new了一个Comparator接口的匿名实现类的匿名对象.
        Arrays.sort(goods, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (!(o1 instanceof Goods && o2 instanceof Goods)) {
                    throw new RuntimeException("入参对象不是Goods类型/Goods子类型的对象");
                }
                Goods goodsOne = (Goods) o1;
                Goods goodsTwo = (Goods) o2;
                if (goodsOne.getName().compareTo(goodsTwo.getName()) > 0) {
                    return 1;
                } else if (goodsOne.getName().compareTo(goodsTwo.getName()) < 0) {
                    return -1;
                } else {
                    if (goodsOne.getPrice() > goodsTwo.getPrice()) {
                        return 1;
                    } else if (goodsOne.getPrice() < goodsTwo.getPrice()) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        });
        System.out.println(Arrays.toString(goods));
        //  new了一个Comparator接口实现类的匿名对象
        // Arrays.sort(str,new ComparatorImpl());
        /**
         * 产生的运行时异常是不用处理的(向上抛出/捕获)
         * 产生的编译时异常时需要处理的(如果是自己手动制造的异常,则一般的处理方式是向上抛出)
         */
        // throw new Exception("ssss");
        // throw new RuntimeException("aaaaa");
    }
}

class ComparatorImpl implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}