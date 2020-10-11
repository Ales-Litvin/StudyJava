package by_epam.introduction_to_java.аlgorithmization_2.arrays_of_arrays.task07;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        double[][] matrix = createMatrixOrderOf(6);

        printMatrix(matrix);
    }

    public static double[][] createMatrixOrderOf(int orderOfMatrix){
        double[][] result = new double[orderOfMatrix][orderOfMatrix];
        int count = 0;
        for (int i = 0; i < result.length; i++){
            for (int j = 0; j < result[i].length; j++){
                result[i][j] = Math.sin(((i * i) - (j * j)) / result.length);
                if (result[i][j] > 0) {
                    count++;
                }
            }
        }
        System.out.println("Количество положительных элементов : " + count);
        return result;
    }

    public static void printMatrix(double[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            double[] line = matrix[i];
            System.out.println(Arrays.toString(line));
        }
        System.out.println("=================");
    }
}