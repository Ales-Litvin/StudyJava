package javarush.task.task13.task1318;

/*
Чтение файла
 */

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        InputStream inStream = new FileInputStream(fileName);

            while (inStream.available() > 0) {
                int data = inStream.read();
                System.out.print((char) data);
            }
        inStream.close();
        }
}
