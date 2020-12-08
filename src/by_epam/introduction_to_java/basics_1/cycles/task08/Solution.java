package by_epam.introduction_to_java.basics_1.cycles.task08;

/*
 * Условие задачи:
 * 8. Даны два числа. Определить цифры, входящие в запись как первого так и
 *    второго числа.
 */

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int a = 36541561;
        int b = 65465566;
        printTheSameNumbers(a, b);
    }

    /**
     * Prints the same digits numbers {@code a} and {@code b}.
     * @param a an argument.
     * @param b  an another argument.
     */
    public static void printTheSameNumbers(int a, int b){
        Set<Character> set = new HashSet<>();
        for (char c : String.valueOf(a).toCharArray()){
            set.add(c);
        }

        Set<Character> set2 = new HashSet<>();
        for (char c : String.valueOf(b).toCharArray()){
            set2.add(c);
        }

        for (char c : set2){
            if (set.contains(c)) System.out.print(c + ", ");
        }
    }
}
