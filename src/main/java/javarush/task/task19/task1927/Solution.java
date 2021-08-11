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
import java.io.OutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintWrapper printWrapper = new PrintWrapper(System.out);
        testString.printSomething();
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

    static class PrintWrapper extends PrintStream{
        private int countPrint = 0;
        private PrintStream consoleStream;

        public PrintWrapper(OutputStream out) {
            super(out);
            System.setOut(this);
            this.consoleStream = (PrintStream) out;
        }

        @Override
        public void println(String x) {
            if (countPrint != 2) {
                super.println(x);
                countPrint++;
            }
            else {
                super.println("JavaRush - курсы Java онлайн");
                super.println(x);
                countPrint = 1;
            }
        }
    }
}