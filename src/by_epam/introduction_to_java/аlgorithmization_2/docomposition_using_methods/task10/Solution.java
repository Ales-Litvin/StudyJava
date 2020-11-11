package by_epam.introduction_to_java.аlgorithmization_2.docomposition_using_methods.task10;

/*
 * Условие задачи:
 * 10. Дано  натуральное  число  N.  Написать  метод(методы)  для  формирования
 *     массива, элементами  которого являются цифры числа N.
 */

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(toArray(-13548135)));
    }

    /**
     * Returns an array containing all digits of the {@code number}.
     * @param number the number
     * @return an array containing all digits of the {@code number}.
     */
    public static int[] toArray(int number){
        char[] chars = String.valueOf(number).toCharArray();

        int size = number < 0 ? chars.length - 1 : chars.length;

        int[] result = new int[size];

        int i = 0;
        for (char c : chars){
            if (Character.isDigit(c)){
                result[i] = Integer.parseInt(String.valueOf(c));
                i++;
            }
        }
        return result;
    }

}
