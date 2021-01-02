package by.epam.introduction_to_java.programming_with_classes_4.simplest_classes_and_objects.task09;

/*
 * Условие задачи:
 * 9. Создать класс  Book, спецификация которого приведена ниже. Определить конструкторы,  set-  и  get-  методы и
 * метод   toString().  Создать  второй  класс,  агрегирующий  массив  типа  Book,  с  подходящими  конструкторами  и
 * методами. Задать критерии выбора данных и вывести эти данные на консоль.
 * Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
 *
 * Найти и вывести:
 * a) список книг заданного автора;
 * b) список книг, выпущенных заданным издательством;
 * c) список книг, выпущенных после заданного года.
 */

import by.epam.introduction_to_java.programming_with_classes_4.simplest_classes_and_objects.task08.Helper;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Solution {
    public static void main(String[] args) {

        Library library = new Library();

        library.add(new Book(
                (int) Helper.generateRandomNumber(9),
                "All Quiet on the Western Front",
                "Erich Maria Remarque",
                "ATLANTIC BOOKS",
                new GregorianCalendar(1995,Calendar.DECEMBER,1),
                295,
                10.75d,
                Binding.PAMPHLET

        ));

        library.add(new Book(
                (int) Helper.generateRandomNumber(9),
                "Three Comrades",
                "Erich Maria Remarque",
                "Brown and Company",
                new GregorianCalendar(1936, Calendar.DECEMBER, 1),
                496,
                14.26d,
                Binding.PERFECT
                ));

        library.add(new Book(
                (int) Helper.generateRandomNumber(9),
                "The Catcher in the Rye",
                "J.D. Salinger's",
                "Back Bay Books",
                new GregorianCalendar(2001, Calendar.JANUARY, 30),
                288,
                8.37d,
                Binding.PERFECT
        ));

        // выведем список книг заданного автора
        System.out.println(library.getBooksByAuthor("J.D. Salinger's"));

        System.out.println("==================");

        // выведем список книг заданного издательства
        System.out.println(library.getBooksByPublishingHouse("Brown and Company"));

        System.out.println("==================");

        // ввыдем список книг после заданного года
        System.out.println(library.getBooksFromYear(new GregorianCalendar(1990, Calendar.JANUARY, 1)));
    }
}
