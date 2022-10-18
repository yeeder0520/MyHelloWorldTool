package com;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/9/7 下午 02:15
 **/
public class TestLocalDate {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2022, 8, 26);

        while (localDate.isBefore(LocalDate.of(2022, 10, 3))){
            localDate = localDate.plusDays(1);
            String yyyyMMdd = localDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"))+"0000";
            System.out.println("qingmingDate = " + yyyyMMdd );
        }

    }
}
