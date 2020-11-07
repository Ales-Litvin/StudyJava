package by_epam.introduction_to_java.аlgorithmization_2.one_dimensional_arrays.task02;

/*
 * Условие задачи:
 * 2. Дана последовательность действительных чисел  а<sub>1</sub>, а<sub>2</sub>, ..., а<sub>n</sub>.
 *    Заменить все ее члены, большие данного Z, этим числом. Подсчитать количество замен.
 */

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] array = {1, 2, 5, 10, 12, 84, 51 , 99, 100};

        System.out.println(Arrays.toString(array));

        System.out.printf("Number of replacements - '%d'\n", replacementWhoMoreZ(array, 80));

        System.out.println(Arrays.toString(array));

    }

    /**
     * Replacements in the {@code array} all number who more than {@code Z}.
     * @param array the array of number (а<sub>1</sub>, а<sub>2</sub>, ..., а<sub>n</sub>).
     * @param Z the number for replacement.
     * @return the count of replace.
     */
    public static int replacementWhoMoreZ(final int[] array, final int Z){
        int count = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] > Z) {
                array[i] = Z;
                count++;
            }
        }
        return count;
    }
}
