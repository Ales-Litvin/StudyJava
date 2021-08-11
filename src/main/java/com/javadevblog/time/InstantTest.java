package com.javadevblog.time;

import java.time.Duration;
import java.time.Instant;

public class InstantTest {
    public static void main(String[] args) {
        // Current mark of times
        Instant timestamp = Instant.now();
        System.out.println("Current mark of times: " + timestamp);

        // Instant for timestamp
        Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
        System.out.println("Instant для timestamp : " + specificTime);

        // Example using of Duration
        Duration sixtyDay = Duration.ofDays(60);
        System.out.println(sixtyDay);
    }
}