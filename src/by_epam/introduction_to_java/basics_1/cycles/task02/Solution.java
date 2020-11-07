package by_epam.introduction_to_java.basics_1.cycles.task02;

/**
 * Условие задачи:
 * 2. Вычислить значения функции на отрезке [а,b] c шагом h:
 * <br><center><img src="function.PNG">
 */

public class Solution {
    public static void main(String[] args) {
        isResult(1, 5, 1);
    }

    /**
     * Calculates the value of a function ([a, b]) h
     * @param a - начальная граница отрезка
     * @param b - конечная граниица отрезка
     * @param h - шаг
     */
    public static void isResult(int a, int b, int h){
        double result;
        for (int i = a; i <= b; i += h){
            if (i > 2) {
                System.out.println(i);
            } else {
                System.out.println(-i);
            }
        }
    }
}
