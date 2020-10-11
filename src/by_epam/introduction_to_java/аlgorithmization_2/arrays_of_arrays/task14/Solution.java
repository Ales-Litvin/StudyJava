package by_epam.introduction_to_java.аlgorithmization_2.arrays_of_arrays.task14;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = createMatrix(10, 10);
        printMatrix(matrix);
    }

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


    public static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            int[] line = matrix[i];
            System.out.println(Arrays.toString(line));
        }
        System.out.println("=================");
    }
}