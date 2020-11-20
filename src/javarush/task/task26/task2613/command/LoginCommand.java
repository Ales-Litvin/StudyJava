package javarush.task.task26.task2613.command;

import javarush.task.task26.task2613.ConsoleHelper;
import javarush.task.task26.task2613.exception.InterruptOperationException;

class LoginCommand implements Command{

    private final long numberCard = 123456789012L;

    private final int pinCode = 1234;

    @Override
    public void execute() throws InterruptOperationException {

        while (true){
            ConsoleHelper.writeMessage("Write credit card's number");
            String number = ConsoleHelper.readString();
            ConsoleHelper.writeMessage("Write pin-code");
            String pin = ConsoleHelper.readString();

            if (!number.matches("\\d{12}") || !pin.matches("\\d{4}")) {
                ConsoleHelper.writeMessage("Wrong credit card's number or pin");
                continue;
            }

            if (Long.parseLong(number) != numberCard ||
                    Integer.parseInt(pin) != pinCode){
                ConsoleHelper.writeMessage("Wrong data, try again");
                continue;
            }

            ConsoleHelper.writeMessage("Logging in");
            break;
        }
    }
}
