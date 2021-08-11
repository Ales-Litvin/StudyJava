package javarush.task.task38.task3804;

public class ExceptionFactory {

    public static Throwable createException(Enum e){
        if (e == null) {
            return new IllegalArgumentException();
        }

        String message = e.name();
        message = message.replace('_', ' ').toLowerCase();
        message = String.valueOf(message.toCharArray()[0]).toUpperCase() +
                message.substring(1, message.length());

        if (e instanceof ApplicationExceptionMessage){
            return new Exception(message);
        } else if (e instanceof DatabaseExceptionMessage){
            return new RuntimeException(message);
        } else if (e instanceof UserExceptionMessage){
            return new Error(message);
        } else {
            return new IllegalArgumentException();
        }
    }
}