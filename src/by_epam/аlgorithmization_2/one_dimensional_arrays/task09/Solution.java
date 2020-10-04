package by_epam.аlgorithmization_2.one_dimensional_arrays.task09;

public class Solution {
    public static void main(String[] args) {
        int[] array = {0, 2, 2, 3, 3, 6, 8, 9, 10, 10};
        System.out.println(searchFrequentNumber(array));
    }

    public static int searchFrequentNumber(int[] array){
        int[] buffer = new int[array.length];
        for (int i = 0; i < array.length; i++){
            int count = 0;
            for (int j = 0; j < array.length; j++){
                if (array[i] == array[j]) count++;
            }
            buffer[i] = count;
        }
        int maxCount = buffer[0];
        int minValue = array[0];
        for (int i = 0; i < buffer.length; i++){
            if (buffer[i] > maxCount) {
                maxCount = buffer[i];
                minValue = array[i];
            } else if (buffer[i] == maxCount && minValue > array[i]){
                minValue = array[i];
            }
        }
        return minValue;
    }
}
