package com.javadevblog.time;

import java.time.*;

public class LocalDateTimeTest {
    public static void main(String[] args) {

        // Getting current time
        LocalDateTime today = LocalDateTime.now();
        System.out.println("Getting current time : " + today);

        // Creating new date with help LocalDate and LocalTime
        today = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println("DateTime : " + today);

        // Creating LocalDateTime with arguments
        // year, month, day, hours, minutes, seconds
        LocalDateTime randDate = LocalDateTime.of(2017, Month.JULY, 9, 11, 6, 22);
        System.out.println("LocalDateTime with giving date: " + randDate);

        // Getting date in 2000 seconds before 01.01.1970
        LocalDateTime dateFromBase = LocalDateTime.ofEpochSecond(2000, 0, ZoneOffset.UTC);
        System.out.println("In 2000 seconds before 01.01.1970 : " + dateFromBase);

    }

}