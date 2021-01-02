package by.epam.introduction_to_java.аlgorithmization_2.one_dimensional_arrays.task04;

/*
 * Условие задачи:
 * 4. Даны действительные числа а1 ,а2 ,..., аn .
 *    Поменять местами наибольший и наименьший элементы.
 */

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] array = {1, -2, 5, -10, 12, 0, 51 , -99, 100};

        swapMinAndMax(array);

        System.out.println(Arrays.toString(array));
    }

    /**
     * Swaps the min value and the max value.
     * @param array the array of number (а<sub>1</sub>, а<sub>2</sub>, ..., а<sub>n</sub>).
     */
    public static void swapMinAndMax(final int[] array){
        int max = 0;
        int min = 0;
        for (int j : array) {
            if (j > max) { max = j; }
            if (j < min) { min = j; }
        }

        for (int i = 0; i < array.length; i++){
            if (array[i] == max) {
                array[i] = min;
            } else if (array[i] == min) {
                array[i] = max;
            }
        }

    }
}
