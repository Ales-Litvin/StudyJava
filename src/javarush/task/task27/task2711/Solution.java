package javarush.task.task27.task2711;

/*
 * Дана стандартная реализация методологии wait-notify.
 * Почитай про CountDownLatch и перепиши тело метода someMethod используя поле latch.
 * Весь лишний код удали из класса.
 */

import java.util.concurrent.CountDownLatch;

/*
CountDownLatch
*/
public class Solution {
    CountDownLatch latch = new CountDownLatch(1);

    public void someMethod() throws InterruptedException {
        latch.countDown();
        retrieveValue();
        latch.await();
    }

    void retrieveValue() {
        System.out.println("Value retrieved.");
    }

    public static void main(String[] args) {

    }
}