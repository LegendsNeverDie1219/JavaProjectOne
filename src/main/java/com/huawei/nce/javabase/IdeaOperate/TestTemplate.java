package com.huawei.nce.javabase.IdeaOperate;

import com.google.common.collect.Lists;
import com.huawei.nce.pojo.Customer;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * settings -> editor -> live template
 *
 * @author Administrator
 * @date 2021/8/15 10:48
 */
public class TestTemplate {
    // 模板六: prsf
    private static final Customer customer = new Customer();
    //psf
    public static final String str = "";
    //psfi
    public static final int i = 1;
    // psfs
    public static final String str2 = "";



    /***
     * 模板一  main/psvm
     *
     * @param args args
     **/
    public static void main(String[] args) {
        // 模板二: sout
        System.out.println("hello");
        // 变形 :soutp,  soutm,  soutv,  xxx.sout
        // soutp
        System.out.println("args = " + Arrays.deepToString(args));
        // soutm
        System.out.println("TestTemplate.main");
        // soutv
        System.out.println("args = " + args);
        int numOne = 1;
        System.out.println("numOne = " + numOne);
        int numTwo = 2;
        System.out.println("numTwo = " + numTwo);
        // xxx.sout
        System.out.println(numOne);
    }

    @Test
    public void testCycle() {
        String[] stringArray = {"aaa", "bbb", "ccc", "ddd"};
        // 模板三: stringArray.fori
        for (int i = 0; i < stringArray.length; i++) {
            // stringArray[i].sout
            System.out.println(stringArray[i]);
        }
        //变形: stringArray.iter
        for (String s : stringArray) {
            System.out.println(s);
        }
        //变形:itar
        for (int i = 0; i < stringArray.length; i++) {
            String s = stringArray[i];

        }

        List<String> arrayList = Lists.newArrayList("huge", "huojianhua", "tangyan", "yangmi", "liushishi");
        // 模板四:arrayList.fori
        for (int i = 0; i < arrayList.size(); i++) {
            // arrayList.get(i).sout
            System.out.println(arrayList.get(i));
        }
        //arrayList.for
        for (String s : arrayList) {
            System.out.println(s);
        }
        // 模板五:ifn
        if (arrayList == null) {

        }
        // inn
        if (arrayList != null) {

        }

        // xxx.null
        if (arrayList == null) {

        }

        // xxxx.nn
        if (arrayList != null) {

        }
    }

    @Test
    public void testCustomerTemplate() {
        System.out.println("customer Template");
    }

    @Test
    public void testsss() {
        System.out.println();
    }
}
