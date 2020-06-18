package javarush.task.task31.task3110.command;

import javarush.task.task31.task3110.ConsoleHelper;

/**
 * Класс менеджера архива который выводит сообщение "До встречи"
 * @autor Aleksandr
 * @version 0.1
 */
public class ExitCommand implements Command {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("До встречи");
    }
}
