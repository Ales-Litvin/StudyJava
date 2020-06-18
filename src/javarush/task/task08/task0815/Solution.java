package javarush.task.task08.task0815;

import java.io.*;
import java.util.*;

/*
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<>();
        map.put("Павлик", "Константин");
        map.put("Будько", "Алексей");
        map.put("Равлушко", "Андерей");
        map.put("Маскевич", "Валерак");
        map.put("Капырин", "Лев");
        map.put("Бухдик", "Евгений");
        map.put("Бовтач", "Евгений");
        map.put("Сак", "Павел");
        map.put("Чэлес", "Алексей");
        map.put("Кухта", "Андрей");

        return map;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        //напишите тут ваш код  /совпадает ИМЯ
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        int i = 0;
        while (iterator.hasNext()){
            Map.Entry<String, String> pair = iterator.next();
            String firstName = pair.getKey();
            if (firstName.equals(name)) { i++; }
        }
        return i;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        //напишите тут ваш код /совпадает ФАМИЛИЯ
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        int i = 0;
        while (iterator.hasNext()){
            Map.Entry<String, String> pair = iterator.next();
            String firstName = pair.getKey();
            if (firstName.equals(lastName)) { i++; }
        }
        return i;
    }

    public static void main(String[] args) {

    }
}