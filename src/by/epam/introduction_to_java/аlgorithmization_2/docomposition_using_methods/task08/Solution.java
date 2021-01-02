package by.epam.introduction_to_java.аlgorithmization_2.docomposition_using_methods.task08;

/*
 * Условие задачи:
 * 8. Задан массив D. Определить следующие суммы:
 *    D[1] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].
 *    Пояснение.  Составить  метод(методы)  для вычисления суммы трех
 *    последовательно расположенных элементов массива с номерами от k до m.
 */

public class Solution {
    public static void main(String[] args) {
        int[] d = {1, 2, 3, 4, 5, 6, 9, 8, 7};

        System.out.println(sumThree(d, 0));

        System.out.println(sumThree(d, 8));
    }

    /**
     * Sums three consecutive elements, from the {@code fromIndex}.
     * @param array the array
     * @param fromIndex the index of the first element, inclusive
     * @return the sum of three consecutive elements, from the
     *         {@code fromIndex}.
     */
    public static int sumThree(int[] array, int fromIndex){
        if (fromIndex + 3 > array.length){
            throw new ArrayIndexOutOfBoundsException(
                    "Third element of sum out of range: " + (fromIndex + 3));
        }
            return sum(array, fromIndex, fromIndex + 3);
    }

    /**
     * Sums elements from the {@code fromIndex} to the {@code toIndex}.
     * @param array the array
     * @param fromIndex the index of the first element, inclusive
     * @param toIndex the index of the last element, exclusive
     * @return the sum of from the {@code fromIndex} to the {@code toIndex}.
     */
    public static int sum(int[] array, int fromIndex, int toIndex){
        int result = 0;
        for (int i = fromIndex; i < toIndex; i++){
            result += array[i];
        }
        return result;
    }
}
