package by_epam.introduction_to_java.аlgorithmization_2.docomposition_using_methods.task02;

/*
 * Условие задачи:
 * 2. Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел.
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println(getGCF(12, 36, 102, 14));
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
     * Returns the greatest common factor (GCF).
     * @param   a   arguments.
     * @return the greatest common factor of {@code a}.
     */
    public static int getGCF(int ... a){
        int result = getGCF(a[0], a[1]);
        for (int i = 2; i < a.length; i++){
            result = getGCF(a[i], result);
        }
        return result;
    }
}