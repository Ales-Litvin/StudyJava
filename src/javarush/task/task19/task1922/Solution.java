package javarush.task.task19.task1922;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

/*
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(filename));

        String data;
        while ((data = fileReader.readLine()) != null){
            int count = 0;
            for (String strings :data.split("[\\s,.!]+")){
                if (words.contains(strings))
                    count++;
            }
            if (count == 2)
                System.out.println(data);
        }
        fileReader.close();
    }
}