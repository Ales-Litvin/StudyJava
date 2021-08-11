package javarush.task.task19.task1906;

/*
Четрные символы
 */

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        FileReader reader = new FileReader(bufferedReader.readLine());
        FileWriter writer = new FileWriter(bufferedReader.readLine());
        bufferedReader.close();

        int count = 1;

        while (reader.ready()){
            int data = reader.read();
            if (count%2 == 0){
                writer.write(data);
            }
            count++;
        }
        reader.close();
        writer.close();

    }
}
