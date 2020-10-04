package by_epam.strings_3.working_with_a_string_as_String_or_StringBuilder.task01;

/*
 * Условие задачи:
 * 1. Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем.
 */
public class Solution {
    public static void main(String[] args) {
        String string = "  Удалить  в  строке         все  лишние  пробелы," +
                "  то  есть  серии  подряд     идущих  пробелов  заменить  на  одиночные  пробелы.            ";

        System.out.println(maxWhitespace(string));
    }

    /**
     * Counts max white space together
     * @param string a string
     * @return number of max white space together
     */
    public static int maxWhitespace(String string){

        char[] chars = string.toCharArray();

        int max = 0;

        for (int i = 0; i < chars.length; i++){
            int currentMax = 0;

            if (Character.isWhitespace(chars[i])){
                while (i < chars.length && Character.isWhitespace(chars[i])){
                    i++;
                    currentMax++;
                }
            }
            if (currentMax > max) {
                max = currentMax;
            }
        }
        return max;
    }
}
