package by_epam.introduction_to_java.аlgorithmization_2.docomposition_using_methods.task13;

/*
 * Условие задачи:
 * 13. Два простых числа называются «близнецами», если они отличаются друг от
 *     друга на 2 (например, 41 и 43). Найти и напечатать все пары «близнецов»
 *     из отрезка [n,2n], где  n  -  заданное натуральное число больше 2.
 *     Для решения задачи использовать декомпозицию.
 */

public class Solution {
    public static void main(String[] args) {
        searchTwins(34);
    }

    /**
     * Finds the twins, and prints they
     * use {@link Solution#printTwins(int, int)}.
     * @param n the number
     */
    public static void searchTwins(int n){
        for (int i = 2; i < 2 * n; i++){
            if ((i + 2) < (2 * n)){
                printTwins(i, i + 2);
            }
        }
    }

    /**
     * Prints two numbers, in the format "[{@code a}, {@code b}]"
     * @param a the first number
     * @param b the second number
     */
    public static void printTwins(int a, int b){
            System.out.println("[" + a + ", " + b + "]");
    }
}
