package javarush.task.task10.task1019;

import java.io.*;
import java.util.*;
import java.lang.*;


/*
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int index;
        String name;

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        while (true) {
                String number = reader.readLine();
                if (number.isEmpty() || number == null) break;
                index = Integer.parseInt(number);
                name = reader.readLine();
                map.put(name, index);
        }

        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            name = pair.getKey();
            index = pair.getValue();
            System.out.println(index + " " + name);
        }
    }
}