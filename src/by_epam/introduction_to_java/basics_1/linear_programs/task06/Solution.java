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
        int x = -2;
        int y = -2;

        if (0 <= y && y < 4 && -2 < x && x < 2){
            System.out.println(true);
        } else if (0 >= y && y > -3 && -4 < x && x < 4){
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
