package by.epam.learn.multithread.tasks.maintask.task01;

import by.epam.learn.multithread.tasks.maintask.Port;

import java.util.concurrent.TimeUnit;

public class PrintInfo extends Thread{

    private final Port port;
    private final Tunnel tunnel;

    public PrintInfo(Port port, Tunnel tunnel) {
        this.port = port;
        this.tunnel = tunnel;
        this.setDaemon(true);
    }

    @Override
    public void run() {
        try {
            while (!interrupted()){
                TimeUnit.SECONDS.sleep(2);
                System.out.println(port.getInfo() + tunnel.getInfo());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
