package javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here
        V v = cache.get(key);
        if (v != null){
            return v;
        } else {
            Constructor<?> constructor = clazz.getConstructor(key.getClass());
            V instance = (V) constructor.newInstance(key);
            cache.put(key, instance);
        }
        return null;
    }

    public boolean put(V obj) {
        //TODO add your code here
        int size = size();
        try {
            Method method = obj.getClass().getDeclaredMethod("getKey");
            method.setAccessible(true);
            K key = (K) method.invoke(obj);
            cache.put(key, obj);
            return true;
        } catch (Exception e) {
            // do nothing
            return false;
        }
    }

    public int size() {
        return cache.size();
    }
}