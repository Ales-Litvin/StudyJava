package by_epam.introduction_to_java.basics_1.linear_programs.task01;

/*
 * Условие задачи:
 * 1. Найдите значение функции: z = ( (a – 3 ) * b / 2) + c.
 */

public class Solution {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        int c = 4;

        double z = ((a - 3) * ((double) b / 2)) + c;
        System.out.println(z);
    }
}
