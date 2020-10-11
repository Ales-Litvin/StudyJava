package by_epam.introduction_to_java.strings_3.working_with_a_string_as_an_array.task04;

/*
 * Условие задачи
 * 4. В строке найти количество чисел.
 */

public class Solution {
    public static void main(String[] args) {
        String string = "1 sdk12 sfj 1 443o 32ij 654156884 234 231 1";

        System.out.println(countNumbers(string));
    }

    /**
     * Counts the numbers in the string
     * @param string string for counting
     * @return Counts of numbers
     */
    public static int countNumbers(String string){
        String[] strings = string.split("\\s");
        int count = 0;

        for (String s : strings){
            if (isNumber(s)) {
                count++;
            }
        }
        return count;
    }

    /**
     * This method returns true if string is number
      * @param string string for check
     * @return true if string is number
     */
    public static boolean isNumber(String string){
        for(char c : string.toCharArray()){
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
