package javarush.task.task09.task0922;

import java.io.*;
import java.util.*;
import java.text.*;
import java.lang.*;
import static java.lang.Character.toUpperCase;

/*
Какое сегодня число?
 */

public class Solution {

    public static void main(String[] args) throws IOException, ParseException {
        // напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String data = br.readLine();
        Date date = df.parse(data);
        DateFormat df2 = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        char[] list = df2.format(date).toCharArray();
        for (int i = 0; i < 3; i++) {
            list[i] = toUpperCase(list[i]);
        }
            System.out.println(list);

    }
}
