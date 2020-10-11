package by_epam.introduction_to_java.аlgorithmization_2.arrays_of_arrays.task11;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = new int[10][20];
        fillingTheMatrix(matrix);
        printMatrix(matrix);
    }

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
        for (int i = 0; i < countFiveInString.length; i++){
            if (countFiveInString[i] >= 3) {
                System.out.println("'" + i + "'");
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