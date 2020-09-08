package javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Date;

public class Test {
    private static final LogParser logParser = new LogParser(Paths.get("G:\\Programming\\Work\\StudyJava\\src\\javarush\\task\\task39\\task3913\\testFile"));

    public static void main(String[] args) {
        /*
        LogParser.LogEntry entry = logParser.getLogEntry("146.34.15.5 Eduard Petrovich Morozko 06.09.2020 13:46:41 DONE_TASK 48 FAILED");
        System.out.println(entry.toString());
         */

        for (LogParser.LogEntry entry : logParser.list){
            System.out.println(entry.toString());
        }

        System.out.println("==================");

        System.out.println(logParser.getIPsForStatus(Status.FAILED, null, null));

        System.out.println("==================");

        System.out.println(logParser.getIPsForUser("See Son You", null, new Date()));
    }
}