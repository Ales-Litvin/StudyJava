package by.epam.introduction_to_java.аlgorithmization_2.sorting.task08;

/*
 * Условие задачи:
 * 8. Даны дроби  p1/q1, p2/q2, ... pn/qn (pi, qi - натуральные).
 *   Составить программу, которая приводит эти дроби к общему знаменателю и упорядочивает их в порядке возрастания.
 */

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Fraction[] fractions = new Fraction[]{
                new Fraction(3, 7),
                new Fraction(1,2),
                new Fraction(4, 16),
                new Fraction(5, 2),
                new Fraction(7, 5),
        };

        // Leads fractions to the common denominator.
        Fractions.toCommonDenominator(fractions);

        // Sorts array of fractions
        Fractions.sort(fractions);

        System.out.println(Arrays.toString(fractions));
    }
}
