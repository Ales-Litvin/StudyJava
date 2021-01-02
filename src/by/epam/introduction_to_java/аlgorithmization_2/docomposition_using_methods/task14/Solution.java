package by.epam.introduction_to_java.аlgorithmization_2.docomposition_using_methods.task14;

/*
 * Условие задачи:
 * 14.  Натуральное число, в записи которого n цифр, называется числом
 *      Армстронга, если сумма его цифр, возведенная в степень n, равна самому
 *      числу.  Найти  все  числа  Армстронга  от  1  до  k.
 *      Для  решения  задачи использовать декомпозицию.
 */

public class Solution {
    public static void main(String[] args) {
        findArmstrongNumbers(10000);
    }

    /**
     * Prints armstrong numbers from '1' to {@code n}.
     * @param n the up border
     */
    public static void findArmstrongNumbers(int n){
        for (int i = 1; i < n; i++){
            if (isArmstrongNumber(i)){
                System.out.println(i);
            }
        }
    }

    /**
     * Checks, is the {@code number} the armstrong number.
     * @param number the number to be checking
     * @return {@code true} if the {@code number} is the armstrong number.
     */
    public static boolean isArmstrongNumber(int number){
        long sum = 0;
        String string = String.valueOf(number);

        for (char c : string.toCharArray()){
            sum = sum + power(
                    Integer.parseInt(String.valueOf(c)),
                    string.length());
        }

        return sum == number;
    }

    /**
     * Raises {@code a} to a power {@code b}
     * @param a a value
     * @param b a power
     * @return the value {@code a} to a power {@code b}
     */
    public static int power(int a, int b){
        int result = 1;
        while (b != 0){
            result = result * a;
            b--;
        }
        return result;
    }
}