package com.huawei.nce.javabase.day25_26.fanxing;

import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/28 23:08
 */
public class FatherTest {
    @Test
    public void test1() {
        //   父类中有泛型,子类中是否保留泛型的情况.
        Son1 son1 = new Son1();
        son1.setT1(new Object());
        son1.setT2(new Object());
        Object t1 = son1.getT1();

        Son2 son2 = new Son2();
        son2.setT1(5);
        son2.setT2("a");
        Integer t11 = son2.getT1();

        Son3<Long> son3 = new Son3();
        son3.setT1(55);
        son3.setT2(66L);

        Son4<Son3<Character>, Double> son4 = new Son4<>();
        Son3<Character> field = new Son3<>();
        son4.setT1(field);
        son4.setT2(3.14D);
    }

    @Setter
    @Getter
    public class Father<T1, T2> {
        private T1 t1;
        private T2 t2;
    }

    // 1.子类不保留父类的泛型, 没有类型,擦除
    class Son1 extends Father {
    }

    // 2.子类不保留父类的泛型, 写成具体的类型
    class Son2 extends Father<Integer, String> {
    }

    // 3.子类保留了父类的部分泛型,
    class Son3<T2> extends Father<Integer, T2> {
    }

    // 3.子类保留了父类的全部泛型.
    class Son4<T1, T2> extends Father<T1, T2> {
    }

}

