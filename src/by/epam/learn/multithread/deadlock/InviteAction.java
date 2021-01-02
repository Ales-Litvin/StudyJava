package by.epam.learn.multithread.deadlock;

import java.util.concurrent.TimeUnit;

public class InviteAction {
    private String name;

    public InviteAction(String name) {
        this.name = name;
    }

    public synchronized void invite(InviteAction obj){
        System.out.println(name + " invites " + obj.name.toUpperCase());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        obj.action();
    }

    public synchronized void action(){
        System.out.println(name + " action");
    }
}
