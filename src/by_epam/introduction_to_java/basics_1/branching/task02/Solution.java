package by_epam.introduction_to_java.basics_1.branching.task02;

/*
 * Условие задачи:
 * 2. Найти max{min(a, b), min(c, d)}.
 */
public class Solution {
    public static void main(String[] args) {
         int a = 1;
         int b = 2;
         int c = 3;
         int d = 4;

         int z = Math.max(Math.min(a, b), Math.min(c, d));

         System.out.println(z);
    }
}
