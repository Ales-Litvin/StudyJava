package by_epam.аlgorithmization_2.sorting.task08;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arrayOne = {1, 4, 8, 10, 12, 14, 20, 26, 30, 36};
        int[] arrayTwo = {1, 4, 3, 3, 6, 7, 10, 20};

        int[][] fraction = {
                {1, 4, 3, 3},
                {4, 8, 2, 8}};

        leadingToCommonDenominator(fraction);

        printMatrix(fraction);

    }


    public static void leadingToCommonDenominator(int[][] array) {
        for (int i = 1; i <= array.length; i++){
            if (array[1][i - 1] != array[1][i]){
                int nok = isNok(array[1][i - 1], array[1][i]);
                bringingToNok(array, i, nok);
                bringingToNok(array, i - 1, nok);
            }
        }
        sortFraction(array[0]);
    }

    public static void bringingToNok(int[][] array, int index, int nok){
        int factor = nok / array[1][index];
        array[1][index] *= factor;
        array[0][index] *= factor;
    }

    public static int isNok(int a, int b){
        if (a == b) return a;
        if (a > b && a % b == 0){
            return a;
        } else if (b > a && b % a == 0){
            return b;
        } else {
            return a * b;
        }
    }

    public static void sortFraction(int[] array){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length - i - 1; j++){
                if (array[j] > array[j + 1]){
                    int data = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = data;
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
