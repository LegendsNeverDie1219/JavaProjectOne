package com.huawei.nce.javabase.day08.objectoriented.transfer;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/20 9:18
 */
public class TransferTest2 {
    public static void main(String[] args) {
        TransferTest2 transferTest2 = new TransferTest2();
        transferTest2.first();
    }

    private void first() {
        int i = 5;
        Value value = new Value();
        value.i = 25;
        second(value,i);
        System.out.println(value.i);
    }

    private void second(Value value, int i) {
        i = 0;
        value.i = 20;
        Value value2 = new Value();
        value = value2;
        System.out.println(value.i + " " + i);
    }

    private static class Value {
        int i = 15;
    }
}
