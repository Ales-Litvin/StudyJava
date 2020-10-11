package by_epam.introduction_to_java.аlgorithmization_2.one_dimensional_arrays.task02;

public class Solution {
    public static void main(String[] args) {

    }

    public static int replacementWhoMoreZ(final int[] array, final int Z){
        int count = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] > Z) {
                array[i] = Z;
                count++;
            }
        }
        return count;
    }
}
