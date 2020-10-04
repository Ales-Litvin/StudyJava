package by_epam.strings_3.working_with_a_string_as_String_or_StringBuilder.task07;

/*
 * Условие задачи:
 * 7. Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы.
 *    Например, если было введено "abc cde def", то должно быть выведено "abcdef".
 */
public class Solution {
    public static void main(String[] args) {
        String string = "abc cde def";

        System.out.println(removeDuplicateLetters(string));
    }

    /**
     * Removes duplicate letters
     * @param string a string
     * @return a string where removed all duplicate letters
     */
    public static String removeDuplicateLetters(String string){
        StringBuilder builder = new StringBuilder();

        for (char c : string.toCharArray()){
            if (builder.toString().indexOf(c) < 0 && !Character.isWhitespace(c)) {
                builder.append(c);
            }
        }

        return builder.toString();
    }
}
