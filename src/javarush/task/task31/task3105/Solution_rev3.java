package javarush.task.task31.task3105;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
public class Solution_rev3 {
    public static void main(String[] args) throws IOException {
        Map<String, ByteArrayOutputStream> map = new HashMap<>();
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(args[1]))) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] bytes = new byte[1024*1024];
                //byte[] bytes = new byte[zis.available()];
                int count;
                while ((count = zis.read(bytes)) != -1) {
                    baos.write(bytes, 0, count);
                }
                map.put(entry.getName(), baos);
                baos.close();
                zis.closeEntry();
            }
        }

        try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(args[1]))) {
            String fileName = args[0].substring(args[0].lastIndexOf("/") + 1);
            Path newFile = Paths.get(args[0]);

            for (Map.Entry<String, ByteArrayOutputStream> pair :map.entrySet()) {
                if (fileName.equals(pair.getKey().substring(pair.getKey().lastIndexOf("/") + 1))) continue;
                zip.putNextEntry(new ZipEntry(pair.getKey()));
                zip.write(pair.getValue().toByteArray());
                zip.closeEntry();
            }

            ZipEntry newEntry = new ZipEntry("new/" + fileName);
            zip.putNextEntry(newEntry);
            Files.copy(newFile,zip);
            zip.closeEntry();
        }
    }
}