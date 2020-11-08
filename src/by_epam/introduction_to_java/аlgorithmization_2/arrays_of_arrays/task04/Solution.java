package by_epam.introduction_to_java.аlgorithmization_2.arrays_of_arrays.task04;

/*
 * Условие задачи:
 * 4. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 *       |  1     2     3    ...   n |
 *       |  n    n-1   n-2   ...   1 |
 *       |  1     2     3    ...   n |
 *       |  n    n-1   n-2   ...   1 |
 *       | ...   ...   ...   ...  ...|
 *       |  n    n-1   n-2   ...   1 |
 */

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = createMatrixOrderOf(5);

        printMatrix(matrix);
    }


    /**
     * Creates the matrix by pattern:
     <table width="40%">
     <tr>     <td>1</td><td>2</td><td>3</td><td>...</td><td>n</td>     </tr>
     <tr>     <td>n</td><td>n-1</td><td>n-2</td><td>...</td><td>1</td>     </tr>
     <tr>     <td>1</td><td>2</td><td>3</td><td>...</td><td>n</td>     </tr>
     <tr>     <td>n</td><td>n-1</td><td>n-2</td><td>...</td><td>1</td>     </tr>
     <tr>     <td>...</td><td>...</td><td>...</td><td>...</td><td>...</td>     </tr>
     <tr>     <td>1</td><td>2</td><td>3</td><td>...</td><td>n</td>     </tr>
     </table>
     * @param orderOfMatrix the matrix's order.
     * @return the matrix by pattern.
     */
    public static int[][] createMatrixOrderOf(int orderOfMatrix){
        int[][] result = new int[orderOfMatrix][orderOfMatrix];
        for (int i = 0; i < result.length; i++){
            if (i % 2 == 0){
                for (int j = 0; j < result[i].length; j++){
                    result[i][j] = j + 1;
                }
            } else {
                for (int j = 0; j < result[i].length; j++){
                    result[i][j] = result[i].length - j;
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
