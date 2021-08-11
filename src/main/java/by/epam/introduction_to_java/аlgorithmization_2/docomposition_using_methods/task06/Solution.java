package by.epam.introduction_to_java.аlgorithmization_2.docomposition_using_methods.task06;

/*
 * Условие задачи:
 * 6. Написать метод(методы), проверяющий, являются ли данные три числа взаимно
 *    простыми.
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println(areMutuallySimple(6 , 8, 9));
        System.out.println(areMutuallySimple(8 , 15, 19));
        System.out.println(areMutuallySimple(8 , 15, 49));

        System.out.println(areMutuallySimple(8 , 16, 24));
    }

    /**
     * Checks are numbers mutually simple.
     * @param a arguments.
     * @return {@code true} if the given arguments are mutually simple.
     */
    public static boolean areMutuallySimple(int ...a){
        return getGCF(a) == 1;
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
