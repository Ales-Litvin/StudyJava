package javarush.task.task34.demoLog;

import org.apache.log4j.Logger;

public class DemoLog {
    static Logger logger = Logger.getLogger(DemoLog.class);

    public static void main(String[] args) {
        try {
        //возможна и программная настройка
            factorial(9);
            factorial(-3);
        } catch (IllegalArgumentException e) {
            //вывод сообщения уровня ERROR
            logger.error("negative argument", e);
        }
    }

    public static int factorial(int n) {
        if (n < 0)
            throw new IllegalArgumentException(
                    "argument " + n +" less then zero");
        //вывод сообщения уровня DEBUG
        logger.debug("Argument n is " + n);
        int result = 1;
        for (int i = n; i >= 1; i--)
            result *= i;
        //вывод сообщения уровня INFO
        logger.info("Result is " + result);
        return result;
    }
}