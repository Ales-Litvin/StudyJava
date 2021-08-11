package com.vertex.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionCarExample {
    public static void main(String[] args) {
        // Getting class of 'Car'
        // The first way
        try {
            Class<?> classCar = Class.forName("com.vertex.reflection.Car");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // The second way
        Car car = new Car();
        Class<? extends  Car> classCar1 = car.getClass();

        // The third way
        Class<Car> classCar2 = Car.class;

        Field[] declaredFields = classCar1.getDeclaredFields();
        try {
            Field horsepowerField = classCar1.getDeclaredField("horsepower");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        Field[] fields = classCar1.getFields();

        try {
            Field serialNumberField = classCar1.getField("serialNumber");
            System.out.println(serialNumberField);
            Field horsepowerField = classCar1.getField("horsepower");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        Method[] declaredMethods = classCar1.getDeclaredMethods();


        try {
            Constructor constructor = classCar1.getConstructor();
            Car car1 = (Car) constructor.newInstance();
            Car car2 = (Car) classCar1.newInstance();

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
