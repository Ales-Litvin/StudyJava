package cuncurent.ru.java.online.cuncurent.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap<K, V> реализует (implements) интерфейс
 * java.util.concurrent.ConcurrentMap и отличается от HashMap и Hashtable
 * внутренней структурой хранения пар key-value. СoncurrentHashMap использует
 * несколько сегментов, и данный класс можно рассматривать как группу HashMap’ов.
 * По умолчанию количество сегментов равно 16. Доступ к данным определяется по
 * сегментам, а не по объекту. Итераторы данного класса фиксируют структуру
 * данных на момент начала его использования.
 */
public class ConcurrentHashMapExample {
    Map<String, String> map;

    public ConcurrentHashMapExample() {
        System.out.println("ConcurrentHashMap");
        createMap(true);
        addValue(true);

        System.out.println("\n\nHashMap");
        createMap(false);
        addValue(false);
    }

    public static void main(String[] args) {
        new ConcurrentHashMapExample();
        System.exit(0);
    }

    private void addValue(boolean concurrent) {
        System.out.println("  before iterator : " + map);
        Iterator<String> it = map.keySet().iterator();

        System.out.print("  cycle : ");
        while (it.hasNext()) {
            String key = it.next();
            if (key.equals("2")) {
                map.put(key + "new", "222");
            } else
                System.out.print("  " + key + "="
                        + map.get(key));
        }
        System.out.println();
        System.out.println("  after iterator : " + map);
    }

    private void createMap(boolean concurrent) {
        if (concurrent)
            map = new ConcurrentHashMap<>();
        else
            map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "1");
        map.put("3", "1");
        map.put("4", "1");
        map.put("5", "1");
        map.put("6", "1");
    }
}
