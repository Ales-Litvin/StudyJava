package javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        /*
        SimpleDateFormat используетя для форматирования даты
         */
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Будько", dateFormat.parse("January 25 1996"));
        map.put("Равлушко", dateFormat.parse("March 3 1995"));
        map.put("Маскевич", dateFormat.parse("April 15 1994"));
        map.put("Капырин", dateFormat.parse("June 16 1993"));
        map.put("Бухтик", dateFormat.parse("July 25 1996"));
        map.put("Бовтач", dateFormat.parse("August 11 1998"));
        map.put("Сак", dateFormat.parse("September 12 1999"));
        map.put("Кухта", dateFormat.parse("October 4 2000"));
        map.put("Чэлес", dateFormat.parse("November 1 1996"));

        //напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) throws ParseException {
        //напишите тут ваш код
        DateFormat dateFormat2 = new SimpleDateFormat("MMMMM", Locale.ENGLISH);
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Date> pair : map.entrySet()) {
            int month = pair.getValue().getMonth();
            if (month > 4 && month < 8) {
                list.add(pair.getKey());
            }
        }
        for (String name : list) {
            System.out.println(name);
            removeItemFromMapByValue(map, name);
        }
    }

    public static void removeItemFromMapByValue(Map<String, Date> map, String value) {
        Map<String, Date> copy = new HashMap<>(map);
        for (Map.Entry<String, Date> pair : copy.entrySet()) {
            if (pair.getKey().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) throws ParseException {
       /* Map<String, Date> map = createMap();
        removeAllSummerPeople(map);
        for (Map.Entry<String, Date> pair : map.entrySet()) {
            String key = pair.getKey();
            Date date = pair.getValue();
            System.out.println(key + " - " + date);
       */
        }
}