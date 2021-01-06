package com.javadevblog.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class SomeLambdaExample {
    public static void main(String[] args) {
        Predicate<Integer> predicate = (i) -> i > 0;

        List<Integer> list = Arrays.asList(1, 5, 7, -5, -8, 10);
        sumWithCondition(list, predicate);


        List<String> mList = Arrays.asList("aa1", "cc2", "cc1", "aa2", "bb1");

        mList.stream().
                filter(s -> s.startsWith("a")).
                map(String::toUpperCase).
                sorted().
                forEach(System.out::println);
    }

    public static int sumWithCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.parallelStream()
                .filter(predicate)
                .mapToInt(i -> i)
                .sum();
    }
}
