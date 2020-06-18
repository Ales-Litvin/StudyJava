package javarush.task.task08.task0812;

import java.io.*;
import java.util.*;

/*
Самая длинна последовательность
 */

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> array = new ArrayList<Integer>();
        String s;
        for (int i = 0; i < 10; i++){
            array.add(Integer.parseInt(reader.readLine()));
            }
            ArrayList<Integer> list = new ArrayList<>();
        int j = 1;
        for (int i = 0; i < array.size() - 1; i++){
            if (array.get(i).equals(array.get(i+1)) &&  i != array.size() - 2){
                j++;
            }
            else if (array.get(i).equals(array.get(i+1)) &&  i == array.size() - 2){
                j++;
                list.add(j);
                j = 1;
            }
            else {
                list.add(j);
                j = 1;
            }
        }
        Collections.sort(list);

        System.out.println(list.get(list.size() - 1));
    }

    }
