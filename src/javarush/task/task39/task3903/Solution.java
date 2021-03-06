package javarush.task.task39.task3903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Неравноценный обмен
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter a number: ");

        long number = Long.parseLong(reader.readLine());
        System.out.println("Please enter the first index: ");
        int i = Integer.parseInt(reader.readLine());
        System.out.println("Please enter the second index: ");
        int j = Integer.parseInt(reader.readLine());

        System.out.println("The result of swapping bits is " + swapBits(number, i, j));
    }

    public static long swapBits(long number, int i, int j) {
        long bit1 = (number >> i) & 1;// bit at pos1
        long bit2 = (number >> j) & 1;// bit at pos2

        if (bit1 == bit2)
            return number; // no need to swap since we change 1 with 1 or 0 with 0

        // Since we are here it means that we need to change 1->0 and 0->1.
        // To do this we can use XOR (^).
        // Lets create mask 000001010 with ones at specified positions
        int mask = (1 << i) | (1 << j);

        return number ^ mask; // Yea!
    }
}