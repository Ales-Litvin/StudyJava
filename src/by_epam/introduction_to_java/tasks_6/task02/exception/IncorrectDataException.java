package by_epam.introduction_to_java.tasks_6.task02.exception;

/**
 * The class {@code Exception} describe situation when input
 * incorrect data.
 */
public class IncorrectDataException extends Exception{

    private final String data;

    public String getData() { return data; }

    public IncorrectDataException(String message, String data) {
        super(message);
        this.data = data;
    }
}
