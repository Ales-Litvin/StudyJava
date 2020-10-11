package by_epam.introduction_to_java.strings_3.working_with_a_string_as_String_or_StringBuilder.task05;

/*
 * Условие задачи:
 * 5. Подсчитать, сколько раз среди символов заданной строки встречается буква “а”.
 */
public class Solution {
    public static void main(String[] args) {
        String stringOne = "Public opinion is a weak tyrant compared with our own private opinion.";

        String stringTwo = "aaa";

        System.out.println(countsOfLetter(stringOne, 'a'));
        System.out.println(countsOfLetter(stringTwo, 'a'));

    }

    /**
     * Counts of letter {@param c} in the {@param string}
     * @param string a string
     * @param c a character
     * @return count of letter {@param c} in the {@param string}
     */
    public static int countsOfLetter(String string, char c){
        int count = 0;
        int fromIndex = -1;
        while ((fromIndex = string.indexOf(c, fromIndex) + 1) > 0){
            count++;
        }
        return count;
    }


}
