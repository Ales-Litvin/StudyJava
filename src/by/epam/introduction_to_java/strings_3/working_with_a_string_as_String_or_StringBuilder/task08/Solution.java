package by.epam.introduction_to_java.strings_3.working_with_a_string_as_String_or_StringBuilder.task08;

/*
 * Условие задачи:
 * 8. Вводится строка слов, разделенных пробелами.
 * Найти самое длинное слово и вывести его на экран.
 * Случай, когда самых длинных слов может быть несколько, не обрабатывать.
 */
public class Solution {
    public static void main(String[] args) {
        String string = "Public opinion is a weak tyrant compared with our own private opinion.";

        System.out.println(searchTheLongestWord(string));
    }

    /**
     * Searches the longest word in the {@param string}
     * @param string a string
     * @return the longest word in the {@param string}
     */
    public static String searchTheLongestWord(String string){
        String theLongest = "";

        for (String s : string.split("\\s")){
            if (s.length() > theLongest.length()){
                theLongest = s;
            }
        }
        return theLongest;
    }
}
