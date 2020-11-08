package by_epam.introduction_to_java.аlgorithmization_2.arrays_of_arrays.task11;

/*
 * Условие задачи:
 * 11. Матрицу 10x20 заполнить случайными числами от 0 до 15.
 *     Вывести на экран саму матрицу и номера строк, в которых число 5 встречается три и более раз.
 */

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = new int[10][20];

        fillingTheMatrix(matrix);

    }

    /**
     * Fillings the matrix random numbers from '0' to '15',
     * then prints the matrix.
     * Prints the index of lines who contains more three '5'.
     * @param matrix the matrix for filling.
     */
    public static void fillingTheMatrix(int[][] matrix){
        int[] countFiveInString = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
              matrix[i][j] = (int) (Math.random() * 15);
              if (matrix[i][j] == 5) {
                  countFiveInString[i] = countFiveInString[i] + 1;
              }
            }
        }
        printMatrix(matrix);

        for (int i = 0; i < countFiveInString.length; i++){
            if (countFiveInString[i] >= 3) {
                System.out.println("'" + i + "'");
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