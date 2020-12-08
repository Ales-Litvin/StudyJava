package by_epam.introduction_to_java.basics_1.linear_programs.task06;

/**
 * Условие задачи:
 * 6.  Для  данной  области  составить  линейную  программу,
 *     которая  печатает  true,  если  точка  с  координатами  (х,  у)
 *     принадлежит закрашенной области, и false — в противном случае:
 *
 *     <p>
 *         <center>
 *             <img src="image.PNG"/>
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(inRegion(-2,-2));
        System.out.println(inRegion(4,-2));
    }

    /**
     * Checks, "Does points lie in the region?".
     *      <p><center>Region: <img src="image.PNG"/>
     * @param x the coordinate x of the point
     * @param y the coordinate y of the point
     * @return {@code true} if the point lie in the region.
     */
    public static boolean inRegion(int x, int y){
        if (0 <= y && y < 4 && -2 < x && x < 2){
            return true;
        } else return 0 >= y && y > -3 && -4 < x && x < 4;
    }
}
