package by.epam.introduction_to_java.basics_1.branching.task02;

/*
 * Условие задачи:
 * 2. Найти max{min(a, b), min(c, d)}.
 */
public class Solution {
    public static void main(String[] args) {
         System.out.println(maxOfMin(1, 2, 3, 4));
    }

    /**
     * Returns the greater of two min values, max{min(a, b), min(c, d)}.
     * @param a an argument.
     * @param b another argument.
     * @param c another argument.
     * @param d another argument.
     * @return the larger of the smaller.
     */
    public static int maxOfMin(int a, int b, int c, int d){
        return Math.max(Math.min(a, b), Math.min(c, d));
    }
}
