package javarush.task.task31.task3101;

/*
path:
G:\Programming\Work\StudyJava\src\javarush\task\task31\task3101\path
resultFileAbsolutePath:
G:\Programming\Work\StudyJava\src\javarush\task\task31\task3101\TestFile.txt
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        // путь к директории
        File path = new File(args[0]);
        // имя (полный путь) сущесвующего фала, который будет содержать результат
        File resultFileAbsolutePath = new File(args[1]);
        String newName = resultFileAbsolutePath.getParent() + "/test.txt";
        File newFile = new File(newName);
        FileUtils.renameFile(resultFileAbsolutePath, newFile);

        List<File> list = new ArrayList<>();

         /*
            -> Стрелка -- лямда оператор
            Этот оператор разделяет лямбда-выражение на две части:
            левая часть содержит список параметров выражения,
            а правая собственно представляет тело лямбда-выражения,
            где выполняются все действия.

         try (Stream<Path> walk = Files.walk(Paths.get(path.getAbsolutePath()))) {
            walk.forEach(filePath -> {
                if (Files.isRegularFile(filePath) && filePath.toFile().length() <= 50) {
                    list.add(filePath.toFile());
                }
            });
            walk.close();
        }
          */


        readFileName(list, path);

        Collections.sort(list, new Comparator<File>(){
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        FileOutputStream bw = new FileOutputStream(newFile, true);

        for (File file : list){
            try ( FileInputStream br = new FileInputStream(file)) {
                while (br.available() > 0) {
                    bw.write(br.read());
                    bw.flush();
                }
                bw.write("\n".getBytes());
            }
        }
        bw.close();
    }

    public static void readFileName(List<File> list, File file1){
        for (File file : file1.listFiles()){
            if (file.isFile()){
                if (file.length() <= 50)
                    list.add(file);
            } else {
                readFileName(list, file.getAbsoluteFile());
            }
        }
    }
}