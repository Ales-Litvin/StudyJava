package metanit.lesson08.lesson0807;

import java.util.concurrent.Exchanger;

class GetThread implements Runnable{

    Exchanger<String> exchanger;
    String message;

    GetThread(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            message = exchanger.exchange(message);
            System.out.println("GetThread has received: " + message);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
