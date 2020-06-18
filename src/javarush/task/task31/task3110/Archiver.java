package javarush.task.task31.task3110;

import javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.IOException;

/**
 * Главный класс приложения "Архиватор"
 * @autor Aleksandr
 * @version 0.1
 *
 * Файл для удаления
 * G:\Programming\Work\Study\src\javarush\task\task31\task3110\TestFile\zipFile.zip\source.txt
 * G:\Programming\Work\Study\src\javarush\task\task31\task3110\TestFile\source
 * G:\Programming\Work\Study\src\javarush\task\task31\task3110\TestFile\zipFile.zip
 */
public class Archiver {
    public static void main(String[] args){
        Operation operation = null;
        do {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException e) {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception ex) {
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }
        } while (operation!= Operation.EXIT);
    }

    public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("Выберите операцию:");
        ConsoleHelper.writeMessage(Operation.CREATE.ordinal() + " - упаковать файлы в архив");
        ConsoleHelper.writeMessage(Operation.ADD.ordinal() + " - добавить файл в архив");
        ConsoleHelper.writeMessage(Operation.REMOVE.ordinal() + " - удалить файл из архива");
        ConsoleHelper.writeMessage(Operation.EXTRACT.ordinal() + " - распаковать архив");
        ConsoleHelper.writeMessage(Operation.CONTENT.ordinal() + " - просмотреть содержимое архива");
        ConsoleHelper.writeMessage(Operation.EXIT.ordinal() + " - выход");
        return Operation.values()[ConsoleHelper.readInt()];
    }
}