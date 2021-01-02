package by.epam.introduction_to_java.аlgorithmization_2.sorting.task01;

/*
 * Условие задачи:
 * 1. Заданы два одномерных массива с различным количеством элементов и натуральное число k.
 *    Объединить их в один  массив,  включив  второй  массив  между  k-м  и  (k+1)-м  элементами
 *    первого,  при  этом  не  используя дополнительный массив.
 */

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arrayOne = {1, 2, 3, 4, 5, 6};
        int[] arrayTwo = {7, 8, 9};

        System.out.println(Arrays.toString(unionOfArrays(arrayOne, arrayTwo, 2)));
    }

    /**
     * Unions two arrays, starts from {@code index}.
     * @param first the first array.
     * @param second the second array.
     * @param index the starts index.
     * @return the array.
     */
    public static int[] unionOfArrays(int[] first, int[] second, int index){
        int[] result = new int[first.length + second.length];

        for (int i = 0; i < result.length; i++){
            if (i < index){
                result[i] = first[i];
            } else {
                for (int j = 0; j < second.length; j++, i++){
                    result[i] = second[j];
                }
                for (int k = i - second.length; k < first.length; k++, i++){
                    result[i] = first[k];
                }
                return result;
            }
        }
        return result;
    }
}
