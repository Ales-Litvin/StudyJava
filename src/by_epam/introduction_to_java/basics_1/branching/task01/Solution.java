package by_epam.introduction_to_java.basics_1.branching.task01;

/*
 * Условие задачи:
 * 1. Даны два угла треугольника (в градусах).
 *    Определить, существует ли такой треугольник, и если да, то будет ли он
 *    прямоугольным.
 */
public class Solution {
    public static void main(String[] args) {
        printTriangleInfo(45, 45);
        printTriangleInfo(60,30);
        printTriangleInfo(90,90);
    }

    /**
     * Prints info about the triangle.
     * @param angleOne an angle.
     * @param angleTwo an another angle.
     */
    public static void printTriangleInfo(int angleOne, int angleTwo){
        System.out.print(
                "Треугольник с углами "
                        + angleOne + " и " + angleTwo + " градусов ");
        if (isTriangle(angleOne, angleTwo)){
            System.out.print("существует и он - ");
            if (isRightTriangle(angleOne, angleTwo)){
                System.out.print("прямоуольный.\n");
            } else {
                System.out.print("не прямоуольный.\n");
            }
        } else {
            System.out.println("не существует.");
        }
    }

    /**
     * Checks, "Does the triangle exist?".
     * @param angleOne an angle.
     * @param angleTwo an another angle.
     * @return {@code true} if triangle exist.
     */
    public static boolean isTriangle(int angleOne, int angleTwo){
        return  180 - (angleOne + angleTwo) > 0;
    }

    /**
     * Checks, "Does the right triangle exist?".
     * @param angleOne an angle.
     * @param angleTwo an another angle.
     * @return {@code true} if right triangle exist.
     */
    public static boolean isRightTriangle(int angleOne, int angleTwo){
        return 180 - (angleOne + angleTwo) == 90;
    }
}
