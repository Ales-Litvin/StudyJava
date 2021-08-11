package javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        //напишите тут ваш код
        int size = 0;
        for (Map.Entry<K, List<V>> pair : map.entrySet()){
            size += pair.getValue().size();
        }
        return size;
    }

    @Override
    public V put(K key, V value) {
        //напишите тут ваш код
        if (map.containsKey(key) && map.get(key).size() < repeatCount){
            List<V> list = map.get(key);
            list.add(value);
            return map.get(key).get(list.size() - 1);
        } else if (map.containsKey(key) && map.get(key).size() == repeatCount) {
            List<V> list = map.get(key);
            list.remove(0);
            list.add(value);
            return list.get(list.size() - 1);
        } else {
            List<V> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
            return null;
        }
    }

    @Override
    public V remove(Object key) {
        //напишите тут ваш код
        if (!map.containsKey(key)){
            return null;
        }
        List<V> values = map.get(key);
        Object o = values.get(0);
        values.remove(o);
        if (values.size() == 0){
            map.remove(key);
        } else {
            map.put((K) key, values);
        }
        return (V) o;
    }

    @Override
    public Set<K> keySet() {
        //напишите тут ваш код
        Set<K> set = new HashSet<>(map.keySet());
        return set;
    }

    @Override
    public Collection<V> values() {
        //напишите тут ваш код
        Collection<V> collection = new ArrayList<>();
        for (Map.Entry<K, List<V>> pair : map.entrySet()){
            collection.addAll(pair.getValue());
        }
        return collection;
    }

    @Override
    public boolean containsKey(Object key) {
        //напишите тут ваш код
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код
        ArrayList<V> ls = new ArrayList<>();
        for (Map.Entry<K, List<V>> pair : map.entrySet()){
            for (V v : pair.getValue()){
                ls.add(v);
            }
        }
        return ls.contains(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}