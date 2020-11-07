package by_epam.introduction_to_java.basics_1.cycles.task04;

/*
 * Условие задачи:
 * 4. Составить программу нахождения произведения квадратов первых двухсот чисел.
 */

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumSquaresTwoHundred().toString());
    }

    public static BigInteger sumSquaresTwoHundred(){
        BigInteger bigInteger = new BigInteger("1");
        for (int i = 1; i <= 200; i++){

            bigInteger = bigInteger.multiply(
                    new BigInteger(String.valueOf(i)).multiply(new BigInteger(String.valueOf(i))));
        }
        return bigInteger;
    }
}
