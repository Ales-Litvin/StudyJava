package by_epam.introduction_to_java.basics_1.linear_programs.task03;

/*
 * Условие задачи:
 * 3. Вычислить значение выражения по формуле (все переменные принимают
 *    действительные значения):
 *      (sin x + cos y) / (cos x - sin y) * tg xy.
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println(result(1,1));
    }

    /**
     * Calculates (sin x + cos y) / (cos x - sin y) * tg xy.
     * @param x an argument.
     * @param y an another argument.
     * @return calculating result
     */
    public static double result(int x, int y){
        return ((Math.sin(x) + Math.cos(y)) /
                (Math.cos(x) - Math.sin(y))) * Math.tan(x * y);
    }
}