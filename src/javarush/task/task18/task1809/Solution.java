package javarush.task.task18.task1809;

/*
G:\Test1.txt
G:\Test2.txt
 */

/*
Реверс файла
 */

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(fileName1);
        FileOutputStream outputStreamOne = new FileOutputStream(fileName2);

        ArrayList<Integer> list = new ArrayList<>();

        while(inputStream.available() > 0) {
            int byteReader = inputStream.read();
            list.add(byteReader);
        }

        for (int i = list.size() - 1; i >= 0; i--){
            outputStreamOne.write(list.get(i));
        }

        inputStream.close();
        outputStreamOne.close();

    }
}
