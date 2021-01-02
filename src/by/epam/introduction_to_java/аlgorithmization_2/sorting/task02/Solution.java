package by.epam.introduction_to_java.аlgorithmization_2.sorting.task02;

/*
 * Условие задачи:
 * 2. Даны две последовательности a1 <= a2 <= ...<= an и b1 <= b2 <= ... <= bm.
 *    Образовать из них новую последовательность чисел так, чтобы она тоже была неубывающей.
 *    Примечание. Дополнительный массив не использовать.
 */

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arrayOne = {1, 2, 3, 4, 5, 6};
        int[] arrayTwo = {3, 6, 7};

        System.out.println(Arrays.toString(combiningSequences(arrayTwo, arrayOne)));
    }

    /**
     * Returns the array in the ascending order, uses {@code first} and {@code second}.
     * @param first the first array (a<sub>1</sub> &le; a<sub>2</sub> &le; ... &le; a<sub>n</sub>).
     * @param second the second array (b<sub>1</sub> &le; b<sub>2</sub> &le; ... &le; b<sub>m</sub>).
     * @return the array, containing elements from the {@code first} and the {@code second} arrays,
     *         in the ascending order.
     */
    public static int[] combiningSequences(int[] first, int[] second){
        int[] result = new int[first.length + second.length];

        for (int i = 0, j = 0, k = 0; i < result.length; i++){
            if ((j < first.length && k < second.length) && first[j] < second[k]) {
                result[i] = first[j];
                j++;
            } else if (k < second.length){
                result[i] = second[k];
                k++;
            } else if (j < first.length) {
                result[i] = first[j];
                j++;
            }
        }
        return result;
    }
}