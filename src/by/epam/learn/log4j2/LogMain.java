package by.epam.learn.log4j2;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogMain {
    static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.error("first");
        logger.log(Level.ERROR, "second");
        logger.info("info");
    }
}
