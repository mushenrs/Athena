package me.mushen.athena.java.datetime;

import java.util.concurrent.TimeUnit;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-09-01
 */
public class DateTimeExample {

    public static void main(String[] args) throws InterruptedException {
        DateTimeExample example = new DateTimeExample();
        // System.currentTimeMillis()
        example.currentTimeMillisExample();
        example.timerExaple();
        // java.util.Date
        example.utilDateExample();
        // java.sql.Date
        example.sqlDateExample();
        // java.sql.Timestamp
        example.sqlTimestampExample();
    }

    private void currentTimeMillisExample(){
        // 从1970年1月1日到现在的总毫秒数, 返回类型为long。
        // 可以用于初始化java.util.Date、java.sql.Date、java.sql.Timestamp和java.util.GregorianCalendar对象。
        long timeNow;
        for(int printT = 1; printT <= 100; printT++){
            timeNow = System.currentTimeMillis();
            System.out.println("print: " + printT + ", time now: " + timeNow);
        }
    }

    private void timerExaple(){
        Timer timer = new Timer();
        timer.start();
        currentTimeMillisExample();
        timer.end();
        System.out.println(timer.totalTime());
    }

    // java.util.Date中的大部分方法已经不推荐使用, 应该使用新的Date Time API, 原因是新的API是由三个核心理念驱动的:
    // 1.不可变类。在现有的Java格式化器有一个致命的缺陷，那就是他们不是线程安全的。
    // 2.领域驱动设计。新的API模型的领域是非常精确的，这些类为date和time描绘了不同的使用情况。
    // 3.年代表的分离。为了支持这世界上某些地区的使用者的需要（比如日本、泰国，不需要遵循国际标准ISO-8601），新的API允许人们使用不同的日历系统。
    private void utilDateExample() throws InterruptedException {
        // public Date(){}
        java.util.Date date = new java.util.Date();
        // public Date(long){}
        java.util.Date date0 = new java.util.Date(date.getTime());
        System.out.println("Now: " + date.getTime());
        System.out.println("Now: " + date0);

        java.util.Date date1 = new java.util.Date();
        TimeUnit.SECONDS.sleep(1);
        java.util.Date date2 = new java.util.Date();
        // 一个int类型的大于0的值，如果某个date（该date的compareTo()方法被调用）晚于作为compareTo()方法参数的date。
        // 一个int类型的等于0的值，如果某个date（该date的compareTo()方法被调用）等于作为compareTo()方法参数的date。
        // 一个int类型的小于0的值，如果某个date（该date的compareTo()方法被调用）早于作为compareTo()方法参数的date。
        int comparison = date1.compareTo(date2);
        System.out.println("Comparison: " + comparison);
        // java.util.Date还拥有两个比较时间的简写方法, 分别是before方法和after方法。
        boolean isBefore = date1.before(date2);
        boolean isAfter = date1.after(date2);
        System.out.println("date1 is before date2: " + isBefore);
        System.out.println("date1 is after date2: " + isAfter);
    }

    // java.sql.Date类用于在java.sql.PreparedStatement上设置日期或者从java.sql.ResultSet获取日期。
    // java.sql.Date继承于java.util.Date。
    // java.sql.Date和java.util.Date最大的不同在于java.sql.Date所表示的日期中只保留了日期，而没有时间。
    // 如果需要保留时间，使用java.sql.Timestamp来代替java.sql.Date。
    private void sqlDateExample(){
        long time = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(time);
        System.out.println(date); // 2016-09-02
    }

    // java.sql.Timestamp类用于在java.sql.PreparedStatement上设置日期+时间或者从java.sql.ResultSet获取日期+时间。
    // java.sql.Timestamp继承于java.util.Date。
    // java.sql.Timestamp中有一点与它的父类java.util.Date不同的是，它能够保存日期的总纳秒数。
    // 使用getNanos()和setNanos()来获取和设置总纳秒数。
    private void sqlTimestampExample(){

    }
}
