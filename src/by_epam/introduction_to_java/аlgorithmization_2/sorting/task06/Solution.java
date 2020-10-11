package by_epam.introduction_to_java.аlgorithmization_2.sorting.task06;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arrayOne = {1, 5, 8, 9, 4, 3, 5, 7, 20, 4};

        //myInsertionSort(arrayOne);
        //System.out.println(Arrays.toString(arrayOne));

        int[] arrayTwo = {1, 4, 5, 8, 8, 10, 12, 16, 18, 20, 22};

        int[] arrayThree = {1, 2, 4, 3, 5, 22, 16, 12, 17, 20, 4};

        //System.out.println(Arrays.toString(arrayThree));
        System.out.println(Arrays.toString(arrayOne));
    }

    // This just sort, it don't has binarySearch
    public static void myInsertionSort(int[] array){
        // Start with first element, because it's sorting
        for (int i = 1; i < array.length; i++){
            for (int j = i; j > 0 && array[j - 1] > array[j]; j--){
                swap(array, j - 1, j); // change element
            }
        }
    }

    // This method change element
    public static void swap(int[] array, int first, int second){
        int data = array[first];
        array[first] = array[second];
        array[second] = data;
    }
}
