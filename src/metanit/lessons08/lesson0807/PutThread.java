package metanit.lessons08.lesson0807;

import java.util.concurrent.Exchanger;

class PutThread implements Runnable {

    Exchanger<String> exchanger;
    String message;

    PutThread(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        this.message = "Hello Java!";
    }

    @Override
    public void run() {

        try {
            message = exchanger.exchange(message);
            System.out.println("PutThread has received: " + message);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
