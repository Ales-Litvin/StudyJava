package by_epam.introduction_to_java.basics_1.cycles.task07;

/*
 * Условие задачи:
 * 7. Для каждого натурального числа в промежутке от m до n вывести все
 *    делители, кроме единицы и самого числа. m и n вводятся с клавиатуры.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(reader.readLine());
        int n = Integer.parseInt(reader.readLine());

        reader.close();

        printAllDivisorBetween(m, n);
    }

    /**
     * Print all divisors for numbers between {@code m} and {@code n}.
     * @param m an argument.
     * @param n an another argument.
     */
    public static void printAllDivisorBetween(int m, int n){
        for (int i = m; i <= n; i++){
            System.out.print("Divider \""+ i + "\" : ");
            for (int k = 2; k < i; k++){
                if (i % k == 0){
                    System.out.print(" " + k + " ");
                }
            }
            System.out.println("");
        }
    }
}
