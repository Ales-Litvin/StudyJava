package by_epam.strings_3.working_with_a_string_as_String_or_StringBuilder.task04;

/*
 * Условие задачи:
 * 4. С помощью функции копирования и операции конкатенации составить из частей слова
 * “информатика” слово “торт”.
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println(createWord());
    }

    /**
     * Creates string "торт" оf string "информатика"
     * @return string "торт"
     */
    public static String createWord(){
        String string = "информатика";

        return string.charAt(7) +
                string.substring(3, 5) +
                string.charAt(7);
    }
}
