package by_epam.introduction_to_java.аlgorithmization_2.docomposition_using_methods.task09;

/*
 * Условие задачи:
 * 9. Даны числа X, Y, Z, Т — длины сторон четырехугольника.
 *    Написать метод(методы) вычисления его площади, если угол между сторонами
 *     длиной X и Y— прямой.
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println(areaOfQuadrangle(2,4,8,5));
    }

    /**
     * Calculates area of quadrangle.
     * Corner between the first side {@code x}
     *         and the second side {@code y} needs to be 90 degrees.
     * @param x the first side
     * @param y the second side
     * @param z the third side
     * @param t the fourth side
     * @return the area of quadrangle
     */
    public static int areaOfQuadrangle(int x, int y, int z, int t){
        return ((y + z) / 2) * x;
    }
}
