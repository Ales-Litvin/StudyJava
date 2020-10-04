package by_epam.basics_1.cycles.task07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(reader.readLine());
        int n = Integer.parseInt(reader.readLine());

        reader.close();

        printAllDivisorBetween(m, n);
    }

    public static void printAllDivisorBetween(int m, int n){
        for (int i = m; i <= n; i++){
            System.out.print("Divider \""+ i + "\" : ");
            for (int k = 2; k < i; k++){
                if (i % k == 0){
                    System.out.print(" " + k + " ");
                }
            }
            System.out.println("");
        }
    }
}
