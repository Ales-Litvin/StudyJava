package javarush.task.task08.task0823;

import java.io.*;

/*
Омовение Рамы
 */

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        char[] chars = string.toCharArray();
        string.toUpperCase();
        int l = 0;
        for (int i = 0; i < chars.length ; i++){
            chars[0] = Character.toUpperCase(chars[0]);
        if (chars[i] == ' ' && chars[i+1] != ' '){
            chars[i+1] = Character.toUpperCase(chars[i+1]);
        }
        }
        string = new String(chars);
        System.out.println(string);
        // напишите тут ваш код
        }
}
