package by.epam.learn.multithread;

public class WalkThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 7; i++) {
                System.out.println("Walk " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("end of walk thread");
        }
    }
}
