package by_epam.basics_1.cycles.task08;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int a = 36541561;
        int b = 65465566;
        printTheSameNumbers(a, b);
    }

    public static void printTheSameNumbers(int a, int b){
        Set<Character> set = new HashSet<>();
        for (char c : String.valueOf(a).toCharArray()){
            set.add(c);
        }

        Set<Character> set2 = new HashSet<>();
        for (char c : String.valueOf(b).toCharArray()){
            set2.add(c);
        }

        for (char c : set2){
            if (set.contains(c)) System.out.print(c + ", ");
        }
    }
}
