package javarush.task.task18.task1803;

/*
Самые частые байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

// G:\Test.txt  G:\Test2.txt

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        reader.close();

        FileInputStream ioReader = new FileInputStream(string);

        Map<Integer, Integer> mapList = new TreeMap<>();

        int max = 1;
        while(ioReader.available() > 0){
            int byteReader = ioReader.read();

            if (mapList.containsKey(byteReader)){
                int s = mapList.get(byteReader) + 1;
                mapList.put(byteReader, s);
                if (max < s) {
                    max = s;
                }
            }
            else {
                mapList.put(byteReader, 1);
            }
        }

        for (Map.Entry<Integer, Integer> pair: mapList.entrySet()){
            int key = pair.getKey();
            int value = pair.getValue();
            if (value == max) {
                System.out.printf("%d ", key);
            }
        }
        ioReader.close();

    }
}