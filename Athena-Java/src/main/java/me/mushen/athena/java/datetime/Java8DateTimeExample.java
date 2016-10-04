package me.mushen.athena.java.datetime;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-09-19
 */
public class Java8DateTimeExample {

    public static void main(String[] args){
        // 1. LocalDate类: 它只包含日期, 没有时间
        LocalDate today = LocalDate.now();
        System.out.println("Today's Local data: " + today);
        System.out.println("Max Day: " + LocalDate.MAX + "\t Min Day: " + LocalDate.MIN);
        // 2. 获取年, 月, 日
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        today.getMonth();
        System.out.println("Today's Year: " + year + "\tMonth: " + month + "\tDay Of Month: " + day);
        // 3. 工厂方法LocalDate.of(), 可以创建出任意一个日期, 它接受年月日的参数, 然后返回一个等价的LocalDate实例
        LocalDate birthday = LocalDate.of(1989, Month.JANUARY, 15);
        System.out.println("My Birthday: " + birthday);
        // 4. 检查两个日期是否相等, 直接使用equals()方法
        if(LocalDate.of(2016, Month.SEPTEMBER, 19).equals(LocalDate.now())){
            System.out.println(LocalDate.of(2016, Month.SEPTEMBER, 19) + " equals today: True");
        }else{
            System.out.println(LocalDate.of(2016, Month.SEPTEMBER, 19) + " equals today: False");
        }
        // 5. MonthDay类, 由月日组合, 不包含年信息, 可以用它来代表每年重复出现的一些日子, 不可变且线程安全的。
        MonthDay birthdayMonthDay = MonthDay.of(birthday.getMonth(), birthday.getDayOfMonth());
        MonthDay todayMonthDay = MonthDay.now();
        MonthDay birthdayMonthDay1 = MonthDay.from(birthday);
        MonthDay todayMonthDay1 = MonthDay.from(today);
        System.out.println("birthday MonthDay: " + birthdayMonthDay);
        System.out.println("today MonthDay: " + todayMonthDay);
        System.out.println("birthday MonthDay1: " + birthdayMonthDay1);
        System.out.println("today MonthDay1: " + todayMonthDay1);
        // 6. LocalTime类: 没有日期的时间, 与LocalDate是近亲, LocalTime是不可变的。
        // 静态工厂方法now()来获取当前时间, 默认的格式是hh:mm:ss:nnn, 这里的nnn是纳秒
        LocalTime nowTime = LocalTime.now();
        System.out.println("local time now: " + nowTime);
        // 7. 增加/减少时间里面的小时数
        LocalTime timePlus1Hour = nowTime.plusHours(1);
        LocalTime timeMinus1Hour = nowTime.minusHours(1);
        System.out.println("after 1 hour: " + timePlus1Hour);
        System.out.println("before 1 hour: " + timeMinus1Hour);
        // 8. 获取一周后的日期
        LocalDate oneWeekAfterToday = today.plusWeeks(1);
        LocalDate oneWeekAfterToday2 = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("today: " + today);
        System.out.println("one week after today: " + oneWeekAfterToday);
        System.out.println("one week after today: " + oneWeekAfterToday2);
        // 9. Java 8中使用时钟
        // Returns the current time based on your system clock and set to UTC.
        Clock clock = Clock.systemUTC();
        System.out.println("clock: " + clock);
        // Returns time based on system clock zone
        Clock defaultClock = Clock.systemDefaultZone();
        System.out.println("default clock: " + defaultClock);

        // 13. 表示固定的日期
    }
}
