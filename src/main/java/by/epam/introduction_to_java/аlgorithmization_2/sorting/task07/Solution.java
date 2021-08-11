package by.epam.introduction_to_java.аlgorithmization_2.sorting.task07;

/*
 * Условие задачи:
 * 7.  Пусть  даны  две  неубывающие  последовательности  действительных  чисел
 *     a1 <= a2 <= ...<= an и b1 <= b2 <= ... <= bm.
 *     Требуется указать те места, на которые нужно вставлять элементы
 *     последовательности b1 <= b2 <= ... <= bm в первую последовательность так,
 *     чтобы новая последовательность оставалась возрастающей.
 */

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arrayOne = {1, 4, 8, 10, 12, 14, 20, 26, 30, 36};
        int[] arrayTwo = {1, 3, 4, 4, 6, 7, 10, 20};

        getIndexesOfInsert(arrayOne, arrayTwo);
    }

    /**
     * Prints the indexes for insert elements from the second array to the first array.
     * @param first the first array (a<sub>1</sub> &le; a<sub>2</sub> &le; ... &le; a<sub>n</sub>)
     * @param second the second array (b<sub>1</sub> &le; b<sub>2</sub> &le; ... &le; b<sub>m</sub>).
     */
    public static void getIndexesOfInsert(int[] first, int[] second){
        for (int i : second){
            System.out.printf(
                    "Element value='%d' insert to position'%d'.\n",
                    i, isIndexOfInsert(first, i));
        }
    }

    /**
     * Returns the insert's index for key.
     * @param array the array to be searched
     * @param key the value for searching insert's index
     * @return the insert's index for key.
     */
    public static int isIndexOfInsert(int[] array, int key){
        for (int i = 1; i < array.length; i++){
            if (array[i - 1] <= key && array[i] > key){
                return i;
            }
        }
        return -1;
    }
}
