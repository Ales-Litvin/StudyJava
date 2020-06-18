package javarush.task.task31.task3110.command;

import javarush.task.task30.task3008.ConsoleHelper;
import javarush.task.task31.task3110.ZipFileManager;
import javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.nio.file.Paths;

/**
 * Команда создания архива (упаковки файлов в архив)
 * @autor Aleksandr
 * @version 0.1
 */
public class ZipCreateCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Создание архива");
            ZipFileManager zipFileManager = getZipFileManager();
            ConsoleHelper.writeMessage("Введите полное имя файла или директории для архивации");
            zipFileManager.createZip(Paths.get(ConsoleHelper.readString()));
            ConsoleHelper.writeMessage("Архив создан");
        } catch (PathIsNotFoundException e){
            ConsoleHelper.writeMessage("Вы неверно указади имя файла или директории.");
        }
    }
}