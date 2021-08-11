package javarush.task.task18.task1825;

/*
Lion.avi.part1
Lion.avi.part2
Lion.avi.part3
Lion.avi.part4
Lion.avi.part5
 */

/*
Lion.avi.part4
Lion.avi.part5
Lion.avi.part3
Lion.avi.part2
Lion.avi.part1
 */

/*
Собираем файл
*/

import java.io.*;
import java.util.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName; // имя файла считанное с консоли
        TreeSet<String> set = new TreeSet<>();

        while (!("end".equals(fileName = bufferedReader.readLine()))) {
            set.add(fileName);
        }
        bufferedReader.close();

        char[] chars = set.first().toCharArray();

        String fileNameOut = new String (chars, 0, set.first().indexOf("part") - 1);
        System.out.println(fileNameOut);
        System.out.println(set);


        FileOutputStream outputStream = new FileOutputStream(fileNameOut, true);

        for (String s : set){
            FileInputStream inputStream = new FileInputStream(s);
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            outputStream.write(buffer);

            inputStream.close();
        }
        outputStream.close();
    }
}