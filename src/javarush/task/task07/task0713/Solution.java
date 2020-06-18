package javarush.task.task07.task0713;

import java.io.*;
import java.util.ArrayList;

/*
Играем в золошку
 */

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list_2 = new ArrayList<>();
        ArrayList<Integer> list_3 = new ArrayList<>();
        ArrayList<Integer> list_0 = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            list.add(Integer.parseInt(reader.readLine()));
        }

        for (int i = 0; i < 20; i++){
            if (list.get(i)%3 == 0 && list.get(i)%2 == 0){
                list_2.add(list.get(i));
                list_3.add(list.get(i));
            }
            else if (list.get(i)%3 == 0){
                list_3.add(list.get(i));
            }
            else if (list.get(i)%2 == 0){
                list_2.add(list.get(i));
            }
            else {
                list_0.add(list.get(i));
            }

        }

        printList(list_3);
        printList(list_2);
        printList(list_0);

    }

    public static void printList(ArrayList<Integer> list){
        // напишите тут ваш код
        for (Integer i: list){
            System.out.println(i);
        }

    }
}
