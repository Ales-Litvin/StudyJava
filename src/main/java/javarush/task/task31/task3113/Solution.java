package javarush.task.task31.task3113;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/*
Что внутри папки?
*/
public class Solution {
    public static int countFolder = -1;
    public static int countFile = 0;
    public static long size = 0L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String fileName = br.readLine();
        br.close();

        Path path = Paths.get(fileName);

        if (!Files.isDirectory(path)){
            System.out.println(fileName + " - не папка");
            return;
        }

        Files.walkFileTree(path, new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                countFile += 1;
                size += (long) Files.readAllBytes(file).length;
                return super.visitFile(file, attrs);
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                countFolder += 1;
                return super.preVisitDirectory(dir, attrs);
            }
        });

        System.out.println("Всего папок - " + countFolder);
        System.out.println("Всего файлов - " + countFile);
        System.out.println("Общий размер - " + size);
    }
}