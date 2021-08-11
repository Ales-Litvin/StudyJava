package javarush.task.task32.task3201;

import java.io.RandomAccessFile;
import java.io.IOException;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
        if (raf.length() < Integer.parseInt(args[1])){
            raf.seek(raf.length());
        } else {
            raf.seek(Long.parseLong(args[1]));
        }
        raf.write(args[2].getBytes());
        raf.close();
    }
}