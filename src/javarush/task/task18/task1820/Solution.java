package javarush.task.task18.task1820;

/*
Округление чисел
 */

/*
G:\Test.txt
G:\Test1.txt
 */

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameOne = reader.readLine();
        String fileNameTwo = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(fileNameOne);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        bufferedReader.close();
        inputStream.close();

        FileOutputStream fileOutputStream = new FileOutputStream(fileNameTwo);

        while (tokenizer.hasMoreTokens()) {
            float k = Float.parseFloat((String) tokenizer.nextElement());
            int i = Math.round(k);
            String m = i + " ";
            fileOutputStream.write(m.getBytes());
        }

        fileOutputStream.close();
    }
}
