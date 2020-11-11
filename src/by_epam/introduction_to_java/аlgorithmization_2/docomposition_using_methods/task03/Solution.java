package by_epam.introduction_to_java.аlgorithmization_2.docomposition_using_methods.task03;

/*
 * Условие задачи:
 * 3. Вычислить площадь правильного шестиугольника со стороной 'a', используя
 *    метод вычисления площади треугольника.
 */

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getAreaOfHexagon(6));
    }

    /**
     * Calculates an area of hexagon by the length of a side, using
     * {@link Solution#getAreaOfRegularTriangle}
     * @param lengthSide a length of a side
     * @return an area
     */
    public static double getAreaOfHexagon(int lengthSide){
        return 6 * getAreaOfRegularTriangle(lengthSide);
    }

    /**
     * Calculates an area of regular triangle by the length of a side
     * @param lengthSide a length of a side
     * @return an area of regular triangle
     */
    public static double getAreaOfRegularTriangle(int lengthSide){
        return (Math.sqrt(3) / 4) * lengthSide * lengthSide;
    }
}
