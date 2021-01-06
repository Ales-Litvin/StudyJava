package com.javadevblog.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamToMapExample {
    public static void main(String[] args) {

              Map<Integer, String> map = Arrays.asList("a1", "a2", "b1", "c2", "c1")
                        .stream()
                        .collect(Collectors.groupingBy(
                                p -> Integer.parseInt(p.substring(1,2)),
                                Collector.of(
                                        StringBuilder::new,
                                        (b, s) -> b.append(s).append(", "),
                                        (b1, b2) -> b1.append(b2).append(", "),
                                        StringBuilder::toString
                                )));

              map.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));


    }
}
