package by_epam.аlgorithmization_2.one_dimensional_arrays.task10;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // [0, 0, 2, 0, 4, 0, 6, 0, 8, 0, 10]
        // [0, 2, 4, 6, 8, , 10, 0, 0, 0, 0, 0]
        System.out.println(Arrays.toString(array));
        squeezeArray(array);
        System.out.println(Arrays.toString(array));

    }

    public static void squeezeArray(int[] array){
        // deleted all second element
        for (int i = 0; i < array.length; i++){
            if (i % 2 != 0){
                 array[i] = 0;
            }
        }
        // squeeze array
        System.out.println(Arrays.toString(array));
        for (int i = 1; i < array.length / 2; i++) {
            for (int k = i; k < array.length - 1; k++) {
                int data = array[k];
                array[k] = array[k + 1];
                array[k + 1] = data;
            }
        }
    }
}