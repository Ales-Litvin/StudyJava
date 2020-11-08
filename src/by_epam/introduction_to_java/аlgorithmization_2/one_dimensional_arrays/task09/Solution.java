package by_epam.introduction_to_java.аlgorithmization_2.one_dimensional_arrays.task09;

/*
 * Условие задачи:
 * 9. В массиве целых чисел с количеством элементов  n  найти наиболее часто встречающееся число.
 *    Если таких чисел несколько, то определить наименьшее из них.
 */

public class Solution {
    public static void main(String[] args) {
        int[] array = {0, 2, 2, 3, 3, 6, 8, 9, 10, 10};

        System.out.println(searchFrequentNumber(array));
    }

    /**
     * Returns the min frequent number.
     */
    public static int searchFrequentNumber(int[] array){
        int[] buffer = new int[array.length];
        for (int i = 0; i < array.length; i++){
            int count = 0;
            for (int k : array) {
                if (array[i] == k) count++;
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
