package javarush.task.task04.task0402;

/*
Цена яблок
 */

public class Solution {
    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.addPrice(50);                                  // вызов метода addPrice
        Apple apple2 = new Apple();
        apple2.addPrice(100);                               // вызов метода addPrice
        System.out.println("Стоимость яблок " + Apple.applePrice);

    }

    public static class Apple {
        public static int applePrice = 0;

        public static void addPrice(int applesPrice) {
         // здесь введенное значение аргумента должно прибавляться к статической переменной !!!
            // или переобределять значение статической переменной класса applePrice!!!

            // строка вывода
            Apple.applePrice = Apple.applePrice + applesPrice;
            String s1 = "Привет";
        }

    }
}