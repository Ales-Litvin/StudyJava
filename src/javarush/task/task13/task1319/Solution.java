package javarush.task.task13.task1319;

/*
Писатель в файл с консоли
 */

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();

        ArrayList<String> list = new ArrayList<>();
        String stringInput;

        while (true){
            stringInput = reader.readLine();
            if (stringInput.equals("exit")) {
                list.add(stringInput);
                break;
            }
            else {
                list.add(stringInput);
            }
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(nameFile));

        for (String text: list) {
            writer.write(text);
            writer.newLine();
        }

        writer.close();

    }
}
