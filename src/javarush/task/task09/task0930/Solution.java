package javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        // напишите тут ваш код
        ArrayList<Integer> list1 = new ArrayList<>();
        String s;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (isNumber(array[j]) == true){
                    for (int y = 0; y < array.length - j - 1; y++){
                        if (isNumber(array[j+y]) == true
                                && Integer.parseInt(array[j]) < Integer.parseInt(array[j+y])) {
                            s = array[j + y];
                            array[j + y] = array[j];
                            array[j] = s;
                        }
                    }
                }

            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i ; j++) {
                if (isNumber(array[j]) == false){
                    for (int y = 1; y < array.length - j; y++){
                        if (isNumber(array[j+y]) == false
                                && isGreaterThan(array[j], array[j+y]) == true) {
                            s = array[j + y];
                            array[j + y] = array[j];
                            array[j] = s;
                        }

                    }
                }

            }
        }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}