package com.github.yanzheshi.jdk8.timeanddate;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.TimeZone;

/**
 * @author shiyanzhe
 * @date 2019/1/17
 */
public class InstantTest {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        Timestamp timestamp = Timestamp.valueOf(localDateTime);

        System.out.println(timestamp.getTime());
        System.out.println(timestamp.getNanos());



        long currentTimeMillis = System.currentTimeMillis();

        int currentDate = (int)((currentTimeMillis/(1000*3600*24)*(1000*3600*24) - TimeZone.getDefault().getRawOffset()) / 1000);

        System.out.println(currentDate);

    }


}
