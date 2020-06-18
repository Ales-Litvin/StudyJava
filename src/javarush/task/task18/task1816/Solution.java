package javarush.task.task18.task1816;

/*
Английские буквы
 */

//G:\Test.txt

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        int count = 0;
        FileInputStream fileInputStream = new FileInputStream(args[0]);

        while (fileInputStream.available() > 0){
            char c = (char) fileInputStream.read();
            if (((c >= 'a')&&(c <= 'z')) || ((c >= 'A')&&(c <= 'Z')))
                count++;

        }
        fileInputStream.close();

        System.out.print(count);
    }
}
