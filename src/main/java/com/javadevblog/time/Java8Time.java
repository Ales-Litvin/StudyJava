package com.javadevblog.time;

import java.time.LocalDate;
import java.time.Month;

public class Java8Time {
    public static void main(String[] args) {
        // Gets current date
        LocalDate today = LocalDate.now();
        System.out.println("Current date: " + today);

        // Create a LocalDate with arguments year, month, day
        LocalDate specificDate = LocalDate.of(2017, Month.DECEMBER, 30);
        System.out.println("Date with year, month and day: " + specificDate);

        // Create wrong date:
        //LocalDate invDate = LocalDate.of(2014, Month.JULY, 33);
        // We got java.time.DateTimeException:
        //Invalid value for DayOfMonth (valid values 1 - 28/31): 33

        // Get date, example 01.01.1970
        LocalDate dateFromBase = LocalDate.ofEpochDay(365);
        System.out.println("Date starts : " + dateFromBase);

        LocalDate day256_2017 = LocalDate.ofYearDay(2014, 256);
        System.out.println("256 day 2017 : " + day256_2017);
    }
}
