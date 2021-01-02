package by.epam.introduction_to_java.аlgorithmization_2.one_dimensional_arrays.task03;

/*
 * Условие задачи:
 * 3.  Дан  массив  действительных  чисел,  размерность  которого  N.
 *     Подсчитать,  сколько  в  нем  отрицательных, положительных и нулевых элементов.
 */

public class Solution {
    public static void main(String[] args) {
        int[] array = {1, -2, 5, -10, 12, 0, 51 , -99, 100};

        counter(array);
    }

    /**
     * Counts the numbers of positive numbers, negative numbers and zero in the array.
     * Result prints to console.
     * @param array array of number.
     */
    public static void counter(final int[] array){
        int negative = 0;
        int positive = 0;
        int zero = 0;
        for (int i : array){
            if (i == 0) zero++;
            else if (i > 0) positive++;
            else negative++;
        }
        System.out.printf(
                "The zero            - '%d'\n" +
                "The positive number - '%d'\n" +
                "The negative number - '%d'\n",
                zero, positive, negative);
    }


}
