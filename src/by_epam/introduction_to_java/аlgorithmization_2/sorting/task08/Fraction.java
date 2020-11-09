package by_epam.introduction_to_java.аlgorithmization_2.sorting.task08;

import java.util.Objects;

/**
 * This class describes fraction. It are immutable.
 */
public  class Fraction implements Comparable<Fraction>{
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
        if (!(o instanceof Solution.Fraction)) return false;
        Solution.Fraction fraction = (Solution.Fraction) o;
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