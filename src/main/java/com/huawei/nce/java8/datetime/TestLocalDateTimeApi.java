package com.huawei.nce.java8.datetime;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * TODO
 *
 * @author Administrator
 * @date 2020/9/12 13:29
 */
public class TestLocalDateTimeApi {
    @Test
    public void test1() {
        System.out.println("获取当前日期: " + LocalDate.now());
        System.out.println("获取当前时间: " + LocalTime.now().withNano(0));

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("获取当前日期和时间: " + dateTimeFormatter.format(LocalDateTime.now()));
    }
    @Test
    public void test2() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
    }
}
