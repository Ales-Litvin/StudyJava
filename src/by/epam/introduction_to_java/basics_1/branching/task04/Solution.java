package by.epam.introduction_to_java.basics_1.branching.task04;

/*
 * Условие задачи:
 * 4. Заданы размеры А, В прямоугольного отверстия и размеры х, у, z  кирпича.
 *    Определить, пройдет ли кирпич через отверстие.
 */
public class Solution {
    public static void main(String[] args) {
        int A = 2;
        int B = 5;

        int x = 2;
        int y = 6;
        int z = 5;

        System.out.println(isPass(A, B, x, y, z));
    }

    /**
     * Check may the brick pass through the hole.
     * @param A hole width
     * @param B hole height
     * @param x brick width
     * @param y brick height
     * @param z brick length
     * @return {@code true} if the brick cans pass through the hole.
     */
    public static boolean isPass(int A, int B,
                                 int x, int y, int z){
        boolean is;

        if (x <= A){
            is = y <= B || z <= B;
        } else if (y <= A){
            is = x <= B || z <= B;
        } else if (z <= A){
            is = x <= B || y <= B;
        } else {
            is = false;
        }

        return is;
    }

}
