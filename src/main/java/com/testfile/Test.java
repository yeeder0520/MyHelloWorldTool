package com.testfile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/3/28 下午 02:47
 **/
public class Test {
    public static long period = 1000 * 60 * 20; // qry DB acpt_dts period

    public static void main(String[] args) throws ParseException {

        /*只取出 → 年 月 日 時 分 ， 最後要補上兩個0*/
        String startDataTime = "20220419" + "00";
        /*格式轉換規格 年月日時分*/
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHH");
        LocalDateTime queryParameter = LocalDateTime.parse(startDataTime, formatter);
        /*取出每個小時 → 0~23點*/
        for (int oneHour = 0; oneHour <= 23; oneHour++) {
            /*每次加一個小時當作SQL條件帶入*/
            startDataTime = formatter.format(queryParameter.plusHours(oneHour));
            System.out.println("startDataTime = " + startDataTime);
        }
    }

    /**
     * 某時段time N天後 的時間
     *
     * @param time
     * @param days
     * @return
     */
    public static String getTimeAfDays(String time, int days) {
        time += "00000000000000000".substring(time.length());
        ;
        int year = Integer.parseInt(time.substring(0, 4));
        int month = Integer.parseInt(time.substring(4, 6)) - 1;
        int day = Integer.parseInt(time.substring(6, 8));
        int hour = Integer.parseInt(time.substring(8, 10));
        int minute = Integer.parseInt(time.substring(10, 12));
        int second = Integer.parseInt(time.substring(12, 14));

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, hour, minute, second);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateTimeStamp = formatter.format(new java.util.Date(calendar.getTime().getTime() + 1000 * 60 * 60 * 24L * days));
        return dateTimeStamp;
    }
}
