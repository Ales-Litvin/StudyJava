package com.habr.lambda.peopleexample;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        List<People> peoples = Arrays.asList(
                new People("Вася", 16, Sex.MAN),
                new People("Петя", 23, Sex.MAN),
                new People("Елена", 42, Sex.WOMEN),
                new People("Иван Иванович", 69, Sex.MAN));

        List<People> militaryPeoples = peoples.stream()
                .filter(p -> p.getAge() >= 18
                        && p.getAge() <= 27
                        && p.getSex() == Sex.MAN)
                .collect(Collectors.toList());

        System.out.println(militaryPeoples);

        double averageAge = peoples.stream()
                .filter(p -> p.getSex() == Sex.MAN)
                .mapToInt(People::getAge).average().getAsDouble();

        long amountOfWorksPeople = peoples.stream()
                .filter(p -> p.getAge() >= 18 &&
                        ((p.getSex() == Sex.MAN && p.getAge() <= 60) ||
                                p.getSex() == Sex.WOMEN && p.getAge() <= 55))
                .count();

        Collection ordered = Arrays.asList("a1", "a2", "a2", "a3", "a1", "a2", "a2");
        Collection nonOrdered = new HashSet<>(ordered);

        List<String> strings = Arrays.asList("a1", "a2", "a3", "a1");

        strings.stream().anyMatch("a1"::equals);
        strings.stream().allMatch(s -> s.contains("1"));
        strings.stream().noneMatch(s -> !s.equals("a7"));


        Collection collection1 = Arrays.asList("a1", "a2", "a3", "a1");

        Collection collection2 = Arrays.asList("1,2,0", "4,5");

        collection1.parallelStream().forEach(s -> s.toString());

        Stream.of("3", "4", "5")
                .map(Integer::parseInt)
                .map(x -> x + 10)
                .forEach(System.out::println);

        Stream.of(2, 3, 0, 1, 3)
                .flatMapToInt(x -> IntStream.range(0, x))
                .forEach(System.out::println);

        Stream.of(0, 3, 0, 0, 5)
                .peek(x -> System.out.format("before distinct: %d%n", x))
                .distinct()
                .peek(x -> System.out.format("after distinct: %d%n", x))
                .map(x -> x * x)
                .forEach(x -> System.out.format("after map: %d%n", x));

        Stream.of(120, 410, 85, 32, 314, 12)
                .forEach(x -> System.out.format("%s, ", x));

        List<Integer> list = Stream.of(1, 2, 3)
                .collect(Collectors.toList());

        List<String> list2 = Stream.of("a", "b", "c", "d")
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        int sum = Stream.of(1, 2, 3, 4, 5)
                .reduce(10, (acc, x) -> acc + x);

        Optional<Integer> sum2 = Stream.of(1, 2, 3, 4, 5)
                .reduce((acc, x) -> acc + x);
        System.out.println(sum2.get());

        boolean result = Stream.of(1, 2, 3, 4, 5)
                .allMatch(x -> x <= 7);

        LongSummaryStatistics stats = LongStream.range(2, 16)
                .summaryStatistics();

        Map<Integer, String> map5 = Stream.of(50, 55, 69, 20, 19, 52)
                .collect(Collectors.toMap(
                        i -> i % 5,
                        i -> String.format("<%d>", i),
                        (a, b) -> String.join(", ", a, b),
                        LinkedHashMap::new
                ));

        String s3 = Stream.of(1, 2, 3, 4, 5, 6)
                .collect(Collectors.reducing(
                        "", x -> Integer.toString(x), (a, b) -> a + b
                ));


    }
}
