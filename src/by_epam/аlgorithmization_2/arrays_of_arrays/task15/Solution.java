package by_epam.аlgorithmization_2.arrays_of_arrays.task15;

import java.util.Arrays;


/*
 Магическим квадратом порядка n называется квадратная матрица размера nxn,
 составленная из числе 1, 2, 3, ... , n^2 так, что суммы по каждому столбцу, каждой
 из двух больших диагоналей равны между собой. Построить такой квадрат.

 ЗАДАЧА НЕ РЕШЕНА!!!
 */

public class Solution {
    public static final int[][] MATRIX = {{1, 8, 3, 9},
            {4, 5, 6, 2},
            {7, 2, 9, 8},
            {6, 1, 8, 7}};

    public static final int[][] MAGIC_SQUARE_ONE = {
            {6, 1, 8},
            {7, 5, 3},
            {2, 9, 4}};

    public static void main(String[] args) {

        printMatrix(MATRIX);
    }

    public static int[][] generateMagicSquare(int n) {
        int[][] result = new int[n][n];


        return result;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int[] line = matrix[i];
            System.out.println(Arrays.toString(line));
        }
        System.out.println("=================");
    }
}