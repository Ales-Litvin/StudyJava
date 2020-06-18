package javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        while (true) {
            String city = reader.readLine();
            if (city.isEmpty()) {
                break;

            }

            String family = reader.readLine();
            list.add(family);
            list1.add(city);
        }

        // Read the house number
            String c = reader.readLine();
            int s = list1.indexOf(c);

        String familyName = list.get(s);
        System.out.println(familyName);



    }
}