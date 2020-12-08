package by_epam.introduction_to_java.basics_1.linear_programs.task01;

/*
 * Условие задачи:
 * 1. Найдите значение функции: z = ( (a – 3 ) * b / 2) + c.
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println(result(2,3,4));
    }

    /**
     * Calculates z = ( (a - 3) * b / 2 ) + c.
     * @param a an argument.
     * @param b an another argument.
     * @param c an another argument.
     * @return calculating result
     */
    public static double result(int a, int b, int c){
        return ((a - 3) * ((double) b / 2)) + c;
    }
}
