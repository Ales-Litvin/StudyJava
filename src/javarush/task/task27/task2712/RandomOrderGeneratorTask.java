package javarush.task.task27.task2712;

import java.util.ArrayList;
import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
    // тут храниться список всех планшетов
    private List<Tablet> tablets = new ArrayList<>();
    private int orderCreatingInterval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int orderCreatingInterval) {
        this.tablets = tablets;
        this.orderCreatingInterval = orderCreatingInterval;
    }

    @Override
    public void run() {
        // Выбор случайного планшета из массива tablets

        while (true) {
            Tablet randomTablet = tablets.get((int) (Math.random() * tablets.size()));
            randomTablet.createOrder();

            try {
                Thread.sleep(orderCreatingInterval);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}