package javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/*
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleMap();
        printPeopleMap(map);
    }

    public static Map<String, String> createPeopleMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<>();
        map.put("Павлик", "Константин");
        map.put("Будько", "Алексей");
        map.put("Равлушко", "Андерей");
        map.put("Маскевич", "Валерак");
        map.put("Будько", "Лев");
        map.put("Бухдик", "Евгений");
        map.put("Бовтач", "Евгений");
        map.put("Сак", "Павел");
        map.put("Чэлес", "Алексей");
        map.put("Кухта", "Андрей");

        return map;
    }

    public static void printPeopleMap(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}