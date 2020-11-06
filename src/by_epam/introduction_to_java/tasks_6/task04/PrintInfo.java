package by_epam.introduction_to_java.tasks_6.task04;

// Prints information to console.
public class PrintInfo extends Thread{

    private final Port port;
    private final Tunnel tunnel;

    public PrintInfo(Port port, Tunnel tunnel) {
        this.port = port;
        this.tunnel = tunnel;
    }

    @Override
    public void run() {
        int count = 5;
        while (count > 0){
           tunnel.printInfo();
           port.printInfo();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            count--;
        }
    }
}
