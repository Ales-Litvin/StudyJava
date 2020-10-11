package by_epam.introduction_to_java.strings_3.working_with_a_string_as_String_or_StringBuilder.task03;

/*
 * Условие задачи:
 * 3. Проверить, является ли заданное слово палиндромом.
 */

public class Solution {
    public static void main(String[] args) {
        String stringOne = "palindrome";
        String stringTwo = "Noon";
        String stringThree = "Was it a car or a cat I saw";
        String stringFour = "Malayalam";

        System.out.println("'" + stringOne + "'" + " is palindrome : " + isPalindrome(stringOne));
        System.out.println("'" + stringTwo + "'" + " is palindrome : " + isPalindrome(stringTwo));
        System.out.println("'" + stringThree + "'" + " is palindrome : " + isPalindrome(stringThree));
        System.out.println("'" + stringFour + "'" + " is palindrome : " + isPalindrome(stringFour));

    }

    /**
     * Is word palindrome?
     * @param string a string
     * @return if word is a palindrome returns true, else false
     */
    public static boolean isPalindrome(String string){
        StringBuilder builder = new StringBuilder(string);
        builder.reverse();

        if (string.toLowerCase().equals(builder.toString().toLowerCase())){
            return true;
        }
        return false;
    }

}
