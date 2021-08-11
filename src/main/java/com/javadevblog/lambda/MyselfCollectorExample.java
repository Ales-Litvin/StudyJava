package com.javadevblog.lambda;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyselfCollectorExample {
    /*
     Collector<Тип_источника, Тип_аккумулятора, Тип_результата> collector = Collector.of(
     метод_инициализации_аккумулятора,
     метод_обработки_каждого_элемента,
     метод_соединения_двух_аккумуляторов,
     [метод_последней_обработки_аккумулятора];
     */

    public static void main(String[] args) {
        String[] strings = new String[]{"a", "b", "c","d","e","f","g"};

        StringBuilder b = new StringBuilder(); // метод_инициализации_аккумулятора
        for (String s : strings) {
            b.append(s).append(" , ");  // метод_обработки_каждого_элемента,
        }

        String joinBuilderOld = b.toString(); // метод_последней_обработки_аккумулятора

        joinBuilderOld = Stream.of(strings).collect(Collector.of(
                StringBuilder::new, // метод_инициализации_аккумулятора
                (b0, s) -> b0.append(s).append(" , "), // метод_обработки_каждого_элемента,
                (b1, b2) -> b1.append(b2).append(" , "), // метод_соединения_двух_аккумуляторов,
                StringBuilder::toString // метод_последней_обработки_аккумулятора
        ));


    }
}
