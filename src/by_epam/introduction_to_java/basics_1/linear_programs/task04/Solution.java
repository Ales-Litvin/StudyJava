package by_epam.introduction_to_java.basics_1.linear_programs.task04;

/*
 * Условие задачи:
 * 4. Дано действительное число R  вида nnn.ddd  (три цифровых разряда в
 *    дробной и целой частях). Поменять местами дробную и целую части числа и
 *    вывести полученное значение числа.
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println(doubleRevers(333.555));
    }

    /**
     * Changes fractional and whole parts
     * @param r a number (nnn.ddd)
     * @return a number with changed fractional and whole parts.
     */
    public static double doubleRevers(double r){
        return Double.parseDouble(
                new StringBuilder().append(r).reverse().toString());
    }
}
