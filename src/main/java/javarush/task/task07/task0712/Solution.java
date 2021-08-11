package javarush.task.task07.task0712;

import java.io.*;
import java.util.ArrayList;


public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }

        String a1, a2;
        int l1, l2;

        int max = list.get(0).length();
        for (int i = 1; i < 10; i++) {
            if (max <= list.get(i).length()) {
                max = list.get(i).length();
            } else {
            }
        }

        int min = list.get(0).length();
        for (int i = 1; i < 10; i++) {
            if (min >= list.get(i).length()) {
                min = list.get(i).length();
            }
            else {
            }
        }

        for (int i = 0; i < 10; i++) {
            if (min == list.get(i).length()) {
                System.out.println(list.get(i));
                break;
            }
            else if (max == list.get(i).length()){
                System.out.println(list.get(i));
                break;
            }
            else {}
        }

    }

}


