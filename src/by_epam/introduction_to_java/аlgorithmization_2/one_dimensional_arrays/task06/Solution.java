package by_epam.introduction_to_java.аlgorithmization_2.one_dimensional_arrays.task06;

/*
 * Условие задачи:
 * 6.  Задана  последовательность  N  вещественных  чисел.
 *     Вычислить  сумму  чисел,  порядковые  номера  которых являются простыми числами.
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {1, -2, 5, -10, 12, 0, 51 , -99, 100};

        System.out.println(sumOfPrimeNumbers(array));
    }

    /**
     * Returns the sum the prime numbers.
     * @param array the array of numbers.
     * @return the sum the prime numbers.
     */
    public static int sumOfPrimeNumbers(final int[] array){
        int result = 0;
        for (int i = 0; i < array.length; i++){
            if (isPrimeNumber(i)) result += array[i];
        }
        return result;
    }

    /**
     * Check is the prime number.
     * @param number the number for checking.
     * @return {@code true} if it is the prime number.
     */
    public static boolean isPrimeNumber(final int number){
        if (number == 0 || number == 1) return false;
        for (int i = 2; i < number; i++){
            if (number % i == 0) return false;
        }
        return true;
    }
}
