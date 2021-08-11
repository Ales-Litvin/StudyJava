package javarush.task.task19.task1911;

/*
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        // запоминаем настоящий PrintStream в специальную переменную
        PrintStream consoleStream = System.out;

        // создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // Создаем адапетер к класс PrintStream
        PrintStream stream = new PrintStream(outputStream);

        // Устанавилваем его как текущий System.out
        System.setOut(stream);

        // Вызываем функцию которая каписывает данные в outputStream массив байт
        testString.printSomething();

        // Преобразуем записнные в наш ByteArray данные в строку
        String result = outputStream.toString();

        // Возвращаем все как было
        System.setOut(consoleStream);

        // Изменяем регистр весех символов в строку
        String resultToUpperCase = result.toUpperCase();

        // Выводим строку в консоль
        System.out.print(resultToUpperCase);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}