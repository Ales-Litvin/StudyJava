package by_epam.introduction_to_java.strings_3.working_with_a_string_as_an_array.task02;

/*
 * Условие задачи:
 * 2. Замените в строке все вхождения 'word' на 'letter'.
 */

public class Solution {
    public static void main(String[] args) {
        String stringOne = "A written word is the choicest of relics.";
        String stringTwo = "It's hard to describe music in the written word.";

        System.out.println(replaceWordToLetter(stringOne));
        System.out.println(replaceWordToLetter(stringTwo));

    }

    /**
     * This method replace in the passed string word "word" in "letter"
     * @param string string for replace words
     * @return A modified string
     */
    public static String replaceWordToLetter(String string){
        char[] chars = string.toCharArray();

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < chars.length; i++){
            if ((i + 3) < chars.length &&
                chars[i] == 'w' &&
                chars[i + 1] == 'o' &&
                chars[i + 2] == 'r' &&
                chars[i + 3] == 'd'){
                builder.append("letter");
                i += 3;
                continue;
            }
            builder.append(chars[i]);
        }
        return builder.toString();
    }
}
