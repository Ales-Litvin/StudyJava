package by.epam.introduction_to_java.аlgorithmization_2.arrays_of_arrays.task09;

/*
 * Условие задачи:
 * 9.  Задана матрица неотрицательных чисел.
 *     Посчитать сумму элементов в каждом столбце.
 *     Определить, какой столбец содержит максимальную сумму.
 */

import java.util.Arrays;

public class Solution {
    public static final int[][] MATRIX = {
            {1, 8, 3, 4},
            {4, 5, 6, 6},
            {7, 2, 9, 4},
            {4, 4, 0, 1}};

    public static void main(String[] args) {
        int[] result = sumColumns(MATRIX);

        System.out.println(
                "Sum by columns: " + Arrays.toString(result));

        System.out.println("Max sum in the column: " + maxIndexOf(result));
    }

    /**
     * Counts sum values by columns.
     * @param matrix the matrix.
     * @return the array of sums by columns.
     */
    public static int[] sumColumns(final int[][] matrix){
        int[] result = new int[matrix.length];

        for (int i = 0; i < matrix[0].length; i++){
            int sum = 0;
            for (int j = 0; j < matrix.length; j++){
                sum += matrix[j][i];
            }
            result[i] = sum;
        }

        return result;
    }

    /**
     * Returns index of max element.
     * @param array the array.
     */
    public static int maxIndexOf(final int[] array){
        int max = array[0];
        int index = 0;
        for (int i = 0; i < array.length; i++){
            if (max < array[i]) {
                max = array[i];
                index = i;
            }
        }
        return index;
    }


}
