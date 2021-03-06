package javarush.task.task31.task3103;

import java.io.IOException;
import java.util.List;
import java.nio.file.Paths;
import java.nio.file.Files;

/*
Своя реализация
*/
public class Solution {
    public static byte[] readBytes(String fileName) throws IOException {
        return Files.readAllBytes(Paths.get(fileName));
    }

    public static List<String> readLines(String fileName) throws IOException {
        return Files.readAllLines(Paths.get(fileName));
    }

    public static void writeBytes(String fileName, byte[] bytes) throws IOException {
        Files.write(Paths.get(fileName), bytes);
    }

    public static void copy(String resourceFileName, String destinationFileName) throws IOException {
        Files.copy(Paths.get(resourceFileName),
                Paths.get(destinationFileName));
    }
}