package com.habr.lambda.peopleexample;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

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


    }
}
