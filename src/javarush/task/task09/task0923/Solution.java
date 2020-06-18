package javarush.task.task09.task0923;

import java.io.*;
import java.util.*;
import java.lang.Character;

/*
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Character> vowel = new ArrayList<Character>();
        List<Character> other = new ArrayList<Character>();
        String string = br.readLine();
        for (int i = 0; i < string.length(); i++) {
            if (isVowel(string.charAt(i))) {
                vowel.add(string.charAt(i));
            }
            else if (string.charAt(i) != ' ') {
                other.add(string.charAt(i));
                }

            }

            for (Character v: vowel){
                System.out.print(v + " ");
            }

        System.out.println(" ");

            for (Character o: other){
                System.out.print(o + " ");
            }

        }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}