package com.huawei.nce.javabase.day14.block;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/1 14:59
 */
class Root{
    static{
        System.out.println("Root的静态初始化块");
    }
    {
        System.out.println("Root的普通初始化块");
    }
    public Root(){
        System.out.println("Root的无参数的构造器");
    }
}
class Mid extends Root{
    static{
        System.out.println("Mid的静态初始化块");
    }
    {
        System.out.println("Mid的普通初始化块");
    }
    public Mid(){
        System.out.println("Mid的无参数的构造器");
    }
    public Mid(String msg){
        //通过this调用同一类中重载的构造器
        this();
        System.out.println("Mid的带参数构造器，其参数值："
                + msg);
    }
}
class Leaf extends Mid{
    static{
        System.out.println("Leaf的静态初始化块");
    }
    {
        System.out.println("Leaf的普通初始化块");
    }
    public Leaf(){
        //通过super调用父类中有一个字符串参数的构造器
        super("尚硅谷");
        System.out.println("Leaf的构造器");
    }
}
public class LeafTest{
    /**
     * 1.代码块的作用:用来初始化类,对象
     * 2.代码块可以分为static/不加static两种情况
     * 3静态代码块:
     *  随着类的加载而加载,而且只会加载一次. (直到jvm关闭/内存不够)
     *  作用: 初始化类的信息
     *  内部可以有输出语句.
     * 4.非静态代码块:
     *  随着对象的创建而加载,每创建一个对象,就会加载一次
     *  作用: 初始化对象的信息
     *
     *  5.属性/成员变量可以赋值的地方
     *  ①默认初始化 -> ②显式初始化 / ③代码块中初始化 -> ④构造器中初始化 -> ⑤有了对象后.对象.属性/方法初始化.
     */
    //Root的静态初始化块
    //Mid的静态初始化块
    //Leaf的静态初始化块
    //Root的普通初始化块
    //Root的无参数的构造器
    //Mid的普通初始化块
    //Mid的无参数的构造器
    //Mid的带参数构造器，其参数值：尚硅谷
    //Leaf的普通初始化块
    //Leaf的构造器
    // 总结: 由父及子  静态先行
    public static void main(String[] args){
        new Leaf();
        //new Leaf();
    }
}
