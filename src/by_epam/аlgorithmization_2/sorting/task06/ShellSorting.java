package by_epam.аlgorithmization_2.sorting.task06;

import java.util.Arrays;

public class ShellSorting {
    public static void main(String[] args) {
        int[] arrayOne = {1, 4, 8, 10, 12, 14, 20, 26, 30, 36};
        int[] arrayTwo = {3, 6, 7, 10, 20, 1, 4, 3};

        shellSorting(arrayOne);
        shellSorting(arrayTwo);

        System.out.println(Arrays.toString(arrayOne));
        System.out.println(Arrays.toString(arrayTwo));
    }

    public static void shellSorting(int[] array){
        for (int i = 1; i < array.length; i++){
            for (int j = i; j > 0 && array[j - 1] > array[j]; j--){
                swap(array, j, j - 1);
            }
        }
    }


    public static void swap(int[] array, int formIndex, int toIndex){
        int data = array[toIndex];
        array[toIndex] = array[formIndex];
        array[formIndex] = data;
    }
}
