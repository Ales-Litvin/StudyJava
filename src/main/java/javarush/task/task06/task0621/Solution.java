package javarush.task.task06.task0621;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String granddadName = reader.readLine();
        Cat catGranddad = new Cat(granddadName); // дедушка Вася

        String grannyName = reader.readLine();
        Cat catGranny = new Cat(grannyName); // бабушка Мурка

        String dadName = reader.readLine();
        Cat catDad = new Cat(dadName, null, catGranddad);      // папа кортофей

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, catGranny, null);    // мама Василиса

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catMother, catDad);          // сын Мурчик

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catMother, catDad); // дочь Пушкина

        System.out.println(catGranddad);
        System.out.println(catGranny);
        System.out.println(catDad);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat parent;      // это мама кошки
        private Cat parent2;     // это папа кошки

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat parent, Cat parent2) {
            this.name = name;
            this.parent = parent;
            this.parent2 = parent2;
        }

        @Override
        public String toString() {
            if (parent == null && parent2 == null)
                return "The cat's name is " + name + ", no mother, no father ";
            else if (parent == null)
                return "The cat's name is " + name +  ", no mother, father is " + parent2.name;
                //      The cat's name is папа Котофей, no mother, father is дедушка Вася

            else if (parent2 == null)
                return "The cat's name is " + name + ", mother is " + parent.name + ", no father";
            else
               return  "The cat's name is " + name + ", mother is " + parent.name + ", father is " + parent2.name;
        }
    }
}


