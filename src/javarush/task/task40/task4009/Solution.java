package javarush.task.task40.task4009;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

/*
Buon Compleanno!
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getWeekdayOfBirthday("30.05.1984", "2015"));
    }

    public static String getWeekdayOfBirthday(String birthday, String year) {
        //напишите тут ваш код
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d.M.y", Locale.ITALIAN);

        LocalDate birthdayDate = LocalDate.parse(birthday, dateFormatter);

        Year year1 = Year.parse(year);

        LocalDate birthdayToYear = birthdayDate.withYear(year1.getValue());

        return birthdayToYear.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ITALIAN);
    }
}