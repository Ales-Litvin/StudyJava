package javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/*
Уникальные подстроки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;

        char[] chars = s.toCharArray();

        int maxLength = 0;

        for (int i = 0; i < chars.length; i++){

            int currentLength = 0;
            Set<Character> set = new HashSet<>();
            for (int j = i; j < chars.length; j++){
                if (!set.contains(chars[j])){
                    set.add(chars[j]);
                    currentLength++;
                } else {
                    break;
                }
            }
            if (currentLength > maxLength) maxLength = currentLength;
        }
        return maxLength;
    }
}
