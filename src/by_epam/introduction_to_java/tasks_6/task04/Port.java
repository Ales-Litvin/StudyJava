package by_epam.introduction_to_java.tasks_6.task04;

import java.util.ArrayList;
import java.util.List;

public class Port{

    private final List<Pier> PIERS;

    private static final int MAX_PIERS = 5;

    private static final int MAX_CAPACITY = 500;

    private int count;

    public Port(Tunnel tunnel) {
        this.PIERS = new ArrayList<>();
        for (int i = 0; i < MAX_PIERS; i++){
            PIERS.add(new Pier(tunnel, this, i));
        }
    }

    public List<Pier> getPiers() {
        return PIERS;
    }

    // returns true if can take 'containers'
    public synchronized boolean canTake(){
        return count < MAX_CAPACITY;
    }

    // returns ture if can give 'containers'
    public synchronized boolean canGive(){
        return count != 0;
    }

    public synchronized void add(int count){

        try {
            if (count < MAX_CAPACITY){
                notifyAll();
                this.count += count;

                System.out.printf("In the port '%s' containers. The port take '%s' containers. Thread: %s.\n",
                        this.count, count, Thread.currentThread().getName());
            } else {
                System.out.printf("No place, in the port '%s' containers.  Thread: %s.\n",
                        this.count, Thread.currentThread().getName());
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // returns count of unloaded products
    public synchronized int get(int count){

        try {
            if (count != 0){
                notifyAll();
                if (this.count >= count){
                    this.count -= count;
                } else {
                    count = this.count;
                    this.count = 0;
                }
                System.out.printf("In the port '%s' containers. The port give '%s' containers. Thread: %s.\n",
                        this.count, count, Thread.currentThread().getName());
                return count;
                }
                System.out.printf("No containers, in the port '%s' containers. Thread: %s.\n",
                      this.count, Thread.currentThread().getName());
                wait();

            } catch (InterruptedException e) {
            e.printStackTrace();
            }

        return 0;
    }

    // Prints information
    public String printInfo(){
        StringBuilder sb = new StringBuilder("");
        sb.append("\n\n\n");
        sb.append(Thread.currentThread().getName().toUpperCase());
        sb.append("\nPIERS: ").append(PIERS);
        sb.append("\nCOUNT: ").append(count);
        sb.append("\n");
        return sb.toString();
    }


}
