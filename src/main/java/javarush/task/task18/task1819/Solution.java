package javarush.task.task18.task1819;

/*
Объединение файлов
 */

/*
G:\Test.txt
G:\Test2.txt
 */

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameOne = reader.readLine();
        String fileNameTwo = reader.readLine();
        reader.close();

        FileInputStream inputStreamOne = new FileInputStream(fileNameOne);
        ArrayList<Integer> arrayListOne = new ArrayList<>();
        while (inputStreamOne.available() > 0){
            arrayListOne.add(inputStreamOne.read());
        }

        FileOutputStream outputStreamOne = new FileOutputStream(fileNameOne);
        FileInputStream inputStreamTwo = new FileInputStream(fileNameTwo);
        ArrayList<Integer> arrayListTwo = new ArrayList<>();
        while (inputStreamTwo.available() > 0){
            arrayListTwo.add(inputStreamTwo.read());
        }

        arrayListTwo.addAll(arrayListOne);

        int i = 0;
        while (i < arrayListTwo.size()){
            int bytes = arrayListTwo.get(i);
            outputStreamOne.write(bytes);
            System.out.println((char) bytes);
            i++;
        }

            outputStreamOne.close();
            inputStreamOne.close();
            inputStreamTwo.close();

    }
}
