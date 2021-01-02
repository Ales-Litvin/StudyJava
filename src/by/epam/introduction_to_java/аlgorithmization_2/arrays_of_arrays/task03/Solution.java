package by.epam.introduction_to_java.аlgorithmization_2.arrays_of_arrays.task03;

/*
 * Условие задачи:
 * 3. Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
 */
public class Solution {
    public static final int[][] MATRIX = {
            {1, 8, 3, 4, 8},
            {4, 5, 6, 6, 4},
            {7, 2, 9, 4, 6},
            {4, 4, 0, 1, 6},
            {7, 2, 9, 4, 6}};

    public static void main(String[] args) {
        printLineMatrix(MATRIX, 1);
        printColumnMatrix(MATRIX, 2);

    }

    /**
     * Prints the line of the matrix.
     * @param matrix the matrix.
     * @param line the number of line.
     */
    public static void printLineMatrix(int[][] matrix, int line){
        System.out.print(" | ");
        for (int i = 0; i < matrix.length; i++){
            System.out.print(matrix[line][i] + " | ");
        }
        System.out.println();
    }

    /**
     * Prints the column of the matrix.
     * @param matrix the matrix.
     * @param column the number of column.
     */
    public static void printColumnMatrix(int[][] matrix, int column){
        System.out.print(" | ");
        for (int[] ints : matrix) {
            System.out.print(ints[column] + " | ");
        }
        System.out.println();
    }
}
