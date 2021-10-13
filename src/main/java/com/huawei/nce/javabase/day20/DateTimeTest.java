package com.huawei.nce.javabase.day20;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * JDK1.8之前的日期时间API
 *
 * @author Administrator
 * @date 2021/10/10 11:25
 */
public class DateTimeTest {
    /**
     * System.currentTimeMillis()
     */
    @Test
    public void test1() {
        long time = System.currentTimeMillis();
        // 1633836436014
        // 返回的是1970年1月1日0时0分0秒到此刻的毫秒数
        System.out.println(time);
    }

    /**
     * java.util.Date /java.sql.Date
     */
    @Test
    public void test2() {
        // 构造器一: Date() 创建一个对应当期时间的Date对象
        System.out.println(" 构造器一: Date() 创建一个对应当期时间的Date对象");
        Date date = new Date();
        System.out.println(date.toString()); // Sun Oct 10 11:38:16 CST 2021

        System.out.println(date.getTime()); //1633837096323

        // 构造器二:Date(long date) 创建一个对应毫秒数的Date对象
        System.out.println("构造器二:Date(long date) 创建一个对应毫秒数的Date对象");
        Date date1 = new Date(1633836436014L);
        System.out.println(date1.toString()); //Sun Oct 10 11:27:16 CST 2021
        System.out.println(date1.getTime()); //1633836436014

        // 创建java.sql.Date对象
        //public class Date extends java.util.Date{}
        System.out.println("创建java.sql.Date对象");
        java.sql.Date date2 = new java.sql.Date(1633836436014L);
        System.out.println(date2); // 2021-10-10
        System.out.println(date2.getTime()); // 1633836436014

        // 如何将java.sql.Date对象转换为java.util.Date对象
        System.out.println(" 如何将java.sql.Date对象转换为java.util.Date对象");
        Date date3 = new Date();
        java.sql.Date date4 = new java.sql.Date(date3.getTime());
        System.out.println(date3); // Sun Oct 10 11:38:16 CST 2021
        System.out.println(date4); // 2021-10-10
    }

    /**
     * SimpleDateFormat
     *
     * @throws ParseException
     */
    @Test
    public void test3() throws ParseException {
        System.out.println("实例化SimpleDateFormat,使用无参构造器");
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date();
        // Sun Oct 10 21:53:45 CST 2021
        System.out.println(date);
        // 格式化 : 日期-> 字符串
        // 21-10-10 下午9:53
        System.out.println(sdf.format(date));
        // 解析: 字符串 -> 日期
        Date date2 = sdf.parse("21-10-11 下午9:58");
        System.out.println(date2.toString());
        System.out.println("实例化SimpleDateFormat,使用带参构造器");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sdf2.format(new Date()));

        System.out.println(sdf2.parse("2021-10-10 10:00:35"));
    }

    /**
     * 字符串2020-09-08 转化为java.sql.Date
     */
    @Test
    public void testExer() throws ParseException {
        String birth = "2020-09-08";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date utilDate = simpleDateFormat.parse(birth);
        java.sql.Date date = new java.sql.Date(utilDate.getTime());
        System.out.println(date);
    }

    /**
     * 三天打鱼两天晒网 1990-01-01开始这个周期, 求xxxx-xx-xx是打鱼还是晒网
     * 1.确定今天距离1990-01-01 隔了多少天
     * (date1.getTime()- date2.getTime())/(1000 * 3600 * 24) +1
     * 2.五天一个周期
     * days%5
     * 1,2,3  打鱼
     * 4,0 晒网
     */
    @Test
    public void testFinshDate() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date dateOne = simpleDateFormat.parse("1990-01-01 22:00:00");
        Date dateTwo = simpleDateFormat.parse("1990-01-02 21:00:00");
        int days = (int) ((dateTwo.getTime() - dateOne.getTime()) / (1000 * 3600 * 24)) + 1;
        switch (days%5) {
            case 1:
            case 2:
            case 3:
                System.out.println("今天打鱼");
                break;
            case 4:
            case 0:
                System.out.println("今天晒网");
                break;
            default:
                System.out.println("error");
        }
    }

    /**
     * Calendar
     */
    @Test
    public void test4() {
        // 1.实例化
        // 方式一: 创建子类对象 (GregorianCalendar)
        Calendar calendar = new GregorianCalendar();
        // 方式二: 调用Calendar.getInstance()
        Calendar instance = Calendar.getInstance();
        // class java.util.GregorianCalendar
        System.out.println(instance.getClass());

        // 2.常用方法
        // get()
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        // set()
        calendar.set(Calendar.DAY_OF_MONTH, 22);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        // add()
        // getTime()
        System.out.println(calendar.getTime());
        // setTime()
        Date date = new Date();
        calendar.setTime(date);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        System.out.println("====================");
        System.out.println(calendar.get(Calendar.YEAR));
        // 9 (获取月份是   一月对应0, 10月对应9)
        System.out.println(calendar.get(Calendar.MONTH));
        // 1(获取星期时, 周日是 1, 周一是 2,周六是7 )
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
    }
}
