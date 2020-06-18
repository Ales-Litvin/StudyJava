package javarush.task.task31.task3110.command;

import javarush.task.task31.task3110.ConsoleHelper;
import javarush.task.task31.task3110.ZipFileManager;
import javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.nio.file.Paths;

/**
 * Команда удаления файла из архива
 * @autor Aleksandr
 * @version 0.1
 */
public class ZipRemoveCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Удаление файла из архива");
            ZipFileManager zipFileManager = getZipFileManager();
            ConsoleHelper.writeMessage("Введите имя файла для удаления");
            zipFileManager.removeFile(Paths.get(ConsoleHelper.readString()));
        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Вы неверно указади имя файла или директории.");
        }
    }
}