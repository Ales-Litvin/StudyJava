package javarush.task.task31.task3110.command;

import javarush.task.task31.task3110.ConsoleHelper;
import javarush.task.task31.task3110.ZipFileManager;
import javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.nio.file.Paths;

/**
 * Команда распоковки архива
 * @autor Aleksandr
 * @version 0.1
 */
public class ZipExtractCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Распоковывание архива");
            ZipFileManager zipFileManager = getZipFileManager();
            ConsoleHelper.writeMessage("Введите полное имя директории для разархивации");
            zipFileManager.extractAll(Paths.get(ConsoleHelper.readString()));
            ConsoleHelper.writeMessage("Архив разархивирован");
        } catch (PathIsNotFoundException e) {
        ConsoleHelper.writeMessage("Вы неверно указади имя файла или директории.");
        }
    }
}