package by_epam.introduction_to_java.basics_1.linear_programs.task02;

/**
 * Условие задачи:
 * 2. Вычислить значение выражения по формуле (все переменные принимают действительные значения):
 *    <br>
 *    ((b + √(𝑏<sup>2</sup> + 4ac)) / 2a ) - a<sup>3</sup>c + b<sup>-2</sup>
 */

public class Solution {
    public static void main(String[] args) {
        int a = 1;
        int b = 3;
        int c = 4;

        double z = ((b + Math.sqrt(b * b + 4 * a * c)) / (2 * a))
                - (a * a * a * c) + ((double) 1 / (b * b));

        System.out.println(z);
    }
}
