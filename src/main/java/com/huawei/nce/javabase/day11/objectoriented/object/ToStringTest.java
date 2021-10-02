package com.huawei.nce.javabase.day11.objectoriented.object;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/29 20:41
 */
public class ToStringTest {
    public static void main(String[] args) {
        Customer customer = new Customer("tom", 21);
        /**
         *     public String toString() {
         *         return getClass().getName() + "@" + Integer.toHexString(hashCode());
         *     }
         */
        // com.huawei.nce.javabase.day11.objectoriented.object.Customer@366cc4
        // Customer{name='tom', age=21}
        System.out.println(customer);
    }
}
