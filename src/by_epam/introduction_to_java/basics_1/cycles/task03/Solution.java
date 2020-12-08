package by_epam.introduction_to_java.basics_1.cycles.task03;

/*
 * Условие задачи:
 * 3. Найти сумму квадратов первых ста чисел.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(sumSquaresFirstHundred());
    }

    /**
     * Calculates sum of squares first hundred numbers.
     * @return sum of squares first hundred numbers.
     */
    public static int sumSquaresFirstHundred(){
        int result = 0;
        for (int i = 1; i <= 100; i++){
            result += i * i;
        }
        return result;
    }
}
