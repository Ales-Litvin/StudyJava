package by_epam.introduction_to_java.аlgorithmization_2.arrays_of_arrays.task06;

/*
 * Условие задачи:
 * 6. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 *       |  1     1     1    ...   1    1    1  |
 *       |  0     1     1    ...   1    1    0  |
 *       |  0     0     1    ...   1    0    0  |
 *       | ...   ...   ...   ...  ...  ...  ... |
 *       |  0     1     1    ...   1    1    0  |
 *       |  1     1     1    ...   1    1    1  |
 */

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = createMatrixByPattern(6);

        printMatrix(matrix);
    }

    /**
     * Creates the matrix by pattern:
     <table width="30%">
     <tr>     <td>1</td><td>1</td><td>1</td><td>...</td><td>1</td><td>1</td><td>1</td>     </tr>
     <tr>     <td>0</td><td>1</td><td>1</td><td>...</td><td>1</td><td>1</td><td>0</td>     </tr>
     <tr>     <td>0</td><td>0</td><td>1</td><td>...</td><td>1</td><td>0</td><td>0</td>     </tr>
     <tr>     <td>...</td><td>...</td><td>...</td><td>...</td><td>...</td><td>...</td><td>...</td>     </tr>
     <tr>     <td>0</td><td>1</td><td>1</td><td>...</td><td>1</td><td>1</td><td>0</td>     </tr>
     <tr>     <td>1</td><td>1</td><td>1</td><td>...</td><td>1</td><td>1</td><td>1</td>     </tr>
     </table>
     * @param orderOfMatrix the matrix's order.
     * @return the matrix by pattern.
     */
    public static int[][] createMatrixByPattern(int orderOfMatrix){
        int[][] result = new int[orderOfMatrix][orderOfMatrix];

        for (int i = 0; i < result.length; i++){
            if (i < result.length / 2) {
                for (int j = i; j < result[i].length - i; j++) {
                    result[i][j] = 1;
                }
            } else {
                for (int j = result[i].length - i - 1; j < i + 1; j++) {
                    result[i][j] = 1;
                }
            }
        }
        return result;
    }

    /**
     * Prints the matrix.
     * @param matrix the matrix.
     */
    public static void printMatrix(int[][] matrix){
        for (int[] line : matrix) {
            System.out.println(Arrays.toString(line));
        }
    }
}