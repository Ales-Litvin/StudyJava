package javarush.task.task08.task0820;

import java.util.*;
import java.io.*;

/*
Множество всех животных
*/

public class Solution {
    public static void main(String[] args) {
            Set<Cat> cats = createCats();
            Set<Dog> dogs = createDogs();

            Set<Object> pets = join(cats, dogs);
            //printPets(pets);  // потом раскоментируй

            removeCats(pets, cats);
            printPets(pets);
        }

        public static Set<Cat> createCats() {
            Set<Cat> result = new HashSet<Cat>();
            //напишите тут ваш код
            for (int i = 0; i < 4; i++){
            result.add(new Cat());
            }

            return result;
        }

        public static Set<Dog> createDogs() {
            //напишите тут ваш код
            Set<Dog> result = new HashSet<Dog>();
            for (int i = 0; i < 3; i++){
                result.add(new Dog());
            }
            return result;
        }

        public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
            //напишите тут ваш код
            Set<Object> pets = new HashSet<>();
            for (Cat cat : cats){
                pets.add(cat);
            }
            for (Dog dog : dogs){
                pets.add(dog);
            }
            return pets;
        }

        public static void removeCats(Set<Object> pets, Set<Cat> cats) {
            //напишите тут ваш код
            for (Cat cat : cats){
                pets.remove(cat);
            }

        }


        public static void printPets(Set<Object> pets) {
            //напишите тут ваш код
            for (Object animal : pets){
                System.out.println(animal);
            }
        }

        //напишите тут ваш код

    public static class Cat {

    }

    public static class Dog {

    }

}
