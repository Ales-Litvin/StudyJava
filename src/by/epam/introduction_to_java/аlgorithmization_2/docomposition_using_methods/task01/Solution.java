package by.epam.introduction_to_java.аlgorithmization_2.docomposition_using_methods.task01;

/*
 * Условие задачи:
 * 1. Написать метод(методы) для нахождения наибольшего общего делителя и наименьшего общего кратного двух
 *    натуральных чисел:
 *    (НОК(A, B) = (A * B) / НОД(А, B))
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println(getGCF(12,36));

        System.out.println(getLCD(12,36));
    }

    /**
     * Returns the greatest common factor (GCF).
     * @param   a   an argument.
     * @param   b   another argument.
     * @return the greatest common factor of {@code a} and {@code b}.
     */
    public static int getGCF(int a, int b){
        if (a != 0 && b != 0){
            if (a > b){
                a = a % b;
            } else {
                b = b % a;
            }
            return getGCF(a, b);
        } else {
            return a + b;
        }
    }

    /**
     * Returns the least common divisor (LCD),
     * <br> (НОК(A, B) = (A * B) / НОД(A, B)).
     * @param   a   an argument.
     * @param   b   another argument.
     * @return the least common divisor of {@code a} and {@code b}.
     */
    public static int getLCD(int a, int b){
        return (a * b) / getGCF(a, b);
    }

}
