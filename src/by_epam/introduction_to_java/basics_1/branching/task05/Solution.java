package by_epam.introduction_to_java.basics_1.branching.task05;

/**
 * Условие задачи:
 * 5. Вычислить значение функции:
 * <p><center><img src="equation.PNG">
 *
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(isSolution(2));
    }

    public static int isSolution(int x){
        int result;
        if (x <= 3){
            result = (x * x * x) - (3 * x) + 9;
        } else {
            result = 1 / ((x * x * x) + 6);
        }
        return result;
    }
}
