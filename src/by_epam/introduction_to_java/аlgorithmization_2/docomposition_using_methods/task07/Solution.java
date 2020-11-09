package by_epam.introduction_to_java.аlgorithmization_2.docomposition_using_methods.task07;

/*
 * Условие задачи:
 * 7. Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9.
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumFactorialsAllOdd(1, 9));
    }

    /**
     * Returns the sum factorials all odd numbers,
     *        from {@code  fromNumber} to {@code toNumber}.
     * @param fromNumber the first number, inclusive
     * @param toNumber the last number, inclusive
     * @return the sum factorials all odd numbers
     */
    public static int sumFactorialsAllOdd(int fromNumber, int toNumber){
        int result = 0;
        for (int i = fromNumber; i <= toNumber; i++){
            if (i % 2 != 0){
                result += factorial(i);
            }
        }
        return result;
    }

    /**
     * Returns the factorial.
     * @param a an argument.
     * @return the factorial of {@code a}.
     */
    public static int factorial(int a){
        if (a != 1){
            return a = a * factorial(a - 1);
        } else {
            return 1;
        }
    }
}