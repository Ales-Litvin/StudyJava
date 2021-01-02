package by.epam.learn.multithread;

public class DaemonDemo {
    public static void main(String[] args) {
        Thread talk = new Thread(new TalkThread());
        WalkThread walk = new WalkThread();

        talk.setDaemon(true);

        talk.start();
        walk.start();

        System.out.println("end of main");
    }
}
