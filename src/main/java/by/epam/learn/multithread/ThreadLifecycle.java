package by.epam.learn.multithread;

public class ThreadLifecycle {
    public static void main(String[] args) throws InterruptedException {
        Lighter lighter = new Lighter();

        Thread bomb1 = new Thread(new Bomb(lighter), "Bomb one ");
        Thread bomb2 = new Thread(new Bomb(lighter), "Bomb two ");

        System.out.println(bomb1.getName() + bomb1.getState()); // NEW
        System.out.println(bomb2.getName() + bomb2.getState()); // NEW

        bomb1.start();
        bomb2.start();
        System.out.println(bomb1.getName() + bomb1.getState());
        System.out.println(bomb2.getName() + bomb2.getState());

        Thread.sleep(1000);
        System.out.println(bomb1.getName() + bomb1.getState());
        System.out.println(bomb2.getName() + bomb2.getState());

        Thread.sleep(5000);
        System.out.println(bomb1.getName() + bomb1.getState());
        System.out.println(bomb2.getName() + bomb2.getState());

        Thread.sleep(5000);
        System.out.println(bomb1.getName() + bomb1.getState());
        System.out.println(bomb2.getName() + bomb2.getState());
    }


    static class Bomb implements Runnable {
        Lighter lighter;

        public Bomb(Lighter lighter) {
            this.lighter = lighter;
        }

        @Override
        public void run() {
            if (lighter.getLighter()) {
                for (int i = 5; i > 0; --i) {

                    System.out.println(i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Boom!");
            }
        }
    }

    static class Lighter {
        boolean isFree = true;

        synchronized boolean getLighter() {
            try {
                while (!isFree) {
                    wait();
                }

                System.out.println(Thread.currentThread().getName() + "get fire");
                isFree = true;
                notifyAll();

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }
    }
}
