package by_epam.introduction_to_java.аlgorithmization_2.sorting.task08;

/*
 * Условие задачи:
 * 8. Даны дроби  p1/q1, p2/q2, ... pn/qn (pi, qi - натуральные).
 *   Составить программу, которая приводит эти дроби к общему знаменателю и упорядочивает их в порядке возрастания.
 */

import java.util.Arrays;
import java.util.Objects;

public class Solution_rev2 {
    public static void main(String[] args) {
        int[] arrayOne = {1, 4, 8, 10, 12, 14, 20, 26, 30, 36};
        int[] arrayTwo = {1, 4, 3, 3, 6, 7, 10, 20};

        int[][] fraction = {
                {1, 4, 3, 3},
                {4, 8, 2, 8}};

        leadingToCommonDenominator(fraction);

        printMatrix(fraction);

    }

    public static void leadingToCommonDenominator(int[][] array) {
        for (int i = 1; i <= array.length; i++){
            if (array[1][i - 1] != array[1][i]){
                int nok = isNok(array[1][i - 1], array[1][i]);
                bringingToNok(array, i, nok);
                bringingToNok(array, i - 1, nok);
            }
        }
        sortFraction(array[0]);
    }


    public static void bringingToNok(int[][] array, int index, int nok){
        int factor = nok / array[1][index];
        array[1][index] *= factor;
        array[0][index] *= factor;
    }


    public static int isNok(int a, int b){
        if (a == b) return a;
        if (a > b && a % b == 0){
            return a;
        } else if (b > a && b % a == 0){
            return b;
        } else {
            return a * b;
        }
    }

    public static void sortFraction(int[] array){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length - i - 1; j++){
                if (array[j] > array[j + 1]){
                    int data = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = data;
                }
            }
        }
    }

    /**
     * Prints the matrix.
     */
    public static void printMatrix(int[][] matrix){
        if (matrix == null) {
            System.out.println("null");
            return;
        }
        for (int[] line : matrix) {
            System.out.println(Arrays.toString(line));
        }
    }

    /**
     * This class describes fraction. It are immutable.
     */
    public static class Fraction implements Comparable<Fraction>{
        private final int numerator;
        private final int denominator;

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public int getNumerator() { return numerator; }

        public int getDenominator() { return denominator; }

        /**
         * Returns value of fraction.
         */
        public double getValue(){
            return (double) numerator / (double) denominator;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Fraction)) return false;
            Fraction fraction = (Fraction) o;
            return getNumerator() == fraction.getNumerator() &&
                    getDenominator() == fraction.getDenominator();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getNumerator(), getDenominator());
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Fraction{");
            sb.append(numerator);
            sb.append("/").append(denominator);
            sb.append('}');
            return sb.toString();
        }

        @Override
        public int compareTo(Fraction o) {
            return Double.compare(this.getValue(), o.getValue());
        }
    }
}
