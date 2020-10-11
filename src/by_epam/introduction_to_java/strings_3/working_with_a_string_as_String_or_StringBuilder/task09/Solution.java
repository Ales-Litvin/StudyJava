package by_epam.introduction_to_java.strings_3.working_with_a_string_as_String_or_StringBuilder.task09;

/*
 * Условие задачи:
 * 9. Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке.
 *    Учитывать только английские буквы.
 */

public class Solution {
    public static void main(String[] args) {
        String string = "Public opinion is a weak tyrant compared with our own private opinion.";

        printResultTypeOfCase(string);
    }

    /**
     * Printing count of lower case and upper case letters
     * @param string a string
     */
    public static void printResultTypeOfCase(String string){
        System.out.println("Count of lower case letters : " + countOfLowercaseLetters(string));
        System.out.println("Count of upper case letters : " + countOfUppercaseLetters(string));
    }

    /**
     * Returns count of lower case letters
     * @param string a string
     * @return count of lower case letters
     */
    public static int countOfLowercaseLetters(String string){
        int count = 0;

        for (char c : string.toCharArray()){
            if ('a' <= c && c <= 'z'){
                count++;
            }
        }
        return count;
    }

    /**
     * Returns count of upper case letters
     * @param string a string
     * @return count of upper case letters
     */
    public static int countOfUppercaseLetters(String string){
        int count = 0;

        for (char c : string.toCharArray()){
            if ('A' <= c && c <= 'Z'){
                count++;
            }
        }
        return count;
    }
}
