package by_epam.basics_1.cycles.task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(sum(Integer.parseInt(reader.readLine())));

        reader.close();
    }

    public static int sum(int x){
        int result = 0;
        for (int i = 1; i < x; i++){
            result += i;
        }
        return result;
    }
}
