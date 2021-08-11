package by.epam.introduction_to_java.basics_1.cycles.task05;

/**
 * Условие задачи:
 * 5.  Даны  числовой  ряд  и  некоторое  число  е.
 *     Найти  сумму  тех  членов  ряда,  модуль  которых  больше  или  равен
 *     заданному е. Общий член ряда имеет вид:
 *     a<sub>n</sub> = 1/2<sup>n</sup>+1/3<sup>n</sup><br>
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(returnSumRow(2, 5, 1));
    }

    /**
     * Sums members which mo more than {@code e}.
     * Common term: a<sub>n</sub> = 1/2<sup>n</sup>+1/3<sup>n</sup><br>
     * @param m an argument.
     * @param n an another argument.
     * @param e an another argument.
     * @return sum of member which more than {@code e}.
     */
    public static int returnSumRow(int m, int n, int e){
        int result = 0;
        for (int i = m; i < n; i++){
            int a = 2;
            int b = 3;
            for (int k = 1; k < m; k++){
                a = a * 2;
                b = b * 3;
            }
            if (Math.abs(a + b) >= e) {
                result += a + b;
            }
        }
        return result;
    }
}
