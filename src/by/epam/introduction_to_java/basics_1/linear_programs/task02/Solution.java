package by.epam.introduction_to_java.basics_1.linear_programs.task02;

/**
 * Условие задачи:
 * 2. Вычислить значение выражения по формуле (все переменные принимают
 *    действительные значения):
 *    <br>
 *    ((b + √(𝑏<sup>2</sup> + 4ac)) / 2a ) - a<sup>3</sup>c + b<sup>-2</sup>
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println(result(1, 2, 3));
    }

    /**
     * Calculates
     * ((b + √(𝑏<sup>2</sup> + 4ac)) / 2a ) - a<sup>3</sup>c + b<sup>-2</sup>.
     * @param a an argument.
     * @param b an another argument.
     * @param c an another argument.
     * @return calculating result
     */
    public static double result(int a, int b, int c){
        return ((b + Math.sqrt(b * b + 4 * a * c)) / (2 * a))
                - (a * a * a * c) + ((double) 1 / (b * b));
    }
}
