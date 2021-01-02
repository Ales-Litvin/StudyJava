package by.epam.learn.multithread;

public class TalkThread implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 7; i++) {
                System.out.println("Talk " + i);

                Thread.sleep(700);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("end of talk thread");
        }
    }
}
