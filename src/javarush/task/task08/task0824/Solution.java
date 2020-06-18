package javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.List;

/*
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human kind1 = new Human("kind1", false, 3);
        Human kind2 = new Human("kind2", false, 6);
        Human kind3 = new Human("kind1", true, 9);
        Human father = new Human("father", true, 30, kind1, kind2, kind3);
        Human mother = new Human("mother", false, 25, kind1, kind2, kind3);
        Human grandDad1 = new Human("Dad1", true, 60, father);
        Human grandDad2 = new Human("Dad2", true, 65, mother);
        Human granny1 = new Human("granny1", false, 50, father);
        Human granny2 = new Human("granny2", false, 55, mother);


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
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;
        //напишите тут ваш код
        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = new ArrayList<>();

        }

        public Human(String name, boolean sex, int age, Human ... human) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = new ArrayList<>();
            for (int i = 0; i < human.length; i++){
                this.children.add(human[i]);
            }

        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}