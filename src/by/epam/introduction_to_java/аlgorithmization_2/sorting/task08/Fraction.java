package by.epam.introduction_to_java.аlgorithmization_2.sorting.task08;

import java.util.Objects;

/**
 * This class describes fraction. It are immutable.
 *
 * @author  Aliaksandr Rachko
 * @version 1.0
 */
public  class Fraction implements Comparable<Fraction>{
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator == 0) { denominator = numerator; }
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
        return String.format("Fraction{%d/%d=%.3f}",
                numerator, denominator, getValue());
    }

    @Override
    public int compareTo(Fraction o) {
        return Double.compare(this.getValue(), o.getValue());
    }

    /**
     * Returns new the Fraction, leading this Fraction to the giving denominator.
     * @param denominator the common denominator.
     * @throws NullPointerException if denominator is '0' or < this denominator
     * @return the Fraction
     * @see Fractions#getLCM(int , int)
     */
    public Fraction toDenominator(int denominator){
        if (denominator == 0) {
            throw new NullPointerException("denominator doesn't be '0'");
        } else if (denominator < this.denominator) {
            throw new NullPointerException("Can't cast denominator to '" + denominator + "'.");
        }

        int lcm = Fractions.getLCM(this.denominator, denominator);

        int factor = lcm / this.denominator;
        return new Fraction(
                this.numerator * factor,
                this.denominator * factor);
    }
}