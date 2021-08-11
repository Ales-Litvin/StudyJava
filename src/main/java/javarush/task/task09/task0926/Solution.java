package javarush.task.task09.task0926;

import java.util.ArrayList;

/*
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        ArrayList<int[]> listArray = new ArrayList<>();
        int[] a = {1 , 2, 3, 4, 5};
        int[] b = {1 , 2};
        int[] c = {1 , 2, 3, 4};
        int[] d = {1 , 2, 3, 4, 5, 6, 7};
        int[] e = {};
        listArray.add(a);
        listArray.add(b);
        listArray.add(c);
        listArray.add(d);
        listArray.add(e);
        return listArray;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}