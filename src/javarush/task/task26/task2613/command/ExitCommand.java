package javarush.task.task26.task2613.command;

import javarush.task.task26.task2613.ConsoleHelper;
import javarush.task.task26.task2613.exception.InterruptOperationException;

class ExitCommand  implements Command {

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage("You real want to exit yes-'y' or no-'n'");
        if (ConsoleHelper.readString().equalsIgnoreCase("y")){
            ConsoleHelper.writeMessage("Bye!");
        }
    }
}
