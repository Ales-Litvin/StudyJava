package by_epam.аlgorithmization_2.sorting.task05;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arrayOne = {1, 4, 8, 10, 12, 14, 20, 26, 30, 36};
        int[] arrayTwo = {3, 6, 7, 10, 20, 1, 4, 3};
        myInsertsSort(arrayOne);
        myInsertsSort(arrayTwo);

        System.out.println(indexForInsert(arrayOne, 28));
        System.out.println(indexForInsert(arrayOne, 5));
        System.out.println(Arrays.binarySearch(arrayOne, 27));

        System.out.println(Arrays.toString(arrayOne));
        System.out.println(Arrays.toString(arrayTwo));
    }

    public static void myInsertsSort(int[] array) {
        


    }

    public static int indexForInsert(int[] array, int value){
        int index = (array.length / 2) - 1;
        while(true){
            if (array[index] == value) return index;

            if (array[index] < value && array[index + 1] > value) return index;
            if (array[index] > value && array[index - 1] < value) return index;

            if (array[index] < value){
                index = (index + index / 2) - 1;
            } else {
                index = (index / 2) + 1;
            }
        }
    }
}