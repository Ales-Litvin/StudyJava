package by_epam.introduction_to_java.аlgorithmization_2.sorting.task02;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arrayOne = {1, 2, 3, 4, 5, 6};
        int[] arrayTwo = {3, 6, 7};
        System.out.println(Arrays.toString(combiningSequences(arrayTwo, arrayOne)));
    }

    public static int[] combiningSequences(int[] first, int[] second){
        int[] result = new int[first.length + second.length];

        for (int i = 0, j = 0, k = 0; i < result.length; i++){
            if ((j < first.length && k < second.length) && first[j] < second[k]) {
                result[i] = first[j];
                j++;
            } else if (k < second.length){
                result[i] = second[k];
                k++;
            } else if (j < first.length) {
                result[i] = first[j];
                j++;
            }
        }
        return result;
    }

}
