package com.huawei.nce.javabase.day23_24.collection;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/24 21:06
 */

public class RunnableImpl implements Runnable {
    private  List<String> list =
            Lists.newArrayList("aa", "dd", "cc", "bb", "gg", "zz", "gg", "gg");
    private List<String> synchronizedList =
            Collections.synchronizedList(Lists.newArrayList("aa", "dd", "cc", "bb", "gg", "zz", "gg", "gg"));

    @Override
    public void run() {
        synchronized (this) {
            Iterator<String> iterator = synchronizedList.iterator();
            while (iterator.hasNext()) {
                String next = iterator.next();
                if ("gg".equals(next)) {
                    iterator.remove();
                }
            }
            System.out.println(Thread.currentThread().getName() + ": " + synchronizedList);
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new RunnableImpl();

        Thread thread = new Thread(runnable);
        thread.setName("线程一");
        // Exception in thread "Thread-1" java.util.ConcurrentModificationException
        Thread thread2 = new Thread(runnable);
        thread2.setName("线程二");
        thread.start();
        thread2.start();

        /**
         * aa
         * 线程一: [aa, dd, cc, bb, zz]
         * Exception in thread "main" java.util.ConcurrentModificationException
         * 	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:909)
         * 	at java.util.ArrayList$Itr.next(ArrayList.java:859)
         * 	at com.huawei.nce.javabase.day23_24.collection.RunnableImpl.main(RunnableImpl.java:41)
         */

//        for (String s : synchronizedList) {
//            System.out.println(s);
//        }
    }
}