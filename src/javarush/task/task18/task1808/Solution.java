package javarush.task.task18.task1808;

/*
Разделение файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

/*
G:\Test1.txt
G:\Test2.txt
G:\Test3.txt
 */


public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        reader.close();

        FileInputStream inputStream = new FileInputStream(fileName1);
        FileOutputStream outputStreamOne = new FileOutputStream(fileName2);
        FileOutputStream outputStreamTwo = new FileOutputStream(fileName3);

        int countByte;

        System.out.println(inputStream.available());
        System.out.println(inputStream.available()%2);

        if (inputStream.available()%2 == 0)
            countByte = inputStream.available() / 2;
        else
            countByte = (inputStream.available() / 2) + 1;

        System.out.println(countByte);


        int count = 0;


        while(inputStream.available() > 0) {
            int byteReader = inputStream.read();

            if (count < countByte)
                outputStreamOne.write(byteReader);
            else
                outputStreamTwo.write(byteReader);

            count++;
        }

        inputStream.close();
        outputStreamOne.close();
        outputStreamTwo.close();

    }
}