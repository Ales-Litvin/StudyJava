package javarush.task.task07.task0724;

import java.io.*;
/*
Семейная перепись
 */

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        Human grandDad1 = new Human("Dad1", true, 60);
        Human grandDad2 = new Human("Dad2", true, 65);
        Human granny1 = new Human("granny1", false, 50);
        Human granny2 = new Human("granny2", false, 55);
        Human father = new Human("father", true, 30, grandDad1, granny1);
        Human mother = new Human("mother", false, 25, grandDad2, granny2);
        Human kind1 = new Human("kind1", false, 3, father, mother);
        Human kind2 = new Human("kind2", false, 6, father, mother);
        Human kind3 = new Human("kind1", true, 9, father, mother);

        System.out.println(grandDad1.toString());
        System.out.println(grandDad2.toString());
        System.out.println(granny1.toString());
        System.out.println(granny2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(kind1.toString());
        System.out.println(kind2.toString());
        System.out.println(kind3.toString());

    }
    public static class Human {
        // напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = null;
            this.mother = null;
        }

        Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}