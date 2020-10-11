package by_epam.introduction_to_java.strings_3.working_with_a_string_as_String_or_StringBuilder.task10;

/*
 * Условие задачи:
 * 10. Строка X состоит из нескольких предложений, каждое из которых кончается точкой,
 *     восклицательным или вопросительным знаком.
 *     Определить количество предложений в строке X.
 */

public class Solution {
    public static void main(String[] args) {
        String string = "Hi, Friend! It's been a while since we have been in touch. " +
                "How has your day?";

        System.out.println(countSentences(string));
    }

    /**
     * Counts sentences in the {@param string}
     * @param string a string
     * @return count of sentences
     */
    public static int countSentences(String string){
        return string.split("[.!?]").length;
    }
}
