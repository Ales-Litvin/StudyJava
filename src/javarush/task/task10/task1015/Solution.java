package javarush.task.task10.task1015;

import java.util.ArrayList;
import java.util.List;

/*
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);

    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        ArrayList<String>[] list = new ArrayList [2];
        ArrayList<String> strings1 = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            strings1.add("Массив 1. Строка " + i);
        }
        ArrayList<String> strings2 = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            strings2.add("Массив 2. Строка " + i);
        }

        list[0] = strings1;
        list[1] = strings2;

        return list;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}