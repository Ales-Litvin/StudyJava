package by_epam.introduction_to_java.аlgorithmization_2.docomposition_using_methods.task17;

/*
 * Условие задачи:
 * 17. Из заданного числа вычли сумму его цифр. Из результата вновь вычли
 *     сумму его цифр и т.д. Сколько таких действий надо произвести, чтобы
 *     получился нуль? Для решения задачи использовать декомпозицию.
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println(countOperation(1238934));
    }

    /**
     * Counts count of call {@link Solution#sumDigitsOfNumber}.
     * @param number a number
     * @return count of call {@link Solution#sumDigitsOfNumber}.
     */
    public static int countOperation(int number){
        int count = 0;
        while (number != 0){
            number -= sumDigitsOfNumber(number);
            count++;
        }
        return count;
    }

    /**
     * Returns sum digits of number.
     * @param number a number
     * @return sum digits of number.
     */
    public static int sumDigitsOfNumber(int number){
        int result = 0;
        for (char c : String.valueOf(number).toCharArray()){
            result += Integer.parseInt(String.valueOf(c));
        }
        return result;
    }
}