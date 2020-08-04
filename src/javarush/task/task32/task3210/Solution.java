package javarush.task.task32.task3210;

import java.io.RandomAccessFile;
import java.io.IOException;

/*
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException{
        RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
        byte[] buffer = new byte[args[2].length()];
        raf.seek(Integer.parseInt(args[1]));
        raf.read(buffer, 0, buffer.length);
        String string = new String(buffer);
        raf.seek(raf.length() - raf.getFilePointer());
        if (string.equals(args[2])){
            raf.write("true".getBytes());
        } else {
            raf.write("false".getBytes());
        }
        raf.close();
    }
}