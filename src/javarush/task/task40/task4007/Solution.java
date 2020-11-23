package javarush.task.task40.task4007;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/*
Работа с датами
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
        Calendar calendar = Calendar.getInstance();

        DateFormat dateFormat;
        String result = null;
        try {

            if (date.contains(":") && date.contains(".")) {
                dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                calendar.setTime(dateFormat.parse(date));
                result = getDate(calendar) + "\n" + getTime(calendar);
            } else if (date.contains(":")) {
                dateFormat = new SimpleDateFormat("HH:mm:ss");
                calendar.setTime(dateFormat.parse(date));
                result = getTime(calendar);
            } else if (date.contains(".")) {
                dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                calendar.setTime(dateFormat.parse(date));
                result = getDate(calendar);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(result);
    }

    public static String getDate(Calendar calendar){
        StringBuffer sb = new StringBuffer();
        sb.append("День: ").append(calendar.get(Calendar.DAY_OF_MONTH)).append("\n");

        DateFormat dateFormat = new SimpleDateFormat("E");
        int dayOfWeekEuro = calendar.get(Calendar.DAY_OF_WEEK) == 1 ? 7 : calendar.get(Calendar.DAY_OF_WEEK) - 1;

        sb.append("День недели: ").append(String.valueOf(dayOfWeekEuro)).append("\n");
        sb.append("День месяца: ").append(calendar.get(Calendar.DAY_OF_MONTH)).append("\n");
        sb.append("День года: ").append(calendar.get(Calendar.DAY_OF_YEAR)).append("\n");
        sb.append("Неделя месяца: ").append(calendar.get(Calendar.WEEK_OF_MONTH)).append("\n");
        sb.append("Неделя года: ").append(calendar.get(Calendar.WEEK_OF_YEAR)).append("\n");
        sb.append("Месяц: ").append(calendar.get(Calendar.MONTH) + 1).append("\n");
        sb.append("Год: ").append(calendar.get(Calendar.YEAR));

        return sb.toString();
    }

    public static String getTime(Calendar calendar){
        StringBuilder sb = new StringBuilder();

        DateFormat dateFormat = new SimpleDateFormat("a");

        sb.append("AM или PM: ").append(dateFormat.format(calendar.getTime())).append("\n");
        sb.append("Часы: ").append(calendar.get(Calendar.HOUR)).append("\n");
        sb.append("Часы дня: ").append(calendar.get(Calendar.HOUR_OF_DAY)).append("\n");
        sb.append("Минуты: ").append(calendar.get(Calendar.MINUTE)).append("\n");
        sb.append("Секунды: ").append(calendar.get(Calendar.SECOND));

        return sb.toString();
    }
}