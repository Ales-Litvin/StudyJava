package javarush.task.task18.task1818;

/*
Два в одном
 */

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameOne = reader.readLine();
        String fileNameTwo = reader.readLine();
        String fileNameThree = reader.readLine();
        reader.close();
        FileInputStream inputStreamTwo = new FileInputStream(fileNameTwo);
        FileOutputStream outputStreamOne = new FileOutputStream(fileNameOne);

        while (inputStreamTwo.available() > 0){
            outputStreamOne.write(inputStreamTwo.read());
        }
        inputStreamTwo.close();
        outputStreamOne.close();

        FileInputStream inputStreamThree = new FileInputStream(fileNameThree);
        FileOutputStream outputStreamOne_2 = new FileOutputStream(fileNameOne, true);


        while (inputStreamThree.available() > 0){
            outputStreamOne.write(inputStreamThree.read());
        }
        inputStreamThree.close();
        outputStreamOne.close();
    }
}

