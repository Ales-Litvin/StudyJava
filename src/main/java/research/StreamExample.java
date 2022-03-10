package research;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class StreamExample {

    private static final List<Long> NUMBERS;
    static {
        NUMBERS = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            NUMBERS.add((long) (Math.random() * 1000));
        }
    }

    public static void main(String[] args) {
        ConcurrentHashMap<String, Long> stringLongConcurrentHashMap = new ConcurrentHashMap<>();

        NUMBERS
                //.parallelStream()
                .stream()
                .filter(n -> n < 1000).forEach(n -> {
            String name = Thread.currentThread().getName();
            if (stringLongConcurrentHashMap.containsKey(name)) {
                Long amount = stringLongConcurrentHashMap.get(name) + 1;
                stringLongConcurrentHashMap.put(name, amount);
            } else {
                stringLongConcurrentHashMap.put(name, 0L);
            }
        });

        System.out.println("Count of thread: " + stringLongConcurrentHashMap.keySet().size());
    }
}
