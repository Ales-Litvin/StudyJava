package by_epam.introduction_to_java.tasks_6.task04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Попробуйте решить данную задачу хотя бы на 50%.
 * Задание 4. Многопоточность. Порт . Корабли заходят в порт для
 * разгрузки/загрузки контейнеров. Число контейнеров, находящихся в текущий
 * момент в порту и на корабле, должно быть неотрицательным и превышающим
 * заданную грузоподъемность судна и вместимость порта. В порту работает
 * несколько причалов. У одного причала может стоять один корабль.
 * Корабль может загружаться у причала или разгружаться.
 */
public class Main {
    /*
     * May be next situations:
     * 1. In the tunnel all ships arrived for unloading, then it will work
     *    infinity, because the port will crowded.
     *
     * 2. In the tunnel all ships arrived for loading, then it will work
     *    infinity, because in the port not 'containers'.
     *
     * 3. In the port not 'containers' and doesn't any ship for unloading,
     *    then it will work infinity.
     *
     * 4. The port crowded and doesn't any ship for loading, then it will work
     *    infinity.
     *
     * 5. Doesn't any ship in the tunnel.
     */
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
