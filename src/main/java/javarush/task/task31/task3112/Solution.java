package javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));
        /*
        Path passwords = downloadFile("http://www.info-haus.com/content/PDF/katalog%20PTH.pdf",
                Paths.get("G:\\Programming\\Work\\StudyJava\\src\\javarush\\task\\task31\\task3112"));
         */


        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    /**
     * The method download file
     * @param urlString - link for download file
     * @param downloadDirectory - folder for load file
     * @return path loading file
     * @throws IOException sometimes throws
     */
    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();

        Path tempFile = Files.createTempFile("temp-",".tmp");
        Files.copy(inputStream, tempFile);

        String fileName = urlString.substring(urlString.lastIndexOf("/") + 1);
        Path result = downloadDirectory.resolve(fileName);
        Files.move(tempFile, result);

        return result;
    }
}