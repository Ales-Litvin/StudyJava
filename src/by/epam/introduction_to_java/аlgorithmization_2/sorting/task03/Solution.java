package by.epam.introduction_to_java.аlgorithmization_2.sorting.task03;

/*
 * Условие задачи:
 * 3. Сортировка выбором. Дана последовательность чисел a1 <= a2 <= ...<= an.
 *    Требуется переставить элементы так, чтобы они были расположены по убыванию.
 *    Для этого в массиве, начиная с первого, выбирается наибольший элемент и ставится
 *    на первое место, а первый - на место наибольшего.
 *    Затем, начиная со второго, эта процедура повторяется.
 *    Написать алгоритм сортировки выбором.
 */

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arrayOne = {1, 2, 3, 4, 5, 6};
        int[] arrayTwo = {3, 6, 7, 10, 20, 1, 4, 3};

        mySelectionSort(arrayOne);
        mySelectionSort(arrayTwo);

        System.out.println(Arrays.toString(arrayOne));
        System.out.println(Arrays.toString(arrayTwo));
    }

    /**
     * Sorts the array uses the selection method.
     * @param array the array to be sorting (a<sub>1</sub> &le; a<sub>2</sub> &le; ... &le; a<sub>n</sub>).
     */
    public static void mySelectionSort(int[] array){
       for (int i = 0; i < array.length; i++){
           int indexMax = i;
           int valueMax = array[i];
           for (int j = i; j < array.length; j++){
               if (array[j] > valueMax){
                   valueMax = array[j];
                   indexMax = j;
               }
           }
           array[indexMax] = array[i];
           array[i] = valueMax;
       }
    }
}
