package javarush.task.task31.task3102;

import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.*;

/*
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> result = new ArrayList<>();
        File folder = new File(root);
        Queue<File> queue = new PriorityQueue<>();
        queue.add(folder);

        do {
            for (File file : queue.remove().listFiles()){
                if (file.isFile())
                    result.add(file.getAbsolutePath());
                else if (file.isDirectory())
                    queue.add(file);
            }
        } while (!queue.isEmpty());
        return result;
    }

    public static void main(String[] args) {
    }
}