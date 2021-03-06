package by.epam.introduction_to_java.basics_1.branching.task03;

/*
 * Условие задачи:
 * 3. Даны три точки А(х1,у1), В(х2,у2) и С(х3,у3).
 *    Определить, будут ли они расположены на одной прямой.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(isLine(4 ,5 , 2 ,4 ,6 ,6));
        System.out.println(isLine(0 ,5 , 0 ,4 ,0 ,6));
    }

    /**
     * Checks, "Do three points lie on the line?".
     * @param x1 the x coordinate of the first point
     * @param y1 the y coordinate of the first point
     * @param x2 the x coordinate of the second point
     * @param y2 the y coordinate of the second point
     * @param x3 the x coordinate of the second point
     * @param y3 the y coordinate of the second point
     * @return {@code true} if three points lie on the line.
     */
    public static boolean isLine(int x1, int y1,
                                 int x2, int y2,
                                 int x3, int y3){
        // y = kx + b
        if (x1 == x2 && x2 == x3 || y1 == y2 && y2 == y3){
            return true;
        } else {
            int k = (y1 - y2) / (x1 - x2);
            int b = y1 - k * x1;
            return y3 == k * x3 + b;
        }
    }
}
