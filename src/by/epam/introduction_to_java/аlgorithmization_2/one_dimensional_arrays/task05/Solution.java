package by.epam.introduction_to_java.аlgorithmization_2.one_dimensional_arrays.task05;

/*
 * Условие задачи:
 * 5. Даны целые числа а1 ,а2 ,..., аn.
 *    Вывести на печать только те числа, для которых аi > i.
 */

public class Solution {
    public static void main(String[] args) {
        int[] array = {1, -2, 5, -10, 12, 0, 51 , -99, 100};

        printNumberMoreIndex(array);
    }

    /**
     * Print all the number who а<sub>i</sub>>i.
     * @param array the array of number (а<sub>1</sub>, а<sub>2</sub>, ..., а<sub>n</sub>).
     */
    public static void printNumberMoreIndex(final int[] array){
        for (int i = 0; i < array.length; i++){
            if (array[i] > i) {
                System.out.printf(
                        "a[%1$d]=%2$d > i=%1$d\n",
                        i, array[i]);
            }
        }


    }
}
