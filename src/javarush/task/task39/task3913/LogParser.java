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

public class LogParser implements IPQuery{

    /**
     * Path to directory with log files
     */
    private Path logDir;

    public Set<LogEntry> list;

    public LogParser(Path logDir) {
        this.logDir = logDir;
        list = new HashSet<>();
        parsLogInList();
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        Set<String> ips = new HashSet<>();
        for (LogEntry entry : list){
            if (isBetweenDates(entry, after, before))
                ips.add(entry.ip);
        }
        return ips.size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> ips = new HashSet<>();
        for (LogEntry entry : list){
                ips.add(entry.ip);
        }
        return ips;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> ips = new HashSet<>();
        for (LogEntry entry : list){
            if (entry.user.equals(user) && isBetweenDates(entry, after, before))
                ips.add(entry.ip);
        }
        return ips;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> ips = new HashSet<>();
        for (LogEntry entry : list){
            if (entry.event.equals(event) && isBetweenDates(entry, after, before))
                ips.add(entry.ip);
        }
        return ips;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> ips = new HashSet<>();
        for (LogEntry entry : list){
            if (entry.status.equals(status) && isBetweenDates(entry, after, before))
                ips.add(entry.ip);
        }
        return ips;
    }

    private boolean isBetweenDates(LogEntry entry, Date after, Date before){
        if (after == null && before == null) {
            return true;
        } else if (after == null){
            return entry.date.before(before);
        } else if (before == null){
            entry.date.after(after);
        } else {
            return entry.date.before(before) && entry.date.after(after);
        }
        return false;
    }

    /**
     * Get all path files in the logDir
     * @return - paths of files with log
     */
    private List<Path> getPathInDirectory(){
        List<Path> paths = new ArrayList<>();
        for (File file : logDir.toFile().listFiles()){
            if (file.isFile() && file.getName().endsWith(".log")){
                paths.add(file.toPath());
            }
        }
        return paths;
    }

    private void parsLogInList(){
        for (Path path : getPathInDirectory()){
            try (BufferedReader br = new BufferedReader(Files.newBufferedReader(path))){
                String data;
                while ((data = br.readLine()) != null){
                    list.add(getLogEntry(data));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Does parsing strings for LogEntry
     * ip username date event status
     * Require work
     * @return - {@link LogEntry} of String
     * @param string - {@link String} for parsing
     * Later do this method private
     * That is shame
     */
    public final LogEntry getLogEntry(String string){
        String ip = "";
        String user = "";
        Date date = null;
        Event event = null;
        Integer numberTask = null;
        Status status = null;

        ip = string.substring(0, string.indexOf(" "));
        status = Status.valueOf(string.substring(string.lastIndexOf(" ") + 1));

        string = string.substring(string.indexOf(" ") + 1, string.lastIndexOf(" "));

        String eventString = string.substring(string.lastIndexOf(" ") + 1);

        if (eventString.matches("\\d+")){
            numberTask = Integer.parseInt(eventString);
            string = string.substring(0, string.lastIndexOf(" "));
            eventString = string.substring(string.lastIndexOf(" ") + 1);
        }

        event = Event.valueOf(eventString);

        string = string.substring(0, string.lastIndexOf(" "));

        String[] strings = string.split(" ");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        try {
            date = simpleDateFormat.parse(strings[strings.length - 2] + " " + strings[strings.length - 1]);
        } catch (ParseException e) {
            e.printStackTrace();
            date = null;
        }

        user = strings[0];
        for (int i = 1; i < strings.length - 2; i++){
                user += " ";
                user += strings[i];
        }

        return new LogEntry(ip, user, date, event, numberTask, status);
    }


    public class LogEntry{
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

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("");
            sb.append(ip);
            sb.append(" ").append(user);
            sb.append(" ").append(String.format("%1$td.%1$tm.%1$tY %1$tT",date));
            sb.append(" ").append(event);
            if ((event.equals(Event.DONE_TASK) || event.equals(Event.SOLVE_TASK)) && numberTask != null)
                sb.append(" ").append(numberTask);
            sb.append(" ").append(status);
            return sb.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof LogEntry)) return false;
            LogEntry entry = (LogEntry) o;
            return Objects.equals(ip, entry.ip) &&
                    Objects.equals(user, entry.user) &&
                    Objects.equals(date, entry.date) &&
                    event == entry.event &&
                    numberTask.equals(entry.numberTask) &&
                    status == entry.status;
        }

        @Override
        public int hashCode() {
            return Objects.hash(ip, user, date, event, numberTask, status);
        }
    }
}