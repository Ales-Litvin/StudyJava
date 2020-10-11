package by_epam.introduction_to_java.strings_3.working_with_a_string_as_an_array.task05;

/*
 * Услвие задачи:
 * 5.  Удалить  в  строке  все  лишние  пробелы,
 *     то  есть  серии  подряд  идущих  пробелов  заменить  на  одиночные  пробелы.
 * Крайние пробелы в строке удалить.
 */


public class Solution {
    public static void main(String[] args) {
        String string = "  Удалить  в  строке         все  лишние  пробелы," +
                "  то  есть  серии  подряд     идущих  пробелов  заменить  на  одиночные  пробелы.  ";

        System.out.println(removeExtraSpaces(string));
    }

    /**
     * Returns a string whose value is this string,
     * with all double, leading and trailing white space removed.
     * @param string string for remove excess white space
     * @return a string whose value is this string,
     * with double, leading and trailing white space removed.
     */
    public static String removeExtraSpaces(String string){
        string = removeLeadingWhitespaces(string);
        string = removeTrailingWhitespaces(string);

        char[] chars = string.toCharArray();

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < chars.length; i++){
            builder.append(chars[i]);
            if (Character.isWhitespace(chars[i])){
                while (Character.isWhitespace(chars[i])){
                    i++;
                }
                i--;
            }
        }
        return builder.toString();
    }

    /**
     *
     * Returns a string whose value is this string,
     * with all leading white space removed.
     * @param string string for remove leading white space
     * @return a string whose value is this string,
     * with all leading white space removed.
     */
    public static String removeLeadingWhitespaces(String string) {
        char[] chars = string.toCharArray();

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            if (!Character.isWhitespace(chars[i])) {
                builder.append(chars, i, chars.length - 2);
                break;
            }
        }
        return builder.toString();
    }

    /**
     * Returns a string whose value is this string,
     * with all trailing white space removed
     * @param string string for remove trailing white space
     * @return a string whose value is this string,
     * with all trailing white space removed
     */
    public static String removeTrailingWhitespaces(String string){
        char[] chars = string.toCharArray();

        StringBuilder builder = new StringBuilder();

        for (int i = string.length() - 1; i >= 0; i--) {
            if (!Character.isWhitespace(chars[i])) {
                builder.append(chars, 0, i + 1);
                break;
            }
        }
        return builder.toString();
    }
}
