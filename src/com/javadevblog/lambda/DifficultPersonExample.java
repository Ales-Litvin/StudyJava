package com.javadevblog.lambda;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DifficultPersonExample {
    public static List<Person> persons = Arrays.asList(
            new Person("Andrew", 20),
            new Person("Igor", 23),
            new Person("Ira", 23),
            new Person("Vitia", 12));

    public static void main(String[] args) {
        List<Person> filtered =
                persons.stream().filter(p -> p.name.startsWith("I"))
                        .collect(Collectors.toList());

        System.out.println(filtered);

        Map<Integer, List<Person>> personsByAge = persons
                .stream().collect(Collectors.groupingBy(p -> p.age));

        personsByAge.forEach((age, p) -> System.out.format("age %s: %s\n", age, p));

        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner(" | "), // supplier (поставщик)
                        (j, p) -> j.add(p.name.toUpperCase()), // accumulator (добовляет имя в верхнем регистре)
                        (j1, j2) -> j1.merge(j2),              // combiner (объединяет два StringJoiner)
                        StringJoiner::toString);               // finisher (строит строку)

        String names = persons.stream().collect(personNameCollector);

        System.out.println(names);

        persons
                .stream()
                .reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
                .ifPresent(System.out::println);

        Person result = persons
                .stream()
                .reduce(new Person("", 0), (p1, p2) -> {
                    p1.age += p2.age;
                    p1.name += p2.name;
                    return p1;
                });


    }

}
