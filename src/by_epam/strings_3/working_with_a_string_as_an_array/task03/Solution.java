package by_epam.strings_3.working_with_a_string_as_an_array.task03;

/*
 * Условие задачи
 * 3. В строке найти количество цифр.
 */

public class Solution {
    public static void main(String[] args) {
        String string = "1 sdk12 sfj 1 443o 32ij 654156884 234 231 1";

        System.out.println(countNumbers(string));
    }

    /**
     * Counts the digits in the string
     * @param string string for counting
     * @return Counts of digit
     */
    public static int countNumbers(String string){
        int count = 0;

        for (char c : string.toCharArray()){
            if (Character.isDigit(c)) {
                count++;
            }
        }
        return count;
    }
}
