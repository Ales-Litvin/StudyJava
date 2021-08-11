package javarush.task.task31.task3110;

import javarush.task.task31.task3110.command.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс реализует pattern Command
 * Хранит сыллки на объекты Command в Map<Operation, Command>
 *     и вызывает нужную команду
 * @autor Aleksandr
 * @version 0.1
 */
public class CommandExecutor {
    private static final Map<Operation, Command> allKnownCommandsMap = new HashMap<>();
    static {
        allKnownCommandsMap.put(Operation.CREATE, new ZipCreateCommand());
        allKnownCommandsMap.put(Operation.ADD, new ZipAddCommand());
        allKnownCommandsMap.put(Operation.REMOVE, new ZipRemoveCommand());
        allKnownCommandsMap.put(Operation.EXTRACT, new ZipExtractCommand());
        allKnownCommandsMap.put(Operation.CONTENT, new ZipContentCommand());
        allKnownCommandsMap.put(Operation.EXIT, new ExitCommand());
    }

    private CommandExecutor(){
    }

    /**
     * Находит нужную команду и вызывает у нее метод execute
     * @param operation - переменая enum Operation
     */
    public static void execute(Operation operation) throws Exception{
        allKnownCommandsMap.get(operation).execute();
    }
}
