package javarush.task.task31.task3110;

import javarush.task.task31.task3110.exception.PathIsNotFoundException;
import javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Класс менеджера архива который совершает операции над файлом архива
 * (который хранитьс на диске и имеет расширение .zip).
 * @autor Aleksandr
 * @version 0.1
 */
public class ZipFileManager {
    // в переменной path храниться полный путь к архиву
    // Path - Путь
    private Path zipFile;

    /**
     * Конструктор - инициализация zipFIle
     * @param zipFile - путь к архиву
     */
    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }


    /**
     * Архивирует файл заданный переменной source
     * Чтобы заархивировать файл (создать новый архив и добавить в него файл)
     * @param source - путь к чему-то, что мы будем архивировать
     *               это файл который мы будем сжимать, а не в которам
     *               хранить сжатые данные
     */
    public void createZip(Path source) throws Exception {
        if (!Files.isDirectory(zipFile.getParent())) Files.createDirectory(zipFile.getParent());
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))) {
            if (Files.isRegularFile(source)) {
                addNewZipEntry(zipOutputStream, source.getParent(), source.getFileName());
            }
            else if (Files.isDirectory(source)) {
                FileManager fileManager = new FileManager(source);
                List<Path> fileNames = fileManager.getFileList();
                for (Path path : fileNames) {
                    addNewZipEntry(zipOutputStream, source, path);
                }
            } else throw new PathIsNotFoundException();
        } catch (IOException e) { e.printStackTrace(); }
    }


    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception {
        try (InputStream inputStream = Files.newInputStream(filePath.resolve(fileName))) {
            zipOutputStream.putNextEntry(new ZipEntry(fileName.toString()));
            copyData(inputStream, zipOutputStream);
            zipOutputStream.closeEntry();
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void copyData(InputStream in, OutputStream out) throws Exception {
        while (in.available() > 0) { out.write(in.read()); }
    }

    /**
     * Разархивирует файл
     * @param outputFolder - это путь, куда мы будем распаковывать наш архив.
     */
    public void extractAll(Path outputFolder) throws Exception {
        // Проверяем существует ли zip файл
        if (!Files.isRegularFile(zipFile)) { throw new WrongZipFileException(); }
        try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile))) {
            // Создаем директорию вывода, если она не существует
            if (Files.notExists(outputFolder)) { Files.createDirectories(outputFolder); }

            // Проходимся по содержимому zip потока (файла)
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                String fileName = zipEntry.getName();
                Path fileFullName = outputFolder.resolve(fileName);

                // Создаем необходимые директории
                Path parent = fileFullName.getParent();
                if (Files.notExists(parent)) { Files.createDirectories(parent); }
                try (OutputStream outputStream = Files.newOutputStream(fileFullName)) {
                    copyData(zipInputStream, outputStream);
                }
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    /**
     * Удаляет файлы из архива
     * @param pathList - список относительных путей на файлы внутри архива
     */
    public void removeFiles(List<Path> pathList) throws Exception {
        // Проверяем существует ли zip файл
        if (!Files.isRegularFile(zipFile)) { throw new WrongZipFileException(); }

        // Создаем временный файл
        Path tempFile = Files.createTempFile(null, null);

        // Проходимся по всем файлам оригинального архива
        try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile))) {
            try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(tempFile))) {
                ZipEntry zipEntry = null;
                while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                    // Архивный файл из zipEntry
                    Path archivedFile = Paths.get(zipEntry.getName());
                    if (pathList.contains(archivedFile)) {
                        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                        copyData(zipInputStream, buffer);
                        ConsoleHelper.writeMessage("Файл " + zipEntry.getName() + " удален.");
                    } else {
                        String fileName = zipEntry.getName();
                        zipOutputStream.putNextEntry(new ZipEntry(fileName));
                        copyData(zipInputStream, zipOutputStream);
                        zipOutputStream.closeEntry();
                        zipInputStream.closeEntry();
                    }
                }
            }
        } catch (IOException ioE) { ioE.printStackTrace(); }
        Files.move(tempFile, zipFile, StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * Вызывает метод {@link ZipFileManager#removeFiles} создавая список из одного элемента
     * @param path - файл на удаление
     */
    public void removeFile(Path path) throws Exception {
        removeFiles(Collections.singletonList((Path) path));
    }

    /**
     * Добавляет файлы в архив
     * @param absolutePathList - список абсолютных путей добавляемых файлов
     */
    public void addFiles(List<Path> absolutePathList) throws Exception{
        // Проверяем существует ли zip файл
        if (!Files.isRegularFile(zipFile)) { throw new WrongZipFileException(); }
        // Создаем временный файл
        Path tempFile = Files.createTempFile(null, null);

        List<Path> archivedFiles = new ArrayList<>();
        // Проходимся по всем файлам оригинального архива
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(tempFile))) {
            try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile))) {
                ZipEntry zipEntry = null;
                while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                    // Архивный файл из zipEntry
                    Path archivedFile = Paths.get(zipEntry.getName());
                    archivedFiles.add(archivedFile);
                    String fileName = zipEntry.getName();
                    zipOutputStream.putNextEntry(new ZipEntry(fileName));
                    copyData(zipInputStream, zipOutputStream);
                    zipOutputStream.closeEntry();
                    zipInputStream.closeEntry();
                }
            }

            for (Path p : absolutePathList){
                if (!Files.exists(p) || !Files.isRegularFile(p)) {
                    throw new PathIsNotFoundException();
                }
                else if (archivedFiles.contains(p)){
                    ConsoleHelper.writeMessage("Файл уже есть в архиве.");
                }
                else {
                    addNewZipEntry(zipOutputStream, p.getParent(), p.getFileName());
                    ConsoleHelper.writeMessage("Файл " + p.getFileName() + " добавлен в архив.");
                }
            }
        } catch (IOException ioE) { ioE.printStackTrace(); }
        Files.move(tempFile, zipFile, StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * Вызывает метод {@link ZipFileManager#addFiles} создавая список из одного элемента
     * @param absolutePath - добавляемый файл
     */
    public void addFile(Path absolutePath) throws Exception {
        addFiles(Collections.singletonList((Path) absolutePath));
    }

    /**
     * Возвращает список файлов в ахриве,
     *         вернее список свойств этих файлов
     */
    public List<FileProperties> getFilesList() throws Exception {
        if (Files.isDirectory(zipFile)) throw new WrongZipFileException();
        List<FileProperties> list = new ArrayList<>();
        try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile))){
            ZipEntry zipEntry = null;
            while ((zipEntry = zipInputStream.getNextEntry()) != null){
                ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                copyData(zipInputStream, buffer);
                list.add(new FileProperties(zipEntry.getName(), zipEntry.getSize(),
                        zipEntry.getCompressedSize(), zipEntry.getMethod()));
            }
        } catch (IOException ioE){
            ioE.printStackTrace();
        }
        return list;
    }
}
