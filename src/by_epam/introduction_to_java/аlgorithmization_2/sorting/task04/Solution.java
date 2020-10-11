package by_epam.introduction_to_java.аlgorithmization_2.sorting.task04;

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

    public static void myExchangesSort(int[] array) {
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length - i - 1; j++){
                if (array[j] < array[j + 1]){
                    int data = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = data;
                }
            }
        }
    }
}