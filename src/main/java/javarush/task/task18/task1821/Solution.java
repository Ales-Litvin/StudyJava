package javarush.task.task18.task1821;

/*
Встречаемость символов
 */

/*
G:\Test.txt
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);

        Map<Character, Integer> map = new TreeMap<>();
        // первый параметр уникальный ключ код в формате ASCII
        // TreeMap сортируется по возрастанию

        while (inputStream.available() > 0) {
            int i = inputStream.read();
                if (!map.containsKey((char) i)) {
                    map.put((char) i, 1);
                } else {
                    map.put((char) i, map.get((char) i) + 1);
                }
        }
        inputStream.close();

        for (Map.Entry<Character, Integer> pair : map.entrySet()){
            char key = pair.getKey();
            int value = pair.getValue();
            System.out.printf("%c %d\n", key, value);
        }
    }
}
