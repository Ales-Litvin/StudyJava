package com.javadevblog.time;

import java.time.LocalTime;

public class LocalTimeTest {
    public static void main(String[] args) {
        // Getting current time
        LocalTime time = LocalTime.now();
        System.out.println("Getting current time: " + time);

        // Creating LocalTime with using our data how parameters
        LocalTime specificTime = LocalTime.of(23, 15,11, 22);
        System.out.println("What time of days: " + specificTime);

        // Getting data in 2000 seconds before 01.01.1970
        LocalTime sec2000 = LocalTime.ofSecondOfDay(10000);
        System.out.println("In 2000 seconds before 01.01.1970: " + sec2000);
    }
}
