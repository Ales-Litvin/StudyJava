package by_epam.strings_3.working_with_a_string_as_String_or_StringBuilder.task02;

/*
 * Условие задачи:
 * 2. В строке вставить после каждого символа 'a' символ 'b'.
 */

public class Solution {
    public static void main(String[] args) {
        String string = "Analysts declared each successive generation might be " +
                "the first to have a lower standard of living than their parents.";

        System.out.println(replaceAtoB(string));
    }

    /**
     * Replace all letters 'a' to 'b'
     * @param string a string
     * @return a modified string
     */
    public static String replaceAtoB(String string){

        StringBuilder builder = new StringBuilder();

        for (char c : string.toCharArray()){
            if (c == 'a'){
                builder.append('b');
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }


}
