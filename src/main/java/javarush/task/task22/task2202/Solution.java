package javarush.task.task22.task2202;

/*
Найти подстроку
*/

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    /*
     * Метод getPartOfString должен возвращать подстроку
     * начиная с символа после 1-го пробела и до конца слова,
     * которое следует после 4-го пробела.
     *
     * Пример:
     * "JavaRush - лучший сервис обучения Java."
     *
     * Результат:
     * "- лучший сервис обучения"
     *
     * Пример:
     * "Амиго и Диего лучшие друзья!"
     *
     * Результат:
     * "и Диего лучшие друзья!"
     * На некорректные данные бросить исключение TooShortStringException (сделать исключением).
     */

    public static String getPartOfString(String string) {
        try {
            String[] strings = string.split(" ");
            String result = String.format("%s %s %s %s",
                    strings[1],
                    strings[2],
                    strings[3],
                    strings[4]);
            return result;
        }
        catch (Exception e){
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends RuntimeException {
    }

}