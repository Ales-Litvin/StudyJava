package by_epam.introduction_to_java.аlgorithmization_2.arrays_of_arrays.task10;

/*
 * Условие задачи:
 * 10. Найти положительные элементы главной диагонали квадратной матрицы.
 */

import java.util.Arrays;

public class Solution {
    public static final int[][] MATRIX =   {
            {1, 8, 3, 9},
            {4, 5, 6, 2},
            {7, 2, -2, 8},
            {6, 1, 8, -1}};

    public static void main(String[] args) {

        findOfPositiveElements(MATRIX);

        printMatrix(MATRIX);
    }

    /**
     * Finds and prints positive elements the matrix's main diagonal.
     * @param matrix the matrix.
     */
    public static void findOfPositiveElements(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            if (matrix[i][i] > 0) System.out.println("'" + matrix[i][i] + "'");
        }
    }


    /**
     * Prints the matrix.
     * @param matrix the matrix.
     */
    public static void printMatrix(int[][] matrix){
        for (int[] line : matrix) {
            System.out.println(Arrays.toString(line));
        }
    }
}
