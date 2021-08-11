package by.epam.introduction_to_java.аlgorithmization_2.sorting.task04;

/*
 * Условие задачи:
 * 4.  Сортировка  обменами.  Дана  последовательность  чисел a1 <= a2 <= ...<= an.
 *     Требуется  переставить  числа  в порядке  возрастания. Для  этого  сравниваются
 *     два  соседних  числа аi и аi+1. Если аi > аi+1, то  делается перестановка.
 *     Так продолжается до тех пор, пока все элементы не станут расположены в порядке возрастания.
 *     Составить алгоритм сортировки, подсчитывая при этом количества перестановок.
 */

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arrayOne = {1, 2, 3, 4, 5, 6};
        int[] arrayTwo = {3, 6, 7, 10, 20, 1, 4, 3};

        myExchangesSort(arrayOne);
        myExchangesSort(arrayTwo);

        System.out.println(Arrays.toString(arrayOne));
        System.out.println(Arrays.toString(arrayTwo));
    }

    /**
     * Sorts the array uses the exchange method.
     * Counts changes.
     * @param array the array to be sorting (a<sub>1</sub> &le; a<sub>2</sub> &le; ... &le; a<sub>n</sub>).
     */
    public static void myExchangesSort(int[] array) {
        int countSwap = 0;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length - i - 1; j++){
                if (array[j] > array[j + 1]){
                    int data = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = data;

                    countSwap++;
                }
            }
        }

        System.out.println("Количество перестановок - '" + countSwap + "'.");
    }
}