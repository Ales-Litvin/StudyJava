package by.epam.learn.multithread;

public class PriorityDemo {
    public static void main(String[] args) {
        Thread talk = new Thread(new TalkThread());
        WalkThread walk = new WalkThread();

        talk.setPriority(Thread.MAX_PRIORITY);
        walk.setPriority(Thread.MIN_PRIORITY);

        talk.start();
        walk.start();
    }
}
