package javarush.task.task27.task2712.kitchen;

import javarush.task.task27.task2712.Tablet;

import java.util.ArrayList;

public class TestOrder extends Order {

    public TestOrder(Tablet tablet) { super(tablet); }

    @Override
    protected void initDishes() {
        super.dishes = new ArrayList<>();

        int numberOfDishes = (int) (Math.random() * 10);

        Dish[] copyEnumDish = Dish.values();

        for (int i = 0; i < numberOfDishes; i++){
            int enumDishNumber =  (int) (Math.random() * copyEnumDish.length);
            dishes.add(Dish.valueOf(copyEnumDish[enumDishNumber].toString()));
        }
    }
}