package javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
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
public class Solution {
    public static void main(String[] args) throws IOException {
        // Полный путь к файлу
        Path file = Paths.get(args[0]);
        // Путь к zip архиву
        Path zipFile = Paths.get(args[1]);

        // Проверяем существует ли zip файл
        if (!Files.isRegularFile(zipFile)) {
            // Если фала нет то лучше бросить исключение
        }

        // Создаем временный файл
        Path tempFile = Files.createTempFile(null, null);

        // Список файлов оригинального архива
        List<Path> archivedFiles = new ArrayList<>();

        // Проходимся по всем файлам оригинального архива
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(tempFile))) {
            try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile))) {
                ZipEntry zipEntry = null;
                while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                    // Архивный файл из zipEntry
                    Path archivedFile = Paths.get(zipEntry.getName());
                    archivedFiles.add(archivedFile);

                    // Если файла не в архиве то копируем его в -temp file
                    if (!archivedFile.equals(file.getFileName())) {
                        // Копируем файлы во временный файл
                        String fileName = zipEntry.getName();
                        zipOutputStream.putNextEntry(new ZipEntry(fileName));
                        while (zipInputStream.available() > 0) {
                            zipOutputStream.write(zipInputStream.read());
                        }
                        zipOutputStream.closeEntry();
                        zipInputStream.closeEntry();
                    }
                }
            }

            ZipEntry newZipEntry = new ZipEntry(file.getFileName().toString());

            if (!Files.exists(file) || !Files.isRegularFile(file)) {
                // Если файл не существует или это папка здесь лучше бросить исключение
            } else if (archivedFiles.contains(file.getFileName())) {
                System.out.println("Файл уже есть в архиве. Нужно его обновить.");
            } else {
                newZipEntry = new ZipEntry("new\\" + file.getFileName().toString());
            }

            try (InputStream inputStream = Files.newInputStream(file)) {
                zipOutputStream.putNextEntry(newZipEntry);
                while (inputStream.available() > 0) {
                    zipOutputStream.write(inputStream.read());
                }
                zipOutputStream.closeEntry();
            } catch (Exception e) { e.printStackTrace(); }
            System.out.println("Файл " + file.getFileName() + " добавлен в архив.");

        } catch (IOException ioE) {
            ioE.printStackTrace();
        }
        Files.move(tempFile, zipFile, StandardCopyOption.REPLACE_EXISTING);
    }
}