package javarush.task.task19.task1908;

/*
Выделяем числа
 */

/*
G:\Test3.txt
G:\Test4.txt
 */

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileOne = bufferedReader.readLine();
        String fileTwo = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader bufferedFileReader  = new BufferedReader(new FileReader(fileOne));
        BufferedWriter bufferedFileWriter = new BufferedWriter(new FileWriter(fileTwo));

        String string;
        while ( (string = bufferedFileReader.readLine()) != null) {
            for (String strings : string.split("[\\s,.!]+")) {
                if (strings.matches("[-+]?\\d+")) {
                    bufferedFileWriter.write(strings + " ");
                }
            }
        }

        bufferedFileReader.close();
        bufferedFileWriter.close();
    }
}
