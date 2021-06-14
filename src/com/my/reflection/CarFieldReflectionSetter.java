package com.my.reflection;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;

public class CarFieldReflectionSetter {

    public static void main(String[] args) throws CloneNotSupportedException {
        CarFieldReflectionSetter reflectionSetter = new CarFieldReflectionSetter();
        Car car = new Car();
        System.out.println(car);
        reflectionSetter.setMaxSpeedToCar(car);
        System.out.println(car);
        reflectionSetter.setMaxWidth(car);
        System.out.println(car);

        Car cloneOfCar = (Car) car.clone();
        System.out.println(cloneOfCar);
        System.out.println("Clone is equals origin object" +  cloneOfCar.equals(car));

        OutputStream out = new ByteArrayOutputStream();

    }

    private static final int SUPER_SPEED = 150;

    private void setMaxSpeedToCar(Car car){
        Class<? extends Car> clazz = car.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.getName().equalsIgnoreCase("maxSpeed")){
                try {
                    field.setAccessible(true);
                    field.setInt(car, SUPER_SPEED);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static final double SUPER_WIDTH = 1234.34;

    private void setMaxWidth(Object car){
        if (!(car instanceof Car)){
            System.out.println("Uuh it's not car!");
            return;
        } else {
            Class<? extends Car> clazz = ((Car)car).getClass();
            for (Field field : clazz.getDeclaredFields()) {
                if (field.getName().equalsIgnoreCase("width")){
                    try {
                        field.setAccessible(true);
                        field.setDouble(car, SUPER_WIDTH);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
