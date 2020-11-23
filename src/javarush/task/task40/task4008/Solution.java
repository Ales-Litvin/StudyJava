package javarush.task.task40.task4008;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/*
Работа с Java 8 DateTime API
*/

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        //напишите тут ваш код
        date = date.trim();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d.M.y");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:m:s");

        String result = null;
        if (date.contains(".") && date.contains(":")) {
            String[] data = date.split(" ");

            LocalDate localDate = LocalDate.parse(data[0], dateFormatter);
            LocalTime localTime = LocalTime.parse(data[1], timeFormatter);

            result = getDate(localDate) + "\n" + getTime(localTime);
        } else if (date.contains(":")) {
            LocalTime localTime = LocalTime.parse(date, timeFormatter);

            result = getTime(localTime);


        } else if (date.contains(".")) {
            LocalDate localDate = LocalDate.parse(date, dateFormatter);

            result = getDate(localDate);
        }

        System.out.println(result);


    }

    public static String getDate(LocalDate date){
        StringBuffer sb = new StringBuffer();
        sb.append("День: ").append(date.getDayOfMonth()).append("\n");

        sb.append("День недели: ").append(date.getDayOfWeek().getValue()).append("\n");
        sb.append("День месяца: ").append(date.getDayOfMonth()).append("\n");
        sb.append("День года: ").append(date.getDayOfYear()).append("\n");

        sb.append("Неделя месяца: ").append(date.getDayOfMonth() / 7 + 1).append("\n");
        sb.append("Неделя года: ").append((date.getDayOfYear() + 1) / 7 + 1).append("\n");
        sb.append("Месяц: ").append(date.getMonthValue()).append("\n");
        sb.append("Год: ").append(date.getYear());

        return sb.toString();
    }

    public static String getTime(LocalTime time){
        StringBuilder sb = new StringBuilder();

        DateFormat dateFormat = new SimpleDateFormat("a");

        sb.append("AM или PM: ").append(time.getHour() < 12 ? "AM" : "PM").append("\n");
        sb.append("Часы: ").append(time.getHour() % 12).append("\n");
        sb.append("Часы дня: ").append(time.getHour()).append("\n");
        sb.append("Минуты: ").append(time.getMinute()).append("\n");
        sb.append("Секунды: ").append(time.getSecond());

        return sb.toString();
    }
}
