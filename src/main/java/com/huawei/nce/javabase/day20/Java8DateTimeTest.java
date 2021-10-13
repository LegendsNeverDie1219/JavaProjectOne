package com.huawei.nce.javabase.day20;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/10 22:38
 */
public class Java8DateTimeTest {
    @Test
    public void test1() {
        // 1.now() 获取当前的日期和时间
        System.out.println(" 1.now() 获取当前的日期和时间");
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        // 2021-10-10
        System.out.println(localDate);
        // 22:40:54.184
        System.out.println(localTime);
        // 2021-10-10T22:40:54.184
        System.out.println(localDateTime);


        // 2.of() 设置指定的年,月,日,时,分,秒,没有偏移量
        System.out.println(" 2.of() 设置指定的年,月,日,时,分,秒,没有偏移量");
        LocalDateTime  localDateTime1 =
                LocalDateTime.of(2021,10,10,22,40,54);
        System.out.println(localDateTime1);

        //3.getXXx()获取相关的属性
        System.out.println("3.getXXx()获取相关的属性");
        System.out.println(localDateTime1.getYear());
        System.out.println(localDateTime1.getMonth());
        System.out.println(localDateTime1.getDayOfMonth());
        System.out.println(localDateTime1.getDayOfWeek());
        System.out.println(localDateTime1.getMonthValue());
        System.out.println(localDateTime1.getMinute());

        //4.withXXx() 设置相关属性 (体现了不可变性)
        System.out.println("withXXx() 设置相关属性");
        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(22).withHour(4);
        System.out.println(localDateTime2);
        System.out.println(localDateTime);

        // 5.加减
        System.out.println("plusXX/minusXXX");
        LocalDateTime localDateTime3 = localDateTime2.plusMonths(3).minusHours(4);
        System.out.println(localDateTime3);
    }

    /**
     * Instant 相当于 Date
     */
    @Test
    public void test2() {
        // 2021-10-10T15:01:11.439Z
        // 1.获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);
        // 2021-10-10T23:01:11.439+08:00
        // 添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        //1633878071439
        // 2.获取自从1970-01-01 0日0分0秒 开始的毫秒数
        long toEpochMilli = instant.toEpochMilli();
        // 1634046085519
        System.out.println(toEpochMilli);
        // 1970-01-19T00:05:55.555Z
        // 3.通过给的毫秒数,获取对应的时间
        Instant instant1 = Instant.ofEpochMilli(1634046085519L);
        // 2021-10-12T13:41:25.519Z
        System.out.println(instant1);
    }
    
    @Test
    public void test3() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        Instant instant = Instant.now();
        // 2021-10-12T13:35:45.113Z
        System.out.println(instant);
       // System.out.println(formatter.format(instant));
        // 2021-10-10 11:08:25
        System.out.println(formatter.format(LocalDateTime.now()));
        // {NanoOfSecond=0, MicroOfSecond=0, SecondOfMinute=18, MilliOfSecond=0, MinuteOfHour=52, HourOfAmPm=3},
        // ISO resolved to 2019-02-18
        System.out.println(formatter.parse("2019-02-18 03:52:18"));
    }
}
