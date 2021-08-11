package by.epam.introduction_to_java.аlgorithmization_2.arrays_of_arrays.task14;

/*
 * Условие задачи:
 * 14.  Сформировать случайную матрицу m  x  n, состоящую из нулей и единиц,
 *      причем в каждом столбце число единиц равно номеру столбца.
 */

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = createMatrix(10, 10);

        printMatrix(matrix);
    }

    /**
     * Returns the matrix containing only '0' or '1'.
     * Amount of '1' in the column, equals the column's number.
     * Amount of lines needs be, more or equals than amount columns.
     * @param m amount of lines.
     * @param n amount of columns.
     * @return the array.
     */
    public static int[][] createMatrix(int m, int n){
        int[][] result = new int[m][n];
        int[] countOne = new int[n];
        for (int i = 0; i < result.length; i++){
            for (int j = 0; j < result[i].length; j++){
                int current = (int) (Math.random() * 2);
                if (current == 1 && countOne[j] <= j){
                    result[i][j] = current;
                    countOne[j] = countOne[j] + 1;
                } else if (countOne[j] <= j && result.length - i <= j){
                    result[i][j] = 1;
                    countOne[j] = countOne[j] + 1;
                } else {
                    result[i][j] = 0;
                }
            }
        }
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