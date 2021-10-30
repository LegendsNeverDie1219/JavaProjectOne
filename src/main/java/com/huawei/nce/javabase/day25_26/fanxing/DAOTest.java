package com.huawei.nce.javabase.day25_26.fanxing;

import org.junit.jupiter.api.Test;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/29 8:13
 */
public class DAOTest {
    @Test
    public void test1() {
        // 子类不保留父类的泛型, 写成了具体的类型
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.add(new Customer());
       // customerDAO.add(new Student());
        Customer customer = customerDAO.get(10);

        StudentDAO studentDAO = new StudentDAO();
        studentDAO.add(new Student());
        Student student = studentDAO.get(100);

        Customer insert1 = customerDAO.insert(7758, new Customer());
        Student insert2 = customerDAO.insert(77582, new Student());
    }
}
