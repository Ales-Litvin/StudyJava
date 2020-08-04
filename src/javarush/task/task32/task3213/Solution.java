package javarush.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;

/*
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        StringBuilder stringBuilder = new StringBuilder("");
        if (reader == null) return stringBuilder.toString();
        char[] buffer = new char[1];
        while (reader.read(buffer) > -1){
            for (char c : buffer){
                c += key;
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}