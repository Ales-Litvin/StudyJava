package by.epam.learn.io.tasks.optionaltask.task01;

import java.io.*;
import java.util.*;

/*
 * 1. Создать и заполнить файл случайными целыми числами.
 *    Отсортировать содержимое файла по возрастанию.
 */
public class Solution {
    public static void main(String[] args) {
        String filename = "src\\" +
                Solution.class.getPackage().getName().replace('.', '\\') +
                "\\testFile.txt";

        mainProcess(filename);
    }

    public static void mainProcess(String filename) {
        List<Integer> list = null;
        try (Scanner scanner = new Scanner(new File(filename))) {
            list = new ArrayList<>();
            while (scanner.hasNextLine()) {
                for (String str : scanner.next().split("\\s*")) {
                    list.add(Integer.parseInt(str));
                }
            }
            Collections.sort(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (list != null) {

            try (PrintWriter print = new PrintWriter(new FileWriter(new File(filename)))) {
                for (int i : list) {
                    print.printf("%d ", i);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}