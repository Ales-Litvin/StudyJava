package javarush.task.task31.task3110;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для получения списка всех файлов в какой-то папке
 * @autor Aleksandr
 * @version 0.1
 */
public class FileManager {
    private Path rootPath;
    private List<Path> fileList;

    /**
     * Конструктор - инициализация
     * @param rootPath - путь указывающий на корень
     *                 (папку, файлы в которой на интерисуют)
     */
    public FileManager(Path rootPath) throws IOException {
        this.rootPath = rootPath;
        this.fileList = new ArrayList<>();
        collectFileList(rootPath);
    }

    public List<Path> getFileList() {
        return fileList;
    }

    /**
     * Складывает в переменную {@link FileManager#fileList} все файлы, обнаруженные внутри
     *         переданного пути path вызывая сам себя для всех объектов, в обнаруженных
     *         директрориях.
     * @param path - переданный путь
     */
    private void collectFileList(Path path) throws IOException {
        if (Files.isRegularFile(path))
            fileList.add(rootPath.relativize(path));
        else if (Files.isDirectory(path)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
                for (Path p : stream) {
                    collectFileList(p);
                }
            } catch (DirectoryIteratorException x) {
                // IOException can never be thrown by the iteration.
                // In this snippet, it can only be thrown by newDirectoryStream.
            }
        }
    }
}
