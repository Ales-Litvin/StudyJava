package by_epam.introduction_to_java.аlgorithmization_2.sorting.task03;

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

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {    // i - номер текущего шага
            int pos = i;
            int min = array[i];
            // цикл выбора наименьшего элемента
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    pos = j;    // pos - индекс наименьшего элемента
                    min = array[j];
                }
            }
            array[pos] = array[i];
            array[i] = min;    // меняем местами наименьший с array[i]
        }
    }
}
