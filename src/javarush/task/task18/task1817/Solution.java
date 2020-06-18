package javarush.task.task18.task1817;

/*
Пробелы
 */

//G:\Test.txt

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        int countSum = 0;
        int countSpace = 0;
        FileInputStream fileInputStream = new FileInputStream(args[0]);

        while (fileInputStream.available() > 0){
            char c = (char) fileInputStream.read();
            countSum++;
            if (c == ' ')
                countSpace++;
        }
        fileInputStream.close();

        System.out.printf("%.2f", (float) countSpace / countSum * 100);
    }
}
