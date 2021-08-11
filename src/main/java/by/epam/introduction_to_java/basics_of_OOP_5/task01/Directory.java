package by.epam.introduction_to_java.basics_of_OOP_5.task01;
/*
 * Условие задачи:
 * Задача 1.
 * Создать объект класса Текстовый файл, используя классы Файл, Директория.
 * Методы: создать, переименовать, вывести на консоль содержимое, дополнить,
 * удалить.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Directory {
    private String name;
    private List<File> files;
    private List<Directory> directories;

    public Directory(String name) {
        this.name = name;
        this.files = new ArrayList<>();
        this.directories = new ArrayList<>();
    }

    public Directory(String name, List<File> files, List<Directory> directories) {
        this.name = name;
        if (files != null) {
            this.files = files;
        } else {
            this.files = new ArrayList<>();
        }
        if (files != null) {
            this.directories = directories;
        } else {
            this.directories = new ArrayList<>();
        }
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public List<File> getFiles() { return files; }

    public List<Directory> getDirectories() { return directories; }

    public void add(File file){
        files.add(file);
    }

    public void add(Directory directory){
        directories.add(directory);
    }

    public void createFile(String name){
        files.add(new File(name));
    }

    public void createDirectories(String name){
        directories.add(new Directory(name));
    }

    public void renameFile(String oldName, String newName){
        for (File file : files){
            if (file.getName().equals(oldName)){
                file.setName(newName);
            }
        }
    }

    public void renameDirectory(String oldName, String newName){
        for (Directory directory : directories){
            if (directory.getName().equals(oldName)){
                directory.setName(newName);
            }
        }
    }

    public String getContent(String fileName){
        for (File file : files){
            if (file.getName().equals(fileName) && file instanceof TextFile){
                return ((TextFile) file).getContent();
            }
        }
        return null;
    }

    public void modifyFile(String fileName, String newContent){
        for (File file : files){
            if (file.getName().equals(fileName) && file instanceof TextFile){
              ((TextFile) file).setContent(newContent);
            }
        }
    }

    public void removeFile(String fileName){
        files.removeIf(file -> file.getName().equals(fileName));
    }

    public void removeDirectory(String name){
        directories.removeIf(directory -> directory.getName().equals(name));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Directory)) return false;
        Directory directory = (Directory) o;
        return Objects.equals(getName(), directory.getName()) &&
                Objects.equals(getFiles(), directory.getFiles()) &&
                Objects.equals(getDirectories(), directory.getDirectories());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getFiles(), getDirectories());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Directory{");
        sb.append("name='").append(name).append('\'');
        sb.append(", files=").append(Arrays.toString(files.toArray()));
        sb.append(", directories=").append(Arrays.toString(directories.toArray()));
        sb.append('}');
        return sb.toString();
    }
}
