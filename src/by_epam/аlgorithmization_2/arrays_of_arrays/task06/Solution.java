package by_epam.аlgorithmization_2.arrays_of_arrays.task06;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = createMatrixOrderOf(6);

        printMatrix(matrix);
    }

    public static int[][] createMatrixOrderOf(int orderOfMatrix){
        int[][] result = new int[orderOfMatrix][orderOfMatrix];

        for (int i = 0; i < result.length; i++){
            if (i < result.length / 2) {
                for (int j = i; j < result[i].length - i; j++) {
                    result[i][j] = 1;
                }
            } else {
                for (int j = result[i].length - i - 1; j < i + 1; j++) {
                    result[i][j] = 1;
                }
            }
        }
        return result;
    }

    public static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            int[] line = matrix[i];
            System.out.println(Arrays.toString(line));
        }
        System.out.println("=================");
    }
}