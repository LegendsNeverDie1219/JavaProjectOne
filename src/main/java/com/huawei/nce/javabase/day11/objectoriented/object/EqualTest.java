package com.huawei.nce.javabase.day11.objectoriented.object;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/29 18:50
 */
public class EqualTest {
    /**
     * == 和equal()方法的区别
     * <p>
     * 一.== 是一个比较运算符
     * 1.对于基本数据类型,
     * 除了boolean 类型.其他基本类型的数据之前都可以进行比较.
     * 比较的变量存储的数据(不区分数据类型)
     * 2.对于引用类型的数据.
     * 它比较的是引用的对象在堆内存中的地址值是否相同,即判断是否是一个对象
     * <p>
     * 二. equals() 是根父类Object中的一个方法
     * Object中的equals()方法 ,是比较两个对象的堆内存地址是否相同
     * 但是的很多常用的类,为了比较对象存储的实体内容是否相等
     * 都重写了Object根父类中的equals方法. 比如 String.class, Integer.class, Date.class, File.class
     * 如果我们自定义的类也需要比较对象的实体内容 .则同理.
     *
     * @param args args
     */
    public static void main(String[] args) {
        baseDataType();
        System.out.println("==================================================");
        referenceDataType();
    }

    private static void referenceDataType() {
        String str1 = new String("hds");
        String str2 = new String("hds");
        // false
        // System.out.println(str1 == str2);

//        Customer customer1 = new Customer(null, 21);
//        Customer customer2 = new Customer(null, 21);
        // false
        // System.out.println(customer1 == customer2);

        System.out.println("==================================================");
        // true
        // System.out.println(str1.equals(str2));

        // false
        // System.out.println(customer1.equals(customer2));
        GoodCustomer goodCustomer = new GoodCustomer("tom", 21);
        Customer customer3 = new Customer("tom", 21);
        System.out.println(goodCustomer.equals(customer3));
    }

    private static void baseDataType() {
        int i = 10;
        int j = 10;
        double k = 10.0d;
        // true
        System.out.println(i == j);
        // true
        System.out.println(i == k);
        boolean b = true;
        // Operator '==' cannot be applied to 'int', 'boolean'
        // System.out.println(i == b);

        char c1 = 'A';
        char c2 = 65;
        // true
        System.out.println(c1 == c2);
    }
}
