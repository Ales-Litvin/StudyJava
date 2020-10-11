package by_epam.introduction_to_java.аlgorithmization_2.docomposition_using_methods.task03;

/*
 * Условие задачи:
 * 3. Вычислить площадь правильного шестиугольника со стороной 'a',
 *  используя метод вычисления площади треугольника.
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println(isAreaOfHexagon(6));
    }

    /**
     * Calculates an area of hexagon by the length of a side
     * @param lengthSide a length of a side
     * @return an area
     */
    public static double isAreaOfHexagon(int lengthSide){
        double s = (Math.sqrt(3) / 4) * lengthSide * lengthSide;
        return 6 * s;
    }
}
