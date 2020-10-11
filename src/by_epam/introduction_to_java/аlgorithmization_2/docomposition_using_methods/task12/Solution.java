package by_epam.introduction_to_java.аlgorithmization_2.docomposition_using_methods.task12;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arrayOne = new int[5];

        fillingTheArray(arrayOne, 10, 7);

        System.out.println(Arrays.toString(arrayOne));


    }

    public static void fillingTheArray(int[] array, int k, int n){

        for (int i = 0, j = 1; i < array.length && j <= n; j++){
            int sum = sumElements(array, 0, array.length);

            if (sum == k){
                break;
            } else if (sum + j <= k) {
                array[i] = j;
                i++;
            }
            if (j == n) j = 0;
        }
    }

    public static int sumElements(int[] array, int fromIndex, int toIndex){
        int result = 0;
        for (int i = fromIndex; i < toIndex; i++){
            result += array[i];
        }
        return result;
    }
}
