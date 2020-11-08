package by_epam.introduction_to_java.аlgorithmization_2.one_dimensional_arrays.task10;

/*
 * Условие задачи:
 * 10.  Дан  целочисленный  массив  с  количеством  элементов  n.
 *      Сжать  массив,  выбросив  из  него  каждый  второй элемент (освободившиеся элементы заполнить нулями).
 *      Примечание. Дополнительный массив не использовать.
 */

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12};

        squeezeArray(array);

        System.out.println(Arrays.toString(array));
        // output: [0, 2, 4, 6, 8, 10, 0, 0, 0, 0, 0]
    }

    /**
     * Squeezes the array, deleting each second element.
     * @param array the array fo number.
     */
    public static void squeezeArray(int[] array){
        // deletes all second element
        for (int i = 0; i < array.length; i++){
            if (i % 2 != 0){
                 array[i] = 0;
            }
        }

        // squeeze array
        for (int i = 1; i < array.length / 2 + 1; i++) {
            for (int k = i; k < array.length - 1; k++) {
                int data = array[k];
                array[k] = array[k + 1];
                array[k + 1] = data;
            }
        }
    }
}