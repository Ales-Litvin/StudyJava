package by.epam.learn.multithread.tasks.maintask.task01;

import by.epam.learn.multithread.tasks.maintask.Pier;
import by.epam.learn.multithread.tasks.maintask.Port;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * 1. Порт. Корабли заходят в порт для разгрузки/загрузки контейнеров.
 *    Число контейнеров, находящихся в текущий момент в порту и на корабле,
 *    должно быть неотрицательным и превышающим заданную грузоподъемность судна
 *    и вместимость порта. В порту работает несколько причалов. У одного причала
 *    может стоять один корабль. Корабль может загружаться у причала,
 *    разгружаться или выполнять оба действия.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Available number of cores: "
                + Runtime.getRuntime().availableProcessors());

        Tunnel tunnel = new Tunnel();

        ShipGenerator shipGenerator = new ShipGenerator(tunnel, 20);

        Port port = new Port(tunnel);

        ExecutorService service = Executors.newCachedThreadPool();

        service.execute(shipGenerator);

        for(Pier pier : port.getPiers()){
            service.execute(pier);
        }

        service.shutdown();

    }
}