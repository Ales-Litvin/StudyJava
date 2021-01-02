package by.epam.learn.io.tasks.optionaltask.task05;

/*
 *  5. В файле, содержащем фамилии студентов и их оценки, записать прописными
 *     буквами фамилии тех студентов, которые имеют средний балл более 7.
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Solution {
    public static void main(String[] args) {
        String filename = "src\\" +
                Solution.class.getPackage().getName().replace('.', '\\') +
                "\\testFile.txt";

        mainProcess(filename);
    }

    public static void mainProcess(String filename){
        Path file = Paths.get(filename);
        Path temp = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            temp = Files.createTempFile(file.getParent(), null, null);
            Writer out;
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(temp.toString()))){
                String data = null;
                while ((data = reader.readLine()) != null){
                    writer.write(RecordHandler.getModifyString(data) + "\n");
                    writer.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.delete(file);
            temp.toFile().renameTo(file.toFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}