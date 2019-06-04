package com.github.yanzheshi.jdk8.timeanddate;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * LocalDate, LocalTime, LocalDateTime
 * LocalDateTime 是 LocalDate和LocalTime的组合
 * @author shiyanzhe
 * @date 2019/1/17
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
        testParseDateTime();
    }

    /**
     * 可以整体输出，分开输出或格式化输出
     */
    public static void testFormat() {
        LocalDate dateOfToday = LocalDate.now();
        // 可以整体输出 YYYY-MM-DD 也可以分开输出
        System.out.println("date of today: " + dateOfToday);

        LocalTime currentTime = LocalTime.now();
        // 可以整体输出 hh:mm:ss.SSSSSSSS 也可以分开输出
        System.out.println("currentTime: " + currentTime);

        // 格式化
        // 线程安全  SimpleDateFormat线程不安全
        String format = currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println(format);

    }

    /**
     * 日期转化
     */
    public static void testDateParse() {
        LocalDate localDate = LocalDate.ofEpochDay(Instant.now().getEpochSecond() / 60 / 60 / 24);
        System.out.println(localDate);

        LocalDate day = LocalDate.of(2019, 1, 31);
        System.out.println(day);


        // 如果日期非法， 返回DateTimeException
        //System.out.println(LocalDate.of(2019, 2, 29));

        LocalDate today = LocalDate.now();
        System.out.println("today: " + today);

        // 可以通过 plus 或 minus对日期计算
        System.out.println("yesterday: " + today.minusDays(1));
        System.out.println("tomorrow: " + today.minusDays(-1));
        System.out.println("nextWeekDay: " + today.plusWeeks(1));
        System.out.println("nextYearDay: " + today.plusYears(1));
        // 如果累加后超过那月最大天数，返回那个月最后一天
        System.out.println("nextMonthDay: " + day.plusMonths(1));
        System.out.println("nextMonthDay: " + LocalDate.of(2020, 2, 29).plusYears(1));
    }

    public static void testParseDateTime() {
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(1550246400, 0, ZoneOffset.ofHours(8));

        System.out.println(localDateTime);
        System.out.println(localDateTime.getHour());
    }

    /**
     * 日期比较
     */
    public static void testDateCompare() {
        LocalDate day1 = LocalDate.now();
        LocalDate day2 = LocalDate.of(2019, 1, 20);
        System.out.println("campare: " + day1.compareTo(day2));

        // 只比较月和日
        MonthDay monthDay = MonthDay.of(day1.getMonthValue(), day1.getDayOfMonth());
        MonthDay nationalDay = MonthDay.of(10, 1);
        if (Objects.equals(monthDay, nationalDay)) {
            System.out.println("Today is National Day!");
        } else {
            System.out.println("Today is not National Day.");
        }

    }


}
