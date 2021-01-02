package by.epam.introduction_to_java.аlgorithmization_2.arrays_of_arrays.task01;

/*
 * Условие задачи:
 * 1. Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего.
 */
public class Solution {
    public static final int[][] MATRIX = {
            {1, 8, 3, 4},
            {4, 5, 6, 6},
            {7, 2, 9, 4},
            {4, 4, 0, 1}};

    public static void main(String[] args) {
        printAllColumnWhereFirstMoreLast(MATRIX);
    }

    /**
     * Prints all columns, where the first element more than the last element.
     * @param matrix a matrix.
     */
    public static void printAllColumnWhereFirstMoreLast(int[][] matrix){
        for (int i = 1; i < matrix.length; i += 2){
            if (matrix[0][i] > matrix[matrix.length - 1][i]){
                System.out.print(matrix[0][i]);
                for (int j = 1; j < matrix.length; j++){
                    System.out.print(" | " + matrix[j][i]);
                }
                System.out.println();
            }
        }
    }
}