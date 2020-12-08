package metanit.lesson08.lesson0804;

public class Main {
    public static void main(String[] args) {

        System.out.println("Main thread started...");
        MyThread myThread = new MyThread();
        new Thread(myThread, "MyThread").start();

        try {
            Thread.sleep(1100);

            myThread.disable();

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }
        System.out.println("Main thread finished...");
    }
}
