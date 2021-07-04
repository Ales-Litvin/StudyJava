package multithreading.ru.java.online.runnable;

public class RunnableExample {
    public static void main(String[] args) {
        new MyThread();
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Главный поток: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
            Thread.currentThread().interrupt();
        }
        System.out.println("Главный поток завершён");
    }
}
