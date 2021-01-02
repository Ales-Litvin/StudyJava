package by.epam.introduction_to_java.аlgorithmization_2.one_dimensional_arrays.task01;

/*
 * Условие задачи:
 * 1. В массив A [N] занесены натуральные числа.
 *    Найти сумму тех элементов, которые кратны данному К.
 */

public class Solution {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6};

        System.out.println(sum(A, 1));
    }

    public static int sum(final int[] array, final int K){
        int result = 0;
        for (int i : array){
            if (i % K == 0){
                result += i;
            }
        }
        return result;
    }
}
