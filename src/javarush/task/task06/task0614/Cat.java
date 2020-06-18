package javarush.task.task06.task0614;

import java.util.*;

/*
Статиеческие коты
 */
public class Cat {
    // напшите тут ваш код
    public static ArrayList<Cat> cats = new ArrayList();

    public Cat() {
    }

    public static void main(String[] args) {
        // напишите тут ваш код
        for (int i = 0; i < 10; i++) {
            cats.add(new Cat());
        }
        printCats();
    }

    public static void printCats(){
        // напишите тут ваш код
                for (Cat her: cats){
            System.out.println(her);
        }

    }

}
