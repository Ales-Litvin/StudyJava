package by.epam.introduction_to_java.аlgorithmization_2.one_dimensional_arrays.task07;

/*
 * Условие задачи:
 * 7. Даны действительные числа a1, a2, ..., an. Найти
 *    max(a1+a2n, a2+a2n-1, ..., an+an+1).
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {1, -2, 5, -10, 12, 0, 51 , -99, 100};

        System.out.println(maxByStrangeCondition( array));
    }

    /**
     * Returns max(а<sub>1</sub>+а<sub>2n</sub>, а<sub>2</sub>+а<sub>2n-1</sub>, ..., а<sub>n</sub>+а<sub>n+1</sub>).
     * @param array the array of number (а<sub>1</sub>, а<sub>2</sub>, ..., а<sub>n</sub>).
     */
    public static int maxByStrangeCondition(final int[] array){
        int max = array[0] + array[1];
        for (int i = 0; i < array.length - 1; i++){
            if (max < array[i] + array[i + 1]) {
                max =  array[i] + array[i + 1];
            }
        }
        return max;
    }
}
