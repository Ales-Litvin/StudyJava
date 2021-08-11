package javarush.task.task19.task1912;

/*
Ридер обертка 2
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

        // Заменеяем "te" на "??"
        String resultReplace = result.replaceAll("te", "??");

        // Выводим строку в консоль
        System.out.print(resultReplace);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}