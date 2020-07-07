package javarush.task.task27.task2712.kitchen;

import javarush.task.task27.task2712.ConsoleHelper;
import javarush.task.task27.task2712.Tablet;

import java.util.List;

// Order - заказ
public class Order {
    private final Tablet tablet;

    protected List<Dish> dishes;

    public List<Dish> getDishes() {
        return dishes;
    }

    public Order(Tablet tablet) {
        this.tablet = tablet;
        initDishes();
    }

    @Override
    public String toString() {
        if (dishes == null || dishes.size() == 0) return  null;

        final StringBuilder sb = new StringBuilder("Your order: [");
        sb.append(dishes.get(0));
        for (int i = 1; i < dishes.size(); i++){
            sb.append(", ");
            sb.append(dishes.get(i));
        }
        sb.append("] of ");
        sb.append(tablet.toString());
        sb.append(", cooling time ");
        sb.append(getTotalCookingTime());
        sb.append("min");
        return sb.toString();
    }

    public int getTotalCookingTime(){
        int totalCookingTime = 0;
        for (Dish dish : dishes){
            totalCookingTime += dish.getDuration();
        }
        return totalCookingTime;
    }

    public boolean isEmpty(){ return dishes.isEmpty(); }

    protected void initDishes(){
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public Tablet getTablet() { return tablet; }
}