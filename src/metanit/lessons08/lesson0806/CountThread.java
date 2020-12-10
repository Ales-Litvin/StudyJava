package metanit.lessons08.lesson0806;

import java.util.concurrent.Semaphore;

class CountThread implements Runnable {

    CommonResource resource;
    Semaphore sem;
    String name;

    CountThread(CommonResource resource, Semaphore sem, String name) {
        this.resource = resource;
        this.sem = sem;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " ождает резрешение");
        try {
            sem.acquire();
            resource.x = 1;
            for (int i = 1; i < 5; i++) {
                System.out.println(this.name + ": " + resource.x);
                resource.x++;
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(name + " освобождает разрешение");
        sem.release();
    }
}
