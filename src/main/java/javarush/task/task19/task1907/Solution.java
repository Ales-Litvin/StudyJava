package javarush.task.task19.task1907;

/*
Считаем слово
 */

/*
G:\Test3.txt
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader reader = new FileReader(bufferedReader.readLine());
        Scanner scanner = new Scanner(reader);
        bufferedReader.close();

        int count = 0;
        while (scanner.hasNextLine()){
            String string = scanner.nextLine();
            int i = 0;
            while (string.indexOf("world", i) >= 0){
                i = string.indexOf("world", i) + 5;
                count++;
                }
            }
        reader.close();
        scanner.close();
        System.out.print(count);
    }
}
