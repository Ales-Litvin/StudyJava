package by_epam.introduction_to_java.аlgorithmization_2.arrays_of_arrays.task12;

import java.util.Arrays;

public class Solution {
    public static final int[][] MATRIX =   {{1, 8, 3, 9},
            {4, 5, 6, 2},
            {7, 2, 9, 8},
            {6, 1, 8, 7}};

    public static void main(String[] args) {

        sortingStrings(MATRIX);

        printMatrix(MATRIX);
    }

    public static void sortingStrings(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for (int k = 0; k < matrix[i].length; k++){
                for (int m = 0; m < matrix[i].length - k - 1; m++){
                    if (matrix[i][m] > matrix[i][m + 1]){
                        int data = matrix[i][m];
                        matrix[i][m] = matrix[i][m + 1];
                        matrix[i][m + 1] = data;
                    }
                }
            }
        }
    }

    public static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            int[] line = matrix[i];
            System.out.println(Arrays.toString(line));
        }
        System.out.println("=================");
    }
}
