package by_epam.introduction_to_java.basics_of_OOP_5.task03;

import java.util.Date;

/*
 * Условие задачи:
 * Задача 3.
 * Создать класс Календарь с внутренним классом,
 * с помощью объектов которого можно хранить информацию о выходных и праздничных днях.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println("Создаем объект календарь");
        Calendar calendar = new Calendar();

        System.out.println("Добавим несколько событий");
        calendar.add("Friend's birthday", null, new Date());
        calendar.add("Girlfriend's birthday",
                "You need congratulate",
                new Date(1995, java.util.Calendar.APRIL,15));

        System.out.println(calendar);

        System.out.println("Получим событие по названию");
        Calendar.Event event = calendar.getEvent("Friend's birthday");

        System.out.println(event);
    }
}
