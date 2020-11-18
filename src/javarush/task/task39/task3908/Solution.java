package javarush.task.task39.task3908;

/*
Возможен ли палиндром?
Реализуй метод isPalindromePermutation(String s) который будет возвращать true, если из
всех символов строки s можно составить палиндром. Иначе — false.
Символы в анализируемой строке ограничены кодировкой ASCII.
Регистр букв не учитывается.
Требования:
1. Метод isPalindromePermutation должен возвращать true, если выполнив перестановку символов
входящей строки можно получить палиндром.
2. Метод isPalindromePermutation должен возвращать false, если выполнив перестановку символов
входящей строки получить палиндром невозможно.
3. Метод isPalindromePermutation должен быть публичным.
4. Метод isPalindromePermutation должен быть статическим.
*/

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("tenet"));
        System.out.println(isPalindromePermutation("tenet"));
        System.out.println(isPalindromePermutation("12123")); // true
        System.out.println(isPalindromePermutation("22311"));
        System.out.println(isPalindromePermutation("vnssfjvdvnsdfjv"));
        System.out.println(isPalindromePermutation("fvdvf"));
        System.out.println(isPalindromePermutation("fFF"));
        System.out.println(isPalindromePermutation("ff"));
        System.out.println(isPalindromePermutation("ff"));

        // 12321 | 1
        System.out.println(isPalindromePermutation("PiWpWoi")); // true
        System.out.println(isPalindromePermutation("PpWiWoi"));
    }

    public static boolean isPalindromePermutationThree(String s) {
        if (s == null || s.isEmpty()) return false;

        boolean hasMiddle = false;

        char[] chars = s.toLowerCase().toCharArray();

        Set<Character> list = new TreeSet<>();
        for (char aChar : chars) {
            list.add(aChar);
        }

        for (Character c : list){

            int count = 0;
            for (char c1 : chars){
                if (c == c1) count++;
            }

            if (count % 2 != 0 && chars.length % 2 != 0 && !hasMiddle){
                hasMiddle = true;
            } else if (count % 2 != 0 && hasMiddle) {
                System.out.println(c);
                return false;
            }
        }
        return true;
    }

    // It's working variant
    public static boolean isPalindromePermutation(String s){
        if (s == null || s.isEmpty()) return true;

        // Lower case the String and remove white spaces
        s = s.toLowerCase();
        s = s.replaceAll(" ", "");

        // Assume 8-bit ascii encoding
        boolean[] isOdd = new boolean[256];

        // For each character c in the input String, save whether it is
        // represented an odd number of times
        for (int i = 0; i < s.length(); i++) {
            isOdd[s.charAt(i)] = !isOdd[s.charAt(i)];
        }

        // Count the number of odd characters
        int numberOdds = 0;

        for (int i = 0; i < isOdd.length; i++) {
            if (isOdd[i]) {
                numberOdds++;
            }
            // At most one character can have an odd count
            if (numberOdds > 1) {
                return false;
            }
        }
        return true;
    }


    // true if can change symbol for palindrome
    public static boolean isPalindromePermutationTwo(String s) {
        if (s == null || s.isEmpty()) return false;

        char[] chars = s.toLowerCase().toCharArray();

        boolean hasMiddle = s.length() % 2 == 0;

        for (int i = 0; i < chars.length / 2 + 1; i++){

            for (int j = i + 1; j < chars.length; j++){
                if (chars[i] == chars[j]){
                    swap(chars, j, chars.length - i - 1);
                    break;
                } else if (chars[i] != chars[j] && j == chars.length - 1 && !hasMiddle){
                    swap(chars, i, chars.length / 2);
                } else if (j == chars.length - 1 && chars[i] != chars[j]){
                    return false;
                }
            }
        }

        String mayPalindrome = String.valueOf(chars);

        return new StringBuilder(mayPalindrome).
                reverse().toString().equalsIgnoreCase(mayPalindrome);
    }

    private static void swap(char[] chars, int j, int i) {
        char data = chars[i];
        chars[i] = chars[j];
        chars[j] = data;
    }
}