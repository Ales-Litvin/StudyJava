package javarush.task.task15.task1527;

/*
Парсер реквестов
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.String.valueOf;

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();

        ArrayList<Character> list = readerString(str.indexOf('?'), str);
        list.remove(3);
        for (int i = 0; i < 6; i++) {
            list.remove(list.size() - 1);
        }

        // чтение первых трех букв
        char[] three = {list.get(0), list.get(1), list.get(2)};

        // то что ниже если "obj"
        if ("obj".equals(valueOf(three))) {
            int number_1Remove = list.indexOf('&');
            char[] chars_1 = new char[number_1Remove - 3];
            for (int i = 3; i < number_1Remove; i++) {
                chars_1[i-3] = list.get(i);
            }

            String str_F2 = valueOf(chars_1);

            int numberRemove = list.indexOf('&');
            for (int i = 3; i < numberRemove; i++) {
                list.remove(3);
            }
            char[] chars = new char[list.size()];
            for (int i = 0; i < list.size(); i++){
                if (list.get(i) != '&')
                    chars[i] = list.get(i);
                else
                    chars[i] = ' ';
            }
            String str_F1 = String.valueOf(chars);
            System.out.println(str_F1);

            try {
                double d = Double.parseDouble(str_F2);
                alert(d);
            }
            catch (Exception e){
                alert(str_F2);
            }

            /*
            int number_1Remove = list.indexOf('&');
            char[] chars_1 = new char[number_1Remove - 3];
            for (int i = 3; i < number_1Remove; i++) {
                chars_1[i-3] = list.get(i);
            }

            String str_F2 = valueOf(chars_1);

            if (str_F2.indexOf(".") != -1){
                double d = (double) Integer.parseInt(str_F2);
                alert(d);
            }
            else {
                alert(str_F2);
            }
            */

        }

        // то что ниже если "lvl"
        else {
            int numberRemove = list.indexOf('&');
            for (int i = 3; i < numberRemove; i++) {
                list.remove(3);
            }
                char[] chars = new char[list.size()];
                for (int i = 0; i < list.size(); i++){
                    if (list.get(i) != '&')
                    chars[i] = list.get(i);
                    else
                        chars[i] = ' ';
                }
                String str_F1 = String.valueOf(chars);
                System.out.println(str_F1);
        }
    }

    private static ArrayList<Character> readerString(int i, String str) { //чтение строки после '?'
        ArrayList<Character> list = new ArrayList<>();
        for (int n = (i+1); n < str.length(); n++) {
            list.add(str.charAt(n));
        }
        return list;
    }


    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}

// http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
// http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo