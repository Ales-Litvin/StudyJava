package by_epam.introduction_to_java.аlgorithmization_2.arrays_of_arrays.task16;

/*
 * Условие задачи:
 * 16. Магическим квадратом порядка n называется квадратная матрица размера
 *     n x n, составленная из чисел 1, 2, 3, ..., n^2 так, что суммы по каждому
 *     столбцу, каждой строке и каждой из двух больших диагоналей равны между
 *     собой. Построить такой квадрат. Пример магического квадрата порядка 3:
 *     6 1 8
 *     7 5 3
 *     2 9 4
 */

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

        int[][] magicSquare = getOddMagicSquare(5);

        printMatrix(magicSquare);
    }

    /**
     * Creates the magic square.
     * @param n the matrix's order.
     * @return the magic square. If n <= 2 return {@code null}.
     */
    public static int[][] getMagicSquare(int n) {
        if (n <= 2) return null;
        else if (n % 2 == 0) return null;
        else return getOddMagicSquare(n);
    }


    /**
     * Creates the magic odd square.
     * @param n the matrix's order.
     * @return the magic odd square. If {@code n} is not odd returns {@code null}.
     */
    private static int[][] getOddMagicSquare(int n){
        if (n % 2 == 0) return null;

        // creates and fills terraces in the matrix
        int[][] matrix = fillsMatrixTerraces(n);

        // turns matrix and shift down terraces
        for (int i = 0; i < 4; i++){
            matrix = getRotateArr(matrix);
            shiftDown(matrix, n);
        }

        // turn matrix random number from 0 to 4
        for (int i = 0; i < Math.random() * 3; i++){
            matrix = getRotateArr(matrix);
        }

        return trimMatrix(matrix, n);
    }

    /**
     * Creates and fills matrix with terraces.
     * @param n the matrix's order.
     * @return the matrix with terraces.
     */
    private static int[][] fillsMatrixTerraces(int n){
        int size = (n / 2) * 2 + n;
        int[][] matrix = new int[size][size];

        // fills terraces in the matrix
        int z = 1;
        for (int i = matrix.length / 2, j = 0; j <= size / 2; j++, i++){
            for (int k = i, m = j, u = 1; u <= n; u++, z++, k--, m++){
                matrix[k][m] = z;
            }
        }
        return matrix;
    }

    /**
     * Shifts down terrace to down border.
     * @param matrix the matrix.
     * @param n the matrix's order.
     */
    private static void shiftDown(int[][] matrix, int n){
        for (int i = 0; i < n / 2; i++){
            for (int j = 0; j < matrix[i].length; j++){
                if (matrix[i][j] != 0){
                    matrix[i + n][j] = matrix[i][j];
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * Cuts out the matrix order {@code n} from center.
     * @param matrix the matrix.
     * @param n the matrix's order.
     * @return the cut matrix.
     */
    private static int[][] trimMatrix(int[][] matrix, int n){
        int[][] result = new int[n][n];

        for (int i = 0; i < result.length; i++){
            for (int j = 0; j < result[i].length; j++){
                result[i][j] = matrix[i + n / 2][j + n / 2];
            }
        }
        return result;
    }

    /**
     * Turns the matrix clockwise.
     */
    private static int [][] getRotateArr(int [][] sourceArr) {
        int [][] retArr = new int[sourceArr[0].length][sourceArr.length];
        int retArrI = 0;
        int retArrJ = sourceArr.length - 1;
        for (int [] srI : sourceArr){
            for (int srJ : srI)
                retArr[retArrI++][retArrJ] = srJ;
            retArrI = 0;
            retArrJ--;
        }
        return retArr;
    }

    /**
     * Returns the magic's const. M<sub>n</sub> = n * (n<sup>2</sup>+1) / 2.
     * @param n the square's size. Needs n > 2.
     * @return the magic's const.
     */
    public static int getMagicConst(int n){
        return n * (n * n + 1) / 2;
    }

    /**
     * Prints the matrix.
     */
    public static void printMatrix(int[][] matrix){
        if (matrix == null) {
            System.out.println("null");
            return;
        }
        for (int[] line : matrix) {
            System.out.println(Arrays.toString(line));
        }
    }
}