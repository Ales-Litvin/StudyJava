package javarush.task.task39.task3904;

import java.util.HashMap;

/*
Лестница

Ребенок бежит по лестнице состоящей из N ступенек, за 1 шаг он может пройти одну,
две или три ступеньки.

Реализуй метод countPossibleRunups(int n), который вернет количество способов
которыми ребенок может пробежать всю лестницу состоящую из n ступенек.

P.S. Если лестница состоит из 0 ступенек — метод должен возвращать 1. Для n < 0 верни 0.
Требования:

1. Метод countPossibleRunups должен возвращать количество способов прохождения лестницы из n ступенек.
2. Метод countPossibleRunups должен возвращать 1 для n = 0.
3. Метод countPossibleRunups должен возвращать 0 для n < 0.
4. Время выполнения метода countPossibleRunups должно быть линейным.
*/

public class Solution {
    private static int n = 70;

    static HashMap<Integer, Long> map = new HashMap<>();

    static {
        map.put(0, 1L);
        map.put(1, 1L);
        map.put(2, 2L);
        map.put(3, 4L);
    }

    public final static String FORMAT = "The number of possible ascents for %d steps is: %d\n";

    public static void main(String[] args) {
        System.out.printf(FORMAT, n, numberOfPossibleAscents(n));
        System.out.printf(FORMAT, 1, numberOfPossibleAscents(1)); // 1
        System.out.printf(FORMAT, 3, numberOfPossibleAscents(3)); // 4
        System.out.printf(FORMAT, 2, numberOfPossibleAscents(2)); // 4
    }

    public static long numberOfPossibleAscents(int n) {
        if (n < 0)
            return 0;

        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            long fibonacciValue = (numberOfPossibleAscents(n - 3) + numberOfPossibleAscents(n - 2)) + numberOfPossibleAscents(n - 1);
            map.put(n, fibonacciValue);
            return fibonacciValue;
        }
    }
}