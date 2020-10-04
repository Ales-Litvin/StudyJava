package by_epam.strings_3.working_with_a_string_as_String_or_StringBuilder.task06;

/*
 * Условие задачи:
 * 6. Из заданной строки получить новую, повторив каждый символ дважды.
 */


public class Solution {
    public static void main(String[] args) {
        String string = "Public opinion is a weak tyrant compared with our own private opinion.";

        System.out.println(doublesLetter(string));

    }

    /**
     * Doubler of character
     * @param string a string
     * @return a modified string
     */
    public static String doublesLetter(String string){
        StringBuilder builder = new StringBuilder();

        for (char c : string.toCharArray()){
            builder.append(c).append(c);
        }

        return builder.toString();
    }
}
