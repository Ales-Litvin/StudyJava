package by_epam.introduction_to_java.аlgorithmization_2.arrays_of_arrays.task16;

/*
 * Условие задачи:
 * 16. Магическим квадратом порядка n называется квадратная матрица размера n x n,
 *     составленная из чисел 1, 2, 3, ..., n^2 так, что суммы по каждому столбцу,
 *     каждой строке и каждой из двух больших диагоналей равны между собой.
 *     Построить такой квадрат. Пример магического квадрата порядка 3:
 *     6 1 8
 *     7 5 3
 *     2 9 4
 *
 * ЗАДАЧА НЕ РЕШЕНА!!!
 * ПОСМОТРИ НА ДРУГОМ КОМПЕ!!!
 */

import java.util.Arrays;

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

    /**
     * Prints the matrix.
     */
    public static void printMatrix(int[][] matrix){
        for (int[] line : matrix) {
            System.out.println(Arrays.toString(line));
        }
    }
}