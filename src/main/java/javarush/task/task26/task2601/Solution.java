package javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        int median;
        if (array.length % 2 != 0) median = array[array.length / 2];
        else median = (array[array.length / 2 - 1] + array[array.length / 2]) / 2;

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int deltaOfMedianO1 = Math.abs(median - (int) o1);
                int deltaOfMedianO2 = Math.abs(median - (int) o2);

                if ((int) o1 == median) return -1;
                if ((int) o2 == median) return 1;

                if (deltaOfMedianO1 < deltaOfMedianO2) return -1;
                else if (deltaOfMedianO1 == deltaOfMedianO2) return 0;
                else return 1;
            }
        };
        Arrays.sort(array, comparator);
        return array;
    }
}