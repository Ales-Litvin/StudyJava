package javarush.task.task39.task3912;

/*
Максимальная площадь
Реализуй метод int maxSquare(int[][] matrix), возвращающий площадь самого
большого квадрата состоящего из единиц
в двумерном массиве matrix.
Массив matrix заполнен только нулями и единицами.

Требования:
1. Метод maxSquare должен быть реализован в соответствии с условием задачи.
2. Метод maxSquare должен эффективно работать с большими массивами.
3. Метод maxSquare должен быть публичным.
4. Метод maxSquare должен возвращать число типа int.
5. Метод maxSquare должен быть статическим.
*/

import java.util.Arrays;

public class Solution {
    public static int[][] matrixOne = new int[][]{
                    {0, 0, 1, 1, 1},
                    {1, 0, 1, 1, 1},
                    {0, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0}};

    public static int[][] matrixTwo = new int[][]{
                    {1, 1, 1, 1},
                    {1, 0, 0, 1},
                    {1, 0, 1, 1},
                    {1, 1, 1, 1}};


    public static void main(String[] args) {
        System.out.println(maxSquare(matrixOne));
        System.out.println(maxSquare(matrixTwo));
    }

    public static int maxSquare(int[][] matrix) {
        int side = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (i * j == 0)
                    continue;

                if (matrix[i][j] == 1)
                    matrix[i][j] = Math.min(matrix[i][j - 1], Math.min(matrix[i - 1][j], matrix[i - 1][j - 1])) + 1;

                if (matrix[i][j] > side)
                    side = matrix[i][j];
            }
        }

        return side * side;
    }

    public static void printMatrix(int[][] matrix){
        System.out.println("--------------------------------------");
        for (int[] ints : matrix){
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("--------------------------------------");
    }
}
