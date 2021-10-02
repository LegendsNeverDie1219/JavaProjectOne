package com.huawei.nce.javabase.day11.objectoriented.object;


import org.apache.commons.beanutils.BeanUtils;
import org.junit.jupiter.api.Test;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/28 22:21
 */
public class CloneTest2 {
    @Test
    public void tesBeanUtils() {
        Person p1 = PersonFactory.newPrototypeInstance();
        try {
            // org.apache.commons.beanutils.BeanUtils.cloneBean()
            Person p2 = (Person) BeanUtils.cloneBean(p1);
            // p1=Person(name=Peter, age=31, address=Address(type=Home, value=北京))
            //p2=Person(name=Peter, age=31, address=Address(type=Office, value=北京))
            System.out.println("p1=" + p1);
            p2.getAddress().setType("Office");
            System.out.println("p2=" + p2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBatchClone(){
        Long start=System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            Person p1=PersonFactory.newPrototypeInstance();
            try {
                Person p2=(Person) p1.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("clone:"+(System.currentTimeMillis()-start));
        //clone:8
    }

    @Test
    public void testBatchBeanUtils(){
        Long start=System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            Person p1=PersonFactory.newPrototypeInstance();
            try {
                Person p2=(Person) BeanUtils.cloneBean(p1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("commons-beanutils:"+(System.currentTimeMillis()-start));
        //commons-beanutils：229
    }

}
