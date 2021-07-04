package multithreading.ru.java.online.thread;

class Egg extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                // Приостанавливаем поток
                sleep(ChickenEgg.getTimeSleep());
                System.out.println("Яйцо");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
