package by_epam.introduction_to_java.аlgorithmization_2.sorting.task08;

import java.util.Arrays;

/**
 * Utils class for working with Fraction.
 *
 * @see Fraction
 *
 * @author  Aliaksandr Rachko
 * @version 1.0
 */
public class Fractions {

    /**
     * Leads fractions to the common denominator.
     * @param fractions the array of fractions
     */
    public static void toCommonDenominator(Fraction[] fractions) {
        int commonDenominator = getCommonDenominator(fractions);
        for (int i = 0; i < fractions.length; i++){
            fractions[i] = fractions[i].toDenominator(commonDenominator);
        }
    }

    /**
     * Returns the common denominator
     * @param fractions the array of fractions
     * @return the common denominator
     */
    private static int getCommonDenominator(Fraction[] fractions){
        int result = getCommonDenominator(fractions[0], fractions[1]);
        for (int i = 2; i < fractions.length; i++) {
            result = getLCM(fractions[i].getDenominator(), result);
        }
        return result;
    }

    /**
     * Returns the common denominator for two fractions.
     * @param a the first fraction
     * @param b the second fraction
     * @return the common denominator
     */
    private static int getCommonDenominator(Fraction a, Fraction b){

        return getLCM(a.getDenominator(), b.getDenominator());
    }

    /**
     * Returns the least common multiple for two numbers.
     * @param a the first number
     * @param b the second number
     */
    protected static int getLCM(int a, int b){
        if (a == b) return a;
        if (a > b && a % b == 0){
            return a;
        } else if (b > a && b % a == 0){
            return b;
        } else {
            return a * b;
        }
    }

    /**
     * Sorts the array of fractions.
     * @param fractions the array to be sorting.
     */
    public static void sort(Fraction[] fractions){
        Arrays.sort(fractions);
    }
}
