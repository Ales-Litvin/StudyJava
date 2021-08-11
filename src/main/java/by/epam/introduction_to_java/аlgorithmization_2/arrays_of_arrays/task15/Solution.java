package by.epam.introduction_to_java.аlgorithmization_2.arrays_of_arrays.task15;

/*
 * Условие задачи:
 * 15. Найдите наибольший элемент матрицы и заменить все нечетные элементы на него.
 */

import java.util.Arrays;

public class Solution {
    public static final int[][] MATRIX = {
            {1, 8, 3, 4},
            {4, 5, 6, 6},
            {7, 2, 9, 4},
            {4, 4, 0, 1}};

    public static void main(String[] args) {
        replaceOdd(MATRIX, max(MATRIX));

        printMatrix(MATRIX);
    }

    /**
     * Replaces odd elements to {@code i};
     * @param matrix the matrix.
     * @param k the new integer.
     */
    public static void replaceOdd(int[][] matrix, int k){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                if (matrix[i][j] % 2 != 0) matrix[i][j] = k;
            }
        }
    }

    /**
     * Returns max value in the matrix.
     */
    public static int max(int[][] matrix){
        int max = matrix[0][0];
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (max < anInt) max = anInt;
            }
        }
        return max;
    }


    /**
     * Prints the matrix.
     */
    public static void printMatrix(int[][] matrix){
        for (int[] line : matrix) {
            System.out.println(Arrays.toString(line));
        }
    }
}