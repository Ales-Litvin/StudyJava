package javarush.task.task20.task2025;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Solution_rev2 {
    private static List<Integer> replica = new ArrayList<>();

    public static void main(String[]args) {
        long start = System.currentTimeMillis();
        int[] array = getNumbers(99999999);
        long end = System.currentTimeMillis() - start;
        long memore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        SimpleDateFormat sdf = new SimpleDateFormat("ss.SSS");
        System.out.println("Time = " + sdf.format(new Date(end)));
        System.out.println("Memory = " + memore / 1048576);

        Set<Integer> armstrongNumbers = new TreeSet<>(Arrays.stream(array).boxed().collect(Collectors.toSet()));
        for (int a : armstrongNumbers) {
            if (a != 0)
                System.out.print(a + " ");
        }
    }

    public static int[] getNumbers(int N) {
        for (int i = 0; i <= N; i++) {
            if (isNumberUnique(i)) {
                int sumOfPowers = sum(i);
                if (isArmstrongNumber(sumOfPowers)) {
                    replica.add(sumOfPowers);
                }
            }
        }

        int[] result = new int[replica.size()];
        for (int i = 0; i < replica.size(); i++) {
            result[i] = replica.get(i);
        }

        return result;
    }

    private static boolean isArmstrongNumber(int number) {
        if (sum(number) == number) {
            return true;
        }

        return false;
    }

    private static boolean isNumberUnique(int number) {
        int lastDigit = 0;
        int currentDigit;

        while (number > 0) {
            currentDigit = number % 10;
            if (lastDigit > currentDigit) {
                return false;
            }
            lastDigit = currentDigit;
            number /= 10;
        }

        return true;
    }

    public static int sum(int a) {
        int addition = 0;
        int d = ("" + a).length();
        int b = a % 10;
        while (a >= 1) {
            addition += Math.pow(b, d);
            a /= 10;
            b = a % 10;
        }

        return addition;
    }
}