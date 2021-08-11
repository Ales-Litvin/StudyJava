package javarush.task.task22.task2202;

/*
Найти подстроку
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution_rev2 {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
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
            Pattern pattern = Pattern.compile("(\\s\\S+){4}");
            Matcher matcher = pattern.matcher(string);
            if (matcher.find()) {
                string = matcher.group();
            }
            return string;

        }
        catch (Exception e){
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends RuntimeException {
    }

}