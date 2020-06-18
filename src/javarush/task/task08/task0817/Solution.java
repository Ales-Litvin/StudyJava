package javarush.task.task08.task0817;

import java.util.*;

/*
Нам повторы не нужны
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
        map.put("Кухта", "Алексей");
        map.put("Чэлес", "Андрей");

        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код   удалять Вещь из Карты по значению
        //этот метод должен передавать повторяющиеся строки
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (Collections.frequency(map.values(), pair.getValue()) > 1) {
                list.add(pair.getValue());
            }
        }
        for (String name : list) {
            removeItemFromMapByValue(map, name);
        }
    }

    /*
    Метод ниже - удалять Вещь из Карты по значению
    удаляет переданную строку String value
    выполняет перебор Map и сравневает их значение с переданным, при совпадении удаляет их по ключу
     */

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {

    }
}