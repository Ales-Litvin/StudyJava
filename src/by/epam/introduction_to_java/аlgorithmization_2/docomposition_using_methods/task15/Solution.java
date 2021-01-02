package by.epam.introduction_to_java.аlgorithmization_2.docomposition_using_methods.task15;

/*
 * Условие задачи:
 * 15.  Найти  все  натуральные  n-значные  числа,  цифры  в  которых  образуют
 *     строго  возрастающую последовательность (например, 1234, 5789).
 *     Для решения задачи использовать декомпозицию.
 */

public class Solution {
    public static void main(String[] args) {
       findNumbersWithDigitInAscendingOrder(4);
    }

    /**
     * Finds numbers with digits in ascending order by the count of digits in
     * numbers.
     * @param n the count of digits in numbers
     */
    public static void findNumbersWithDigitInAscendingOrder(int n){
        int from = 1;
        for (int i = 0; i < n - 1 ; i++){
            from *= 10;
        }

        findNumbersWithDigitInAscendingOrder(from, from * 10);
    }


    /**
     * Finds numbers with digits in ascending order.
     * @param from the value of the first element
     * @param to the value of the last element
     */
    public static void findNumbersWithDigitInAscendingOrder(int from, int to){
        for (int i = from; i < to; i++){
            if (isAscendingOrder(i)){
                System.out.println(i);
            }
        }
    }

    /**
     * Are digits of the number in ascending order.
     * @param n the number to be checking
     * @return {@code ture} if digits of the number are in ascending order.
     */
    public static boolean isAscendingOrder(int n){
        char[] chars = String.valueOf(n).toCharArray();
        for (int i = 1; i < chars.length; i++){
            int numberOne = Integer.parseInt(String.valueOf(chars[i - 1]));
            int numberTwo = Integer.parseInt(String.valueOf(chars[i]));
            if (numberOne >= numberTwo) return false;
        }
        return true;
    }
}