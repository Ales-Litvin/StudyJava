package javarush.task.task31.task3110.command;

import javarush.task.task31.task3110.ConsoleHelper;
import javarush.task.task31.task3110.ZipFileManager;

import java.nio.file.Paths;

/**
 * Абстрактный класс для калссов которые непосредственно работают с архивом
 * @autor Aleksandr
 * @version 0.1
 */
public abstract class ZipCommand implements Command {
    public ZipFileManager getZipFileManager() throws Exception{
        ConsoleHelper.writeMessage("Введите плоный путь файла архива");
        return new ZipFileManager(Paths.get(ConsoleHelper.readString()));
    }
}
