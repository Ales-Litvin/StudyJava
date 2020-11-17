package javarush.task.task39.task3908;

/*
Возможен ли палиндром?
*/


import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("tenet"));
        System.out.println(isPalindromePermutation("12123")); // true
        System.out.println(isPalindromePermutation("22311"));
        System.out.println(isPalindromePermutation("vnssfjvdvnsdfjv"));
        System.out.println(isPalindromePermutation("топот"));

        // 12321 | 1
        System.out.println(isPalindromePermutation("PiWpWoi")); // true
        System.out.println(isPalindromePermutation("PpWiWoi"));
    }

    public static boolean isPalindromePermutation(String s) {
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