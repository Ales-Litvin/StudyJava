package by_epam.introduction_to_java.аlgorithmization_2.arrays_of_arrays.task03;

public class Solution {
    public static final int[][] MATRIX =   {{1, 8, 3},
                                            {4, 5, 6},
                                            {7, 2, 9}};

    public static void main(String[] args) {
        printLineMatrix(MATRIX, 1);
        printСolumnMatrix(MATRIX, 2);

    }

    public static void printLineMatrix(int[][] matrix, int line){
        System.out.print(" | ");
        for (int i = 0; i < matrix.length; i++){
            System.out.print(matrix[line][i] + " | ");
        }
        System.out.println();
    }

    public static void printСolumnMatrix(int[][] matrix, int column){
        System.out.print(" | ");
        for (int i = 0; i < matrix.length; i++){
            System.out.print(matrix[i][column] + " | ");
        }
        System.out.println();
    }
}
