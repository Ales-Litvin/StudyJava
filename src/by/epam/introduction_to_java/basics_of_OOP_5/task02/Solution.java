package by.epam.introduction_to_java.basics_of_OOP_5.task02;

/*
 * Условие задачи:
 * Задача 2.
 * Создать класс Payment с внутренним классом,
 * с помощью объектов которого можно сформировать покупку из нескольких товаров.
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println("Создаем объекта класс Payment");
        Payment payment = new Payment();

        System.out.println("Добавим несколько товаров");
        payment.add("a car", 9999.99);
        payment.add("bread", 1.9);
        payment.add("sour cream", 1.56);
        payment.add("fish", 15.85);
        payment.add("cookies", 6.65);
        payment.add("milk", 1.99);

        System.out.println(payment);

        System.out.println("Удалим обхект 'fish'");
        payment.remove("fish");
        System.out.println(payment);

        System.out.printf("Суммарная стоимость: %.2f\n", payment.getTotalPrice());
    }
}
