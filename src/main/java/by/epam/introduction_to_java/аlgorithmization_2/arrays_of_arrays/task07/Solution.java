package by.epam.introduction_to_java.аlgorithmization_2.arrays_of_arrays.task07;

/*
 * Условие задачи:
 * 7. Сформировать квадратную матрицу порядка N по правилу:
 *    А[J, I] = sin((I^2 - J^2) / N)
 *    и подсчитать количество положительных элементов в ней.
 */

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        double[][] matrix = createMatrixByPattern(6);

        printMatrix(matrix);
    }

    /**
     * Creates the matrix by pattern:
     * A[J, I] = sin( ( I<sup>2</sup> - J<sup>2</sup>) / N)
     * @param orderOfMatrix the matrix's order.
     * @return the matrix by pattern.
     */
    public static double[][] createMatrixByPattern(int orderOfMatrix){
        double[][] result = new double[orderOfMatrix][orderOfMatrix];
        int count = 0;
        for (int i = 0; i < result.length; i++){
            for (int j = 0; j < result[i].length; j++){
                result[i][j] = Math.sin(((i * i) - (j * j)) / (double) result.length);
                if (result[i][j] > 0) {
                    count++;
                }
            }
        }
        System.out.println("Количество положительных элементов : " + count);
        return result;
    }

    /**
     * Prints the matrix.
     * @param matrix the matrix.
     */
    public static void printMatrix(double[][] matrix){
        for (double[] line : matrix) {
            System.out.printf("[%.3f", line[0]);
            for (int i = 1; i < line.length; i++){
                System.out.printf(", %.3f", line[i]);
            }
            System.out.print("]\n");
        }
    }
}