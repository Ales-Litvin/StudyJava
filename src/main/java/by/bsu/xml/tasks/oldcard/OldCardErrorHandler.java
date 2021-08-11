package by.bsu.xml.tasks.oldcard;

import jdk.internal.org.xml.sax.SAXParseException;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;


public class OldCardErrorHandler extends DefaultHandler {
    // создание регистратора ошибок для пакета by.bsu.valid
    private static String packageName = OldCardErrorHandler.class.getPackage().toString();

    private Logger logger = Logger.getLogger(packageName);

    public OldCardErrorHandler(String log) throws IOException {
        // установка файла и формата вывода ошибок
        logger.addAppender(new FileAppender(new SimpleLayout(), log));
    }

    public void warning(SAXParseException e) {
        logger.warn(getLineAddress(e) + "-" + e.getMessage());
    }

    public void error(SAXParseException e) {
        logger.error(getLineAddress(e) + " - " + e.getMessage());
    }

    public void fatalError(SAXParseException e) {
        logger.fatal(getLineAddress(e) + " - " + e.getMessage());
    }

    private String getLineAddress(SAXParseException e) {
        // определение строки и столбца ошибки
        return e.getLineNumber() + " : " + e.getColumnNumber();
    }
}