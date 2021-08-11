package com.javadevblog.lambda;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JustLambdaDemo {
    public static void main(String[] args) {
        Stream.of("aa1", "aa2", "ca", "av").findFirst().ifPresent(System.out::println);

        IntStream.of(8, 12, 48, 65, 15).forEach(System.out::println);

        Arrays.stream(new int[] {1, 2, 3})
                .map(n -> 2 * n + 1)
                .average().ifPresent(System.out::println);

        Stream.of("a1", "a2", "c4", "a5")
                .map(s -> s.substring(1))
                .mapToInt(Integer::parseInt) // преобразование в int поток
                .max()
                .ifPresent(System.out::println);

        IntStream.of(1, 4, 6)
                .mapToObj(i -> "c" + i) // преобразование к Object
                .forEach(System.out::println);

        Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
                .filter(s -> {
                    // промежуточные операции выполняются при наличии терминальной
                    System.out.println("Filter: " + s);
                    return true;
                })
                .forEach(o -> System.out.println("For each: " + o));

        Stream.of("dd2", "Aa2", "bb1", "bb3", "cc4")
                .map(s -> {
                    // промежуточные операции выполняются при наличии терминальной
                    System.out.println("Filter: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMath: " + s);
                    return s.startsWith("A");
                });

        // Терминальные операци закрываю поток


    }
}
