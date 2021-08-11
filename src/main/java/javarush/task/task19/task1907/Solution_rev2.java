package javarush.task.task19.task1907;

/*
G:\Test3.txt
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution_rev2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader reader = new FileReader(bufferedReader.readLine());
        Scanner scanner = new Scanner(reader);
        bufferedReader.close();

        int count = 0;
        while (scanner.hasNextLine()){
            String string = scanner.nextLine();
            for (String strings :string.split("[\\s,.!]+")){
                if (strings.equals("world")){
                    count++;
                }
            }
        }
        reader.close();
        scanner.close();
        System.out.print(count);
    }
}
