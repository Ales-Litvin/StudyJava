package by_epam.аlgorithmization_2.one_dimensional_arrays.task04;

public class Solution {
    public static void main(String[] args) {

    }

    public static void replacementMinAndMax(final int[] array){
        int max = 0;
        int min = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] > max){ max = array[i]; }
            if (array[i] < min){min = array[i]; }
        }

        for (int i = 0; i < array.length; i++){
            if (array[i] == max){ array[i] = min; }
            if (array[i] == min){array[i] = max; }
        }

    }
}
