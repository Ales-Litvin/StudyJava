package by_epam.introduction_to_java.аlgorithmization_2.docomposition_using_methods.task11;

/*
 * Условие задачи:
 * 11. Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println(isLonger(2, +1));
    }

    /**
     * Returns longer of the first number and the second number.
     * @param a the first number
     * @param b the second number
     * @return the longer of them.
     */
    public static int isLonger(int a, int b){
        return String.valueOf(a).length() > String.valueOf(b).length() ? a : b;
    }


}
