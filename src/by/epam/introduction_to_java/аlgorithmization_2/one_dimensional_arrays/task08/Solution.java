package by.epam.introduction_to_java.аlgorithmization_2.one_dimensional_arrays.task08;

/*
 * Условие задачи:
 * 8.  Дана  последовательность  целых  чисел a1, a2, ..., an.
 *     Образовать  новую  последовательность,  выбросив  из исходной те члены,
 *     которые равны min(a1, a2, ..., an).
 */

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] array = {1, -99, 5, -99, 12, 0, 51 , -99, -99};

        System.out.println(Arrays.toString(throwMin(array)));
    }

    /**
     * Throws from the array min values.
     * @param array the array
     * @return new the array without min values.
     */
    public static int[] throwMin(final int[] array){
        int min = min(array);
        int[] result = new int[array.length - countOfNumber(array, min)];
        for (int i = 0, j = 0; i < array.length; i++){
            if (array[i] == min) {
                continue;
            }
            result[j] = array[i];
            j++;
        }
        return result;
    }

    /**
     * Returns min(а<sub>1</sub>, а<sub>2</sub>, ..., а<sub>n</sub>).
     * @param array the array of number (а<sub>1</sub>, а<sub>2</sub>, ..., а<sub>n</sub>).
     */
    public static int min(final int[] array){
       int min = array[0];
        for (int j : array) {
            if (min > j) min = j;
        }
       return min;
    }

    /**
     * Counts amount of the numbers in the array.
     * @param array the array for counting.
     * @param number the number for counting.
     * @return amount of the numbers in the giving array.
     */
    public static int countOfNumber(int[] array, int number){
        int count = 0;
        for (int j : array) {
            if (j == number) count++;
        }
        return count;
    }
}
