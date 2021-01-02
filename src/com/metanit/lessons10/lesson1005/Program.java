package com.metanit.lessons10.lesson1005;

import java.util.Optional;
import java.util.stream.Stream;

public class Program {
    public static void main(String[] args) {
        Stream<Integer> numbersStream = Stream.of(1, 2, 3, 4, 5, 6);
        Optional<Integer> result = numbersStream.reduce((x, y) -> x * y);
        System.out.println(result.get()); // 720

        String string = Stream.of("I", "like", "study")
                .reduce((x,y) -> x + " " + y)
                .get();

        System.out.println(string);

    }
}
