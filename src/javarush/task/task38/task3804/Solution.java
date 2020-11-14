package javarush.task.task38.task3804;

public class Solution {
    public static Class getFactoryClass() {
        return ExceptionFactory.class;
    }

    public static void main(String[] args) {
        Throwable t = ExceptionFactory.createException(
                ApplicationExceptionMessage.SOCKET_IS_CLOSED);
        System.out.println(t.getMessage());
    }
}
