package com;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/9/7 下午 02:15
 **/
public class TestLocalDate {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, -12);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Timestamp endDate = new Timestamp(calendar.getTimeInMillis());
        System.out.println("endDate = " + endDate);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.add(Calendar.DATE, -7);
        Timestamp startDate = new Timestamp(calendar.getTimeInMillis());
        System.out.println("startDate = " + startDate);

    }
}
