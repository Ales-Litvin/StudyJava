package by.epam.introduction_to_java.аlgorithmization_2.sorting.task06;

/*
 * Условие задачи:
 * 6.  Сортировка  Шелла.  Дан  массив  n  действительных  чисел.
 *     Требуется  упорядочить  его  по  возрастанию.
 *     Делается это следующим образом: сравниваются два соседних элемента ai и аi+1.
 *     Если ai < аi+1, то продвигаются на  один  элемент  вперед.
 *     Если ai > аi+1 ,  то  производится  перестановка  и  сдвигаются  на  один  элемент  назад.
 *     Составить алгоритм этой сортировки.
 */

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arrayOne = {1, 4, 8, 10, 12, 14, 20, 26, 30, 36};
        int[] arrayTwo = {3, 6, 7, 10, 20, 1, 4, 3};

        shellSort(arrayOne);
        shellSort(arrayTwo);

        System.out.println(Arrays.toString(arrayOne));
        System.out.println(Arrays.toString(arrayTwo));
    }

    /**
     * Sorts the array, uses the Shell method.
     * @param array the array to be sorting.
     */
    public static void shellSort(int[] array){
        for (int i = 1; i < array.length; i++){
            for (int j = i; j > 0 && array[j - 1] > array[j]; j--){
                swap(array, j, j - 1);
            }
        }
    }

    /**
     * Swaps the elements from {@code fromIndex} to {@code toIndex}.
     * @param array the array for swapping elements
     * @param fromIndex the index of the first element, to be swaps
     * @param toIndex the index of the second element, to be swaps
     */
    public static void swap(int[] array, int fromIndex, int toIndex){
        int data = array[toIndex];
        array[toIndex] = array[fromIndex];
        array[fromIndex] = data;
    }
}
