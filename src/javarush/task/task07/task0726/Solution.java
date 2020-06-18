package javarush.task.task07.task0726;

import java.io.*;
import java.util.ArrayList;

import static java.lang.Integer.*;

/*
Не компилируется задача про котиков
 */

public class Solution {
    public final static ArrayList<Cat> CATS = new ArrayList<>();        // создается список

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String name = reader.readLine();
            if (name == null || name.isEmpty()) {    // условие пустой строки
                break;
            }

                int age = Integer.parseInt(reader.readLine());
                int weight = Integer.parseInt(reader.readLine());
                int tailLength = Integer.parseInt(reader.readLine());

            Cat cat = new Cat(name, age, weight, tailLength);
            CATS.add(cat);
        }

        printList();                                 // вызывается метот вывода на экран
    }

    public static void printList() {
        for (int i = 0; i < CATS.size(); i++) {
            System.out.println(CATS.get(i));
        }
    }

    public static class Cat {               // класс Cat
        private String name;
        private int age;
        private int weight;
        private int tailLength;

        Cat(String name, int age, int weight, int tailLength) {     // конструктор класса Cat
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.tailLength = tailLength;
        }

        Cat(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Cat's name: " + name + ", age: " + age + ", weight: " + weight + ", tail: " + tailLength;
        }
    }
}