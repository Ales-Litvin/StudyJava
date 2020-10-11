package by_epam.introduction_to_java.аlgorithmization_2.sorting.task01;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arrayOne = {1, 2, 3, 4, 5, 6};
        int[] arrayTwo = {7, 8, 9};
        System.out.println(Arrays.toString(unionOfArrays(arrayOne, arrayTwo, 2)));
    }

    public static int[] unionOfArrays(int[] first, int[] second, int index){
        int[] result = new int[first.length + second.length];

        for (int i = 0; i < result.length; i++){
            if (i < index){
                result[i] = first[i];
            } else {
                for (int j = 0; j < second.length; j++, i++){
                    result[i] = second[j];
                }
                for (int k = i - second.length; k < first.length; k++, i++){
                    result[i] = first[k];
                }
                return result;
            }
        }
        return result;
    }
}
