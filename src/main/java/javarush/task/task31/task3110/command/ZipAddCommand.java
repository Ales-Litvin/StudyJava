package javarush.task.task31.task3110.command;

import javarush.task.task31.task3110.ConsoleHelper;
import javarush.task.task31.task3110.ZipFileManager;
import javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.nio.file.Paths;

/**
 * Команда добавления файла в архив
 * @autor Aleksandr
 * @version 0.1
 */
public class ZipAddCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Добавление файла в архив");
            ZipFileManager zipFileManager = getZipFileManager();
            ConsoleHelper.writeMessage("Введите полное имя файла или директории");
            zipFileManager.addFile(Paths.get(ConsoleHelper.readString()));
        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Вы неверно указади имя файла или директории.");
        }
    }
}