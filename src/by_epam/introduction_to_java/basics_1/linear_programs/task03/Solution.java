package by_epam.introduction_to_java.basics_1.linear_programs.task03;

/*
 * Условие задачи:
 * 3. Вычислить значение выражения по формуле (все переменные принимают действительные значения):
 *      (𝑠𝑖𝑛 𝑥 + 𝑐𝑜𝑠 𝑦) / (𝑐𝑜𝑠 𝑥 − 𝑠𝑖𝑛 𝑦) ∗ 𝑡𝑔 𝑥𝑦
 */
public class Solution {
    public static void main(String[] args) {
        int x = 1;
        int y = 1;

        double z = ((Math.sin(x) + Math.cos(y)) / (Math.cos(x) - Math.sin(y))) * Math.tan(x * y);

        System.out.println(z);
    }
}