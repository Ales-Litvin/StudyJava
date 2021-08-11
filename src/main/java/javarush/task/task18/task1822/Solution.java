package javarush.task.task18.task1822;

/*
Поиск данных внутри файла
 */

/*
G:\Test.txt
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        String id = args[0];

        BufferedReader fileReader = new BufferedReader(new InputStreamReader(
                new FileInputStream(fileName)));

        StringTokenizer tokenizer;
        String string;
        String thisString;
        while ((string = fileReader.readLine()) != null){
            tokenizer = new StringTokenizer(string);
            thisString = tokenizer.nextToken();
            if (id.equals(thisString)){
                System.out.printf("%s ", thisString);
                while (tokenizer.hasMoreTokens()){
                    System.out.printf("%s ", tokenizer.nextToken());
                }
                break;
            }
        }
        fileReader.close();
    }
}
