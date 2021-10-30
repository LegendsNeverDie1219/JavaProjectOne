package com.huawei.nce.javabase.day25_26.fanxing;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/29 8:00
 */
// 数据表的共性操作
public class DAO<T> {
    public void add(T t) {
        System.out.println("add success");
    }

    public boolean remove(int index) {
        System.out.println("remove success");
        return true;
    }

    public T get(int index) {
        T result = (T) new Object();
        return result;
    }

    public <E> E insert(int index, E element) {
        E result = (E)new Object();
        return result;
    }

}
