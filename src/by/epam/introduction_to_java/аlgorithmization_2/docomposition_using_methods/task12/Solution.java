package by.epam.introduction_to_java.аlgorithmization_2.docomposition_using_methods.task12;

/*
 * Условие задачи:
 * 12. Даны  натуральные числа К и N. Написать метод(методы) формирования
 *     массива А, элементами которого являются числа, сумма цифр которых равна
 *     К и которые не большее N.
 */

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] arrayOne = new int[8];

        fillingTheArrayTwo(arrayOne, 60, 25);

        System.out.println(Arrays.toString(arrayOne));

        System.out.println("Sum of number: " + sum(arrayOne));
    }

    /**
     * Fills array with numbers less {@code n}, and sum {@code k}.
     * @param array the array to be filling
     * @param k the sum in the array
     * @param n the max value in the array
     * @throws Exception if array can't be fill, array too small or
     *                   {@code k} too big;
     *                   if {@code k} or {@code n} less '0'.
     */
    public static void fillingTheArrayTwo(int[] array, int k, int n)
            throws Exception {

        if (k < 0 ) {
            throw new Exception("k=" + k + " < 0");
        } else if (n < 0) {
            throw new Exception("n=" + n + " < 0");
        } else if (array.length == 1 && k > n) {
            throw new Exception("Array can't be fill, array too small.");
        } else if (array.length == 1 && k < n) {
            array[0] = k;
            return;
        }

        for (int i = 0; i < array.length && sum(array) < k; i++){
            int sum = sum(array);
            int remainder = k - sum;

            if (remainder < n){
                array[i] = remainder;
            } else {
                array[i] = n - 1;
            }

            if (i == array.length - 1 && sum(array) != k) {
                throw new Exception("Array can't be fill, array too small.");
            }
        }

        replaceZeroElements(array);
    }

    /**
     * Replaces equal '0' elements, separating it to random numbers.
     * (Заменяет элементы равные '0', разделяя ненулевые элементы на два
     * случайных числа)
     * @param array the array
     */
    public static void replaceZeroElements(int[] array){
        for (int i = 0; i < array.length; i++){
            for (int j = i + 1; j < array.length; j++){
                if (array[j] == 0){
                    array[j] = (int) (Math.random() * array[i]);
                    array[i] = array[i] - array[j];
                }
            }
        }
    }

    /**
     * Fills the {@code array} with numbers, sum of whose are not more than
     * {@code k}, and value of numbers are not more {@code n}.
     * @param array the array to be filling
     * @param k the sum of array's numbers
     * @param n the max value in the array.
     */
    public static void fillingTheArray(int[] array, int k, int n){
        for (int i = 0, j = 1; i < array.length && j <= n; j++){
            int sum = sum(array);

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

    /**
     * Sums all elements.
     * @param array the array
     * @return the sum of all elements.
     */
    public static int sum(int[] array){
        return sum(array, 0, array.length);
    }
}
