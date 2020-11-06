package by_epam.introduction_to_java.tasks_6.task04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Available number of cores: " + Runtime.getRuntime().availableProcessors());

        Tunnel tunnel = new Tunnel();

        ShipGenerator shipGenerator = new ShipGenerator(tunnel, 15);

        Port port = new Port(tunnel);

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        service.execute(shipGenerator);

        for(Pier pier : port.getPiers()){
            service.execute(pier);
        }

        service.shutdown();
    }
}
