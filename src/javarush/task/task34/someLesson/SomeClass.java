package javarush.task.task34.someLesson;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class SomeClass {

    private static Logger log = Logger.getLogger(SomeClass.class.getName());

    public void someMethod() {
        log.info("Some message");
    }

    public static void main(String[] args) {
        try {
            LogManager.getLogManager().readConfiguration(
                    SomeClass.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
    }
}