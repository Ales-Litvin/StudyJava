package by.epam.learn.io.tasks.optionaltask.task06;

import java.io.*;
import java.time.DayOfWeek;
import java.util.Scanner;
import java.util.regex.Pattern;

/*
 * 6. Файл содержит символы, слова, целые числа и числа с плавающей запятой.
 *    Определить все данные, тип которых вводится из командной строки.
 */
public class Solution {
    public static void main(String[] args) {
        String filename = "src\\" +
                Solution.class.getPackage().getName().replace('.', '\\') +
                "\\testFile.txt";

        System.out.println("Write type of data, please...");
        Scanner console = new Scanner(System.in);

        DataType type = DataType.valueOf(console.nextLine().toUpperCase());

        findAllData(type, new PrintWriter(System.out), filename);
    }


    public static void findAllData(DataType type, PrintWriter writer, String filename){
        String patter = getPattern(type);
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String data = null;
            while ((data = reader.readLine()) != null){
                for (String str : data.split(" ")){
                    if (str.matches(patter)){
                        System.out.println(str);
                        writer.println(str);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPattern(DataType type){
        switch (type){
            case WORD: return "[^\\d\\s]{2,}";
            case CHAR: return "\\D";
            case NUMBER: return "\\d+";
            case FLOAT: return "\\d+,\\d+";
            default: return null;
        }
    }
}