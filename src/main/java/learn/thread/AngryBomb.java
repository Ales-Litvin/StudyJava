package learn.thread;

public class AngryBomb implements Runnable{

    public static final int TIMER = 10;

    @Override
    public void run() {
        for (int i = 0; i < TIMER; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
