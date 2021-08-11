package javarush.task.task31.task3110.command;

import javarush.task.task31.task3110.ConsoleHelper;
import javarush.task.task31.task3110.FileProperties;
import javarush.task.task31.task3110.ZipFileManager;

/**
 * Команда просмотра содержимого архива
 * @autor Aleksandr
 * @version 0.1
 */
public class ZipContentCommand extends ZipCommand{
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Просмотр содержимого архива.");
        ZipFileManager zipFileManager = getZipFileManager();
        ConsoleHelper.writeMessage("Содержимое архива:");
        for (FileProperties fileProperties : zipFileManager.getFilesList()){
            ConsoleHelper.writeMessage(fileProperties.toString());
        }
        ConsoleHelper.writeMessage("Содержимое архива прочитано.");
    }
}