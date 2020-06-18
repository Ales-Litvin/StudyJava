package javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    public static void main(String[] args) {
        try {
            FileInputStream inputStream = new FileInputStream(Statics.FILE_NAME);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String str;

            while ((str = reader.readLine()) != null) {
                lines.add(str);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
        }
        catch (IOException e){
            System.out.println("Не удается прочитать файл");
        }
        System.out.println(lines);
    }

}