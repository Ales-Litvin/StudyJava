package by.epam.introduction_to_java.programming_with_classes_4.simplest_classes_and_objects.task10;

/*
 * Условие задачи:
 * 10. Создать класс Airline, спецификация которого приведена ниже. Определить
 * конструкторы,  set- и get- методы и метод  toString(). Создать второй класс,
 * агрегирующий массив типа  Airline, с подходящими конструкторами и методами.
 * Задать критерии выбора данных и вывести эти данные на консоль.
 * Airline: пункт назначения, номер рейса, тип самолета, время вылета,
 * дни недели.
 * Найти и вывести:
 * a) список рейсов для заданного пункта назначения;
 * b) список рейсов для заданного дня недели;
 * c) список рейсов для заданного дня недели, время вылета для которых больше
 *    заданного.
 */

import by.epam.introduction_to_java.programming_with_classes_4.simplest_classes_and_objects.task06.Time;

import java.time.DayOfWeek;

public class Solution {
    public static void main(String[] args) {
        Airport airport = new Airport();

        airport.add(new Airline("London",
                113,
                AircraftType.A300,
                new Time(14, 0,0),
                DayOfWeek.FRIDAY
                ));

        airport.add(new Airline("Berlin",
                120,
                AircraftType.A220,
                new Time(6, 45,0),
                new DayOfWeek[]{DayOfWeek.FRIDAY,
                        DayOfWeek.MONDAY,
                        DayOfWeek.SATURDAY}
        ));

        airport.add(new Airline("Moscow",
                330,
                AircraftType.A220,
                new Time(4, 30,0),
                new DayOfWeek[]{DayOfWeek.FRIDAY,
                        DayOfWeek.WEDNESDAY,
                        DayOfWeek.SATURDAY}
        ));

        // список рейсов для заданного пункта назначения
        System.out.println(airport.getAirlinesForDestination("Berlin"));

        System.out.println("=========================");

        // список рейсов для заданного дня недели
        System.out.println(airport.getAirlinesForDay(DayOfWeek.FRIDAY));

        System.out.println("=========================");

        // список рейсов для заданного дня недели, время вылета для которых
        // больше заданного
        System.out.println(airport.getAirlinesForDayAndTime(
                DayOfWeek.FRIDAY,
                new Time(13,0,0)));

    }
}
