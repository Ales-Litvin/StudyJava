package javarush.task.task19.task1927;

/*
В методе learn.main подмени объект System.out написанной тобой реадер-оберткой.
Твоя реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а.
Вызови готовый метод printSomething(), воспользуйся testString.
Верни переменной System.out первоначальный поток.

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
 */

/*
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution_rev2 {
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
        String result = "";
        int stringCount = 0;
        for (String string : outputStream.toString().split("\n")){
            if (stringCount != 2){
                result = result.concat(string + "\n");
                stringCount++;
            }
            else{
                result = result.concat("JavaRush - курсы Java онлайн" + "\n");
                result = result.concat(string + "\n");
                stringCount = 1;
            }
        }

        // Возвращаем все как было
        System.setOut(consoleStream);

        // Выводим строку в консоль
        System.out.print(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}