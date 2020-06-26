package javarush.task.task29.task2913;

import java.util.Random;

/*
Замена рекурсии
*/
public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        if (a > b) {
            String result = Integer.toString(a);
            while (a != b) {
                result += " " + Integer.toString(a - 1);
                a -= 1;
            }
            return result;

        } else {
            if (a == b) {
                return Integer.toString(a);
            }
            String result = Integer.toString(a);
            while (a != b) {
                result += " " + Integer.toString(a + 1);
                a += 1;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}