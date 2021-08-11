package javarush.task.task25.task2512;

/*
 * В классе Solution реализуй интерфейс UncaughtExceptionHandler, который должен:
 * 1. прервать нить, которая бросила исключение.
 * 2. вывести в консоль стек исключений, начиная с самого вложенного.
 *
 * Пример исключения:
 * new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))
 *
 * Пример вывода:
 * java.lang.IllegalAccessException: GHI
 * java.lang.RuntimeException: DEF
 * java.lang.Exception: ABC
 * */

import java.awt.*;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        printGetCause(e);
    }

    private void printGetCause(Throwable e){
        if (e.getCause() != null) printGetCause(e.getCause());
        System.out.println(e.getClass().getName() + ": " + e.getMessage());
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("DEF",
                                new IllegalArgumentException("GHI",
                                        new NumberFormatException("NFE")));
            }
        });
        thread.setUncaughtExceptionHandler(new Solution());
        thread.start();

    }
}