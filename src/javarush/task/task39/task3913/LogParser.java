package javarush.task.task39.task3913;

import javarush.task.task39.task3913.query.IPQuery;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LogParser implements IPQuery{

    /**
     * Path to directory with log files
     */
    private final Path logDir;

    public final ArrayList<LogEntry> logEntries;

    public LogParser(Path logDir) {
        this.logDir = logDir;
        this.logEntries = new ArrayList<>();
        parsLogInList();
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> ips = new HashSet<>();
        for (LogEntry entry : logEntries){
            if (isBetweenDates(entry, after, before))
                ips.add(entry.ip);
        }
        return ips;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> ips = new HashSet<>();
        for (LogEntry entry : logEntries){
            if (entry.user.equals(user) && isBetweenDates(entry, after, before))
                ips.add(entry.ip);
        }
        return ips;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> ips = new HashSet<>();
        for (LogEntry entry : logEntries){
            if (entry.event.equals(event) && isBetweenDates(entry, after, before))
                ips.add(entry.ip);
        }
        return ips;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> ips = new HashSet<>();
        for (LogEntry entry : logEntries){
            if (entry.status.equals(status) && isBetweenDates(entry, after, before))
                ips.add(entry.ip);
        }
        return ips;
    }

    private boolean isBetweenDates(LogEntry entry, Date after, Date before){
        if (after == null & before == null) {
            return true;
        } else if (after == null){
            return entry.date.before(before);
        } else if (before == null){
            return entry.date.after(after);
        } else {
            return entry.date.after(after) & entry.date.before(before);
        }
    }

    /**
     * Get all path files in the logDir
     * @return - paths of files with log
     */
    private List<Path> getPathInDirectory(){
        List<Path> logs = new ArrayList<>();
        try{
            logs = Files.list(logDir)
                    .filter(Files::isRegularFile)
                    .filter(line -> line.toString().endsWith(".log"))
                    .collect(Collectors.toList());
        } catch (IOException e){
            e.printStackTrace();
        }

        return logs;
    }

    private void parsLogInList(){
        for (Path path : getPathInDirectory()){
            try (BufferedReader br = new BufferedReader(Files.newBufferedReader(path))){
                String data;
                while ((data = br.readLine()) != null){
                    logEntries.add(LogEntry.getLogEntry(data));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class LogEntry {
        String ip;
        String user;
        Date date; //day.month.year hour:minute:second
        Event event;
        Integer numberTask; // may be "null"
        Status status;

        public LogEntry(String ip, String user, Date date, Event event, Integer numberTask, Status status) {
            this.ip = ip;
            this.user = user;
            this.date = date;
            this.event = event;
            this.numberTask = numberTask;
            this.status = status;
        }

        /**
         * Regular expression for strings formatted "ip username date event status"
         */
        private static final Pattern pattern = Pattern.compile("(?<ip>[\\d]+.[\\d]+.[\\d]+.[\\d]+)\\s" +
                "(?<name>[a-zA-Z ]+)\\s" +
                "(?<date>[\\d]+.[\\d]+.[\\d]+ [\\d]+:[\\d]+:[\\d]+)\\s" +
                "(?<event>[\\w]+)\\s?(" +
                "(?<taskNumber>[\\d]+)|)\\s" +
                "(?<status>[\\w]+)");

        private static  final SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        /**
         * Does parsing strings for LogEntry
         * ip username date event status
         * Require work
         * @return - {@link LogEntry} of String
         * @param string - {@link String} for parsing
         * Later do this method private
         * That is shame
         */
        public static LogEntry getLogEntry(String string){
            Matcher matcher = pattern.matcher(string); // Type of "log" this "String"
            matcher.find();

            String ip = matcher.group("ip");
            String user = matcher.group("name");

            Date date;
            try {
                date = simpleDateFormat.parse(matcher.group("date"));
            } catch (ParseException e) {
                e.printStackTrace();
                date = null;
            }

            Event event = Event.valueOf(matcher.group("event"));

            Integer numberTask = null;

            if (event.equals(Event.SOLVE_TASK) || event.equals(Event.DONE_TASK)){
                numberTask = Integer.parseInt(matcher.group("taskNumber"));
            }

            Status status = Status.valueOf(matcher.group("status"));

            return new LogEntry(ip, user, date, event, numberTask, status);
        }

        /**
         * Just method toString
         * @return   {@link String} in format "ip username date event status"
         */
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("");
            sb.append(ip);
            sb.append(" ").append(user);
            sb.append(" ").append(String.format("%1$td.%1$tm.%1$tY %1$tT", date));
            sb.append(" ").append(event);
            if ((event.equals(Event.DONE_TASK) || event.equals(Event.SOLVE_TASK)) && numberTask != null)
                sb.append(" ").append(numberTask);
            sb.append(" ").append(status);
            return sb.toString();
        }
    }
}