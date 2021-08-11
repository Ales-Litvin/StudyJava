package by.epam.introduction_to_java.аlgorithmization_2.arrays_of_arrays.task05;

/*
 * Условие задачи:
 * 5. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 *       |  1     1     1    ...   1    1    1  |
 *       |  2     2     2    ...   2    2    0  |
 *       |  3     3     3    ...   3    0    0  |
 *       | ...   ...   ...   ...  ...  ...  ... |
 *       | n-1   n-1    0    ...   0    0    0  |
 *       |  n    n-1   n-2   ...   0    0    0  |
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
     <tr>     <td>2</td><td>2</td><td>2</td><td>...</td><td>2</td><td>2</td><td>0</td>     </tr>
     <tr>     <td>3</td><td>3</td><td>3</td><td>...</td><td>3</td><td>0</td><td>0</td>     </tr>
     <tr>     <td>...</td><td>...</td><td>...</td><td>...</td><td>...</td><td>...</td><td>...</td>     </tr>
     <tr>     <td>n-1</td><td>n-1</td><td>0</td><td>...</td><td>0</td><td>0</td> <td>0</td>      </tr>
     <tr>     <td>n</td><td>n-1</td><td>n-2</td><td>...</td><td>0</td><td>0</td> <td>0</td>      </tr>
     </table>
     * @param orderOfMatrix the matrix's order.
     * @return the matrix by pattern.
     */
    public static int[][] createMatrixByPattern(int orderOfMatrix){
        int[][] result = new int[orderOfMatrix][orderOfMatrix];

        for (int i = 0; i < result.length; i++){
            for (int j = 0; j < result[i].length - i; j++){
                result[i][j] = i + 1;
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
        System.out.println("=================");
    }
}
