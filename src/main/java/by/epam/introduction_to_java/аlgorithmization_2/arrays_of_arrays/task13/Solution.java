package by.epam.introduction_to_java.аlgorithmization_2.arrays_of_arrays.task13;

/*
 * Условие задачи:
 * 13. Отсотрировать стобцы матрицы по возрастанию и убыванию значений эементов.
 */

import java.util.Arrays;

public class Solution {
    public static final int[][] MATRIX =   {{1, 8, 3, 9},
            {4, 5, 6, 2},
            {7, 2, 9, 8},
            {6, 1, 8, 7}};

    public static void main(String[] args) {

        sortColumnsByAscend(MATRIX);

        printMatrix(MATRIX);

        System.out.println("==============");

        sortColumnsByDescend(MATRIX);

        printMatrix(MATRIX);
    }

    /**
     * Sorts matrix's columns by ascends values.
     * @param matrix the matrix.
     */
    public static void sortColumnsByAscend(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for (int k = 0; k < matrix[i].length; k++){
                for (int m = 0; m < matrix[i].length - k - 1; m++){
                    if (matrix[m][i] > matrix[m + 1][i]){
                        int data = matrix[m][i];
                        matrix[m][i] = matrix[m + 1][i];
                        matrix[m + 1][i] = data;
                    }
                }
            }
        }
    }

    /**
     * Sorts matrix's columns by descends values.
     * @param matrix the matrix.
     */
    public static void sortColumnsByDescend(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for (int k = 0; k < matrix[i].length; k++){
                for (int m = 0; m < matrix[i].length - k - 1; m++){
                    if (matrix[m][i] < matrix[m + 1][i]){
                        int data = matrix[m][i];
                        matrix[m][i] = matrix[m + 1][i];
                        matrix[m + 1][i] = data;
                    }
                }
            }
        }
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
