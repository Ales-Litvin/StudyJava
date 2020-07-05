package javarush.task.task27.task2712;

import javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e){
            System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            return readString();
        }
    }

    public static List<Dish> getAllDishesForOrder(){
        writeMessage("Выберите блюдо:");
        writeMessage(Dish.allDishesToString());
        writeMessage("Введите назване блюда:");

        String dish = null;
        List<Dish> dishes = new ArrayList<>();

        while (!(dish = readString()).equals("exit")){
            try {
                dishes.add(Dish.valueOf(dish));
            } catch (IllegalArgumentException e) {
                writeMessage("Такого блюда нет");
            }
        }
        return dishes;
    }
}
