package multithreading.uncaughtexceptionhandler;

public class UncaughtExceptionHandlerExample implements Runnable {

    private final int TIMER = 3;

    @Override
    public void run() {
        for (int i = TIMER; i > 0; i--) {
            System.out.println(i);
        }
        System.out.println("Throw exception");
        throw new RuntimeException("Bomb exception");
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("EX 1 ======================");
        ThreadGroup threadGroupOne = new ThreadGroup("ThreadGroupOne");
        threadGroupOne.enumerate(new Thread[]{new Thread(new UncaughtExceptionHandlerExample())});
        Thread bombThread = new Thread(new UncaughtExceptionHandlerExample());
        Thread.setDefaultUncaughtExceptionHandler((t, e) ->
                System.out.println("I catch " + e.getMessage()));
        System.out.println(Thread.getDefaultUncaughtExceptionHandler());
        bombThread.start();
        bombThread.join();

        System.out.println("EX 2 ======================");
        Thread bombThreadTwo = new Thread(new UncaughtExceptionHandlerExample());
        Thread.setDefaultUncaughtExceptionHandler(null);
        System.out.println(Thread.getDefaultUncaughtExceptionHandler());
        bombThreadTwo.start();
    }
}
