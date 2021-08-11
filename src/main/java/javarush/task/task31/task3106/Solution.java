package javarush.task.task31.task3106;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        String[] arrayParts = Arrays.copyOfRange(args, 1, args.length);
        Arrays.sort(arrayParts);
        List<FileInputStream> streamList = new ArrayList<>();
        for (String string : arrayParts){
            streamList.add(new FileInputStream(string));
        }

        ZipInputStream is = new ZipInputStream(new SequenceInputStream(Collections.enumeration(streamList)));
        try {
            for (ZipEntry entry = null; (entry = is.getNextEntry()) != null; ) {
                OutputStream os = new BufferedOutputStream(new FileOutputStream(args[0]));
                try {
                    final int bufferSize = 1024;
                    byte[] buffer = new byte[bufferSize];
                    for(int readBytes = -1; (readBytes = is.read(buffer, 0, bufferSize)) > -1; ) {
                        os.write(buffer, 0, readBytes);
                    }
                    os.flush();
                } finally {
                    os.close();
                }
            }
        } finally {
            is.close();
        }
    }
}