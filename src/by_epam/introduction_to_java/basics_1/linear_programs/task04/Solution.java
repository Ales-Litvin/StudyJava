package by_epam.introduction_to_java.basics_1.linear_programs.task04;

/*
 * Условие задачи:
 * 4. Дано действительное число R  вида nnn.ddd  (три цифровых разряда в дробной и целой частях).
 *    Поменять местами дробную и целую части числа и вывести полученное значение числа.
 */
public class Solution {
    public static void main(String[] args) {
        double r = 333.555;

        r = Double.parseDouble(new StringBuilder().append(r).reverse().toString());

        System.out.println(r);
    }
}
