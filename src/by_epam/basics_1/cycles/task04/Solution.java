package by_epam.basics_1.cycles.task04;


import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("1");
        for (int i = 1; i <= 200; i++){
            bigInteger = bigInteger.multiply(new BigInteger(String.valueOf(i)));
        }
        System.out.println(bigInteger.toString());
    }
}
