package by_epam.introduction_to_java.аlgorithmization_2.docomposition_using_methods.task12;

/*
 * Условие задачи:
 * 12. Даны  натуральные числа К  и  N.  Написать метод(методы)  формирования массива  А,
 *     элементами  которого являются числа, сумма цифр которых равна К и которые не большее N.
 * Не решена!!
 */

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arrayOne = new int[2];

        fillingTheArray(arrayOne, 10, 7);

        System.out.println(Arrays.toString(arrayOne));
    }

    public static void fillingTheArrayTwo(int[] array, int k, int n){
        for (int i = 0, j = 1; i < array.length && j <= n; j++){



            int sum = sum(array, 0, array.length);

            if (sum == k){
                break;
            } else if (sum + j <= k) {
                array[i] = j;
                i++;
            }
            if (j == n) j = 0;
        }
    }

    /**
     * Fills the {@code array} with numbers, sum of whose are not more than {@code k},
     *         and value of numbers are not more {@code n}.
     * @param array the array to be filling
     * @param k the sum of array's numbers
     * @param n the max value in the array
     */
    public static void fillingTheArray(int[] array, int k, int n){
        for (int i = 0, j = 1; i < array.length && j <= n; j++){
            int sum = sum(array, 0, array.length);

            if (sum == k){
                break;
            } else if (sum + j <= k) {
                array[i] = j;
                i++;
            }
            if (j == n) j = 0;
        }
    }

    /**
     * Sums elements from the {@code fromIndex} to the {@code toIndex}.
     * @param array the array
     * @param fromIndex the index of the first element, inclusive
     * @param toIndex the index of the last element, exclusive
     * @return the sum of from the {@code fromIndex} to the {@code toIndex}.
     */
    public static int sum(int[] array, int fromIndex, int toIndex){
        int result = 0;
        for (int i = fromIndex; i < toIndex; i++){
            result += array[i];
        }
        return result;
    }
}
