package by_epam.introduction_to_java.аlgorithmization_2.arrays_of_arrays.task02;

/*
 * Условие задачи:
 * 2. Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.
 */
public class Solution {
    public static final int[][] MATRIX = {
            {1, 8, 3, 4, 8},
            {4, 5, 6, 6, 4},
            {7, 2, 9, 4, 6},
            {4, 4, 0, 1, 6},
            {7, 2, 9, 4, 6}};

    public static void main(String[] args) {
        printDiagonalElements(MATRIX);
    }

    /**
     * Prints all elements, that are the diagonal.
     * @param matrix a matrix.
     */
    public static void printDiagonalElements(int[][] matrix){
        System.out.print(" | ");
        for (int i = 0; i < matrix.length; i++){
            System.out.print(matrix[i][i] + " | ");
        }
    }
}
