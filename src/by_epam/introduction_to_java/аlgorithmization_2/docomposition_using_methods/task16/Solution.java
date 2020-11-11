package by_epam.introduction_to_java.аlgorithmization_2.docomposition_using_methods.task16;

/*
 * Условие задачи:
 * 16.  Написать программу, определяющую сумму n - значных чисел, содержащих
 *      только нечетные цифры. Определить также, сколько четных цифр в найденной
 *      сумме. Для решения задачи использовать декомпозицию.
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumNumber(4));
    }

    /**
     * Returns sum of numbers containing only odd digits.
     * @param n the count of digits in numbers
     * @return sum of numbers containing only odd digits.
     */
    public static int sumNumber(int n){
        int sum = 0;
        for (int i = initialValue(n); i < initialValue(n) * 10; i++){
            if (countOdd(i) == n){
                sum += i;
            }
        }

        System.out.println("Количество четных цифр : " + countEven(sum));

        return sum;
    }

    /**
     * Returns first number with the count of digits {@code n}
     * @param n the count of digits in numbers
     * @return first number with the count of digits {@code n}
     */
    public static int initialValue(int n){
        int result = 1;
        n--;
        while (n != 0){
            result = result * 10;
            n--;
        }
        return result;
    }

    /**
     * Counts amount of even digits.
     * @param number a number
     * @return amount of even digits.
     */
    public static int countEven(int number){
        int result = 0;
        for (char c : String.valueOf(number).toCharArray()){
            int n = Integer.parseInt(String.valueOf(c));

            if (n % 2 == 0 && n != 0){
                result++;
            }
        }
        return result;
    }

    /**
     * Counts amount of odd digits.
     * @param number a number
     * @return amount of odd digits.
     */
    public static int countOdd(int number){
        int result = 0;
        for (char c : String.valueOf(number).toCharArray()){
            int n = Integer.parseInt(String.valueOf(c));

            if (n % 2 != 0){
                result++;
            }
        }
        return result;
    }
}
