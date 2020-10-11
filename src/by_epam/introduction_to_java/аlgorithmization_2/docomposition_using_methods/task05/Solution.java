package by_epam.introduction_to_java.аlgorithmization_2.docomposition_using_methods.task05;

/*
 * Условие задачи:
 * 5. Составить программу, которая в массиве A[N] находит второе по величине число
 * (вывести на печать число, которое меньше максимального элемента массива, но болше всех других элементов).
 */

public class Solution {
    public static void main(String[] args) {
        int[] arrayOne = {1, 5, 8, 9, 4, 3, 5, 7, 20, 4};

        int[] arrayTwo = {1, 4, 5, 8, 8, 10, 12, 16, 18, 20, 22};

        int[] arrayThree = {1, 2, 4, 3, 5, 22, 16, 12, 17, 20, 4};

        System.out.println(isSecondMax(arrayOne));
    }

    /**
     * Returns second the largest value in the {@param array}
     * @param array a array
     * @return returns second the largest value
     */
    public static int isSecondMax(int[] array){
        int max = isMax(array);
        int secondMax = array[0];
        for (int value : array) {
            if (value > secondMax && value < max) {
                secondMax = value;
            }
        }
        return secondMax;
    }

    /**
     * Returns max value in the {@param array}
     * @param array a array
     * @return returns max value
     */
    public static int isMax(int[] array){
        int max = array[0];
        for (int i = 0; i < array.length; i++){
            if (array[i] > max){
                max = array[i];
            }
        }
        return max;
    }
}
