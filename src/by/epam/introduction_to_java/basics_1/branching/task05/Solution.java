package by.epam.introduction_to_java.basics_1.branching.task05;

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

    /**
     * Calculates the value of function:
     * F(x) = x<sup>2</sup>-3x+9, if x &le;3; 1 / (x<sup>3</sup>+6) , if x > 3.
     * @param x the x
     * @return the solution.
     */
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
