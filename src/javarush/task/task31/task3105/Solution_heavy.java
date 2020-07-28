package javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
File:
G:\Programming\Work\StudyJava\src\javarush\task\task31\task3105\test\TestFile1.txt
Zip:
G:\Programming\Work\StudyJava\src\javarush\task\task31\task3105\test\test.zip
 */

/*
Добавление файла в архив
*/
public class Solution_heavy {
    public static void main(String[] args) throws IOException {
        Path fileName = Paths.get(args[0]); // args[0]
        // Путь к zip архиву
        Path zipFile = Paths.get(args[1]); // args[1]

        // Map тут типо будем все хранить
        Map<Path, ByteArrayOutputStream> map = new HashMap<>();

        try (FileInputStream fileInputStream = new FileInputStream(args[1])){
            try (ZipInputStream zipInputStream = new ZipInputStream(fileInputStream)){
                ZipEntry zipEntry = null;
                while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                    Path archivedFile = Paths.get(zipEntry.getName());
                    ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                    while (zipInputStream.available() > 0) {
                        byte[] buffer = new byte[1024 * 1024];
                        zipInputStream.read(buffer);
                        byteArray.write(buffer);
                    }
                    map.put(Paths.get(zipEntry.getName()), byteArray);
                }
            }  catch (IOException ioE) {
                ioE.printStackTrace();
            }
        }

        Path newPath = null;
        if (map.containsKey(fileName.getFileName())) {
            System.out.println("Файл уже есть в архиве. Нужно его обновить.");
            newPath = fileName.getFileName();
        } else {
            newPath = Paths.get("new/" + fileName.getFileName().toString());
        }

        try (FileInputStream fileInputStream = new FileInputStream(fileName.toString())) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (fileInputStream.available() > 0) {
                byte[] buffer = new byte[1024 * 1024];
                fileInputStream.read(buffer);
                byteArrayOutputStream.write(buffer);
            }
            byteArrayOutputStream.write(fileInputStream.read());
            map.put(newPath, byteArrayOutputStream);
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(args[1])) {
            try (ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream)) {
                for (Map.Entry<Path, ByteArrayOutputStream> pair : map.entrySet()) {
                    Path key = pair.getKey();
                    ByteArrayOutputStream byteArrayOutputStream = pair.getValue();
                    ZipEntry zipEntry = new ZipEntry(key.toString());
                    zipOutputStream.putNextEntry(zipEntry);
                    byte[] buffer = byteArrayOutputStream.toByteArray();
                    zipOutputStream.write(buffer);
                    //zipOutputStream.write(byteArrayOutputStream.toByteArray());
                }
            }
        }
    }
}