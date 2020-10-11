package by_epam.introduction_to_java.аlgorithmization_2.one_dimensional_arrays.task01;

public class Solution {
    public static void main(String[] args) {

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
