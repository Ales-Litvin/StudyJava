package by.epam.introduction_to_java.basics_of_OOP_5.task01;

/*
 * Условие задачи:
 * Задача 1.
 * Создать объект класса Текстовый файл, используя классы Файл, Директория.
 * Методы: создать, переименовать, вывести на консоль содержимое, дополнить,
 * удалить.
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println("Создаем объект текстовый файл:");
        TextFile textFile = new TextFile("File 1", "Содержимое файла");

        System.out.println("Создаем директорию");
        Directory directory = new Directory("New folder 1");

        System.out.println("Добавим текстовый файл:");
        directory.add(textFile);
        System.out.println(directory);

        System.out.println("Создадим деректории");
        directory.createDirectories("New folder 2");
        System.out.println(directory);

        System.out.println("Переименуем файл");
        directory.renameFile("File 1", "File 2");
        System.out.println(directory);

        System.out.println("Выведем содержимое файла в консоль:");
        System.out.println(directory.getContent("File 2"));

        System.out.println("Дополним содержимое файла:");
        directory.modifyFile("File 2", "Новое содержимое файла");
        System.out.println(directory.getContent("File 2"));

        System.out.println("Удаляем файл и директорию");
        directory.removeFile("File 2");
        directory.removeDirectory("New folder 2");
        System.out.println(directory);
    }
}