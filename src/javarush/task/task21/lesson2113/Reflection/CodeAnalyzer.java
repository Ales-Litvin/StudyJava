package javarush.task.task21.lesson2113.Reflection;

/*
Как узнать / определить класс объекта
Как получить информацию о модификаторах класса, полях, методах, константах, конструкторах и суперклассах
 */

import java.util.Arrays;

public class CodeAnalyzer {
    public static void analyzeClass(Object o) {
        // Входная точка в механизм рефлексии Java — класс Class
        // «class» — зарезервированное слово в языке Java, и компилятор не позволит так называть переменные
        Class clazz = o.getClass();
        System.out.println("Имя класса: " + clazz);
        System.out.println("Поля класса: " + Arrays.toString(clazz.getDeclaredFields()));
        System.out.println("Родительский класс: " + clazz.getSuperclass());
        System.out.println("Методы класса: " +  Arrays.toString(clazz.getDeclaredMethods()));
        System.out.println("Конструкторы класса: " + Arrays.toString(clazz.getConstructors()));
    }

    public static void main(String[] args) {
        analyzeClass(new Cat("Barsik", 6));
    }
}