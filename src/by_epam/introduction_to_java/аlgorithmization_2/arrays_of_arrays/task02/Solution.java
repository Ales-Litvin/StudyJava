package by_epam.introduction_to_java.аlgorithmization_2.arrays_of_arrays.task02;

public class Solution {
    public static final int[][] MATRIX =   {{1, 8, 3},
                                            {4, 5, 6},
                                            {7, 2, 9}};

    public static void main(String[] args) {
        printDiagonalElements(MATRIX);
    }

    public static void printDiagonalElements(int[][] matrix){
        System.out.print(" | ");
        for (int i = 0; i < matrix.length; i++){
            System.out.print(matrix[i][i] + " | ");
        }
    }
}
