package com.huawei.nce.javabase.day14.interfacetest;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/2 10:34
 */
public class Java8InterfaceTest {
    /**
     * Java 8中，你可以为接口添加静态方法和默认方法
     *
     * 静态方法：使用 static 关键字修饰。可以通过接口直接调用静态方法
     *
     * Collection/Collections或者Path/Paths这样成对的接口和类。
     * java.util.Collections#sort(java.util.List, java.util.Comparator)
     *
     *  默认方法使用 default 关键字修饰。可以通过实现类对象来调用。
     * 我们在已有的接口中提供新方法的同时，还保持了与旧版本代码的兼容性。
     * 比如：java 8 API中对Collection、List、Comparator等接口提供了丰富的默认方法
     * java.util.Collection#stream()
     * java.util.Collection#removeIf(java.util.function.Predicate)
     */
    public static void main(String[] args) {
        new Man().help();
    }




}
interface Filial {
    default void help() {
        System.out.println("老妈,我来救你了");
    }
}

interface Spoony {
    default void help() {
        System.out.println("媳妇,我来救你了");
    }
}

class Father {
    public void help() {
        System.out.println("儿子,救我媳妇");
    }
}

class Man extends Father implements Filial,Spoony {

    @Override
    public void help() {
        super.help();
        Filial.super.help();
        Spoony.super.help();
        System.out.println("我该救谁呢?");
    }
}