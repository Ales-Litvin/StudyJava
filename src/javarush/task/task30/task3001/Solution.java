package javarush.task.task30.task3001;

/*
 * Реализуй логику метода convertNumberToOtherNumberSystem,
 * который должен переводить число number.getDigit(),
 * из одной системы счисления (numberSystem) в другую (expectedNumberSystem).
 *
 * Брось NumberFormatException, если переданное число некорректно, например,
 * число "120" с системой счисления 2.
 * Валидация для - number.getDigit() - целое не отрицательное.
 * Метод learn.main не участвует в тестировании.
 */

import java.math.BigInteger;

/*
Конвертер систем счислений
*/
public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumberSystemType._10, "6");
        Number result = convertNumberToOtherNumberSystem(number, NumberSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(NumberSystemType._16, "6df");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._8);
        System.out.println(result);    //expected 3337

        number = new Number(NumberSystemType._16, "abcdefabcdef");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);    //expected abcdefabcdef
    }

    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem) {
        //напишите тут ваш код

        BigInteger bigInteger = new BigInteger(number.getDigit(), number.getNumberSystem().getNumberSystemIntValue());

        return new Number(expectedNumberSystem,
                bigInteger.toString(expectedNumberSystem.getNumberSystemIntValue()));
    }
}