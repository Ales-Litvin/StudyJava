package javarush.task.task19.task1920;
/*
Самый богатый
 */

/*
G:\Test5.txt
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, Double> map = new TreeMap<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));

        String data;
        while ((data = bufferedReader.readLine()) != null){
            String[] arrayData = data.split(" ");
            if (map.containsKey(arrayData[0])){
                map.put(arrayData[0],
                        map.get(arrayData[0]) + Double.parseDouble(arrayData[1]));
            }
            else {
                map.put(arrayData[0],Double.parseDouble(arrayData[1]));
            }
        }
        bufferedReader.close();

        double max = 0;
        for (Map.Entry<String, Double> pair: map.entrySet()){
            double value = pair.getValue();
            if(value >= max){
                max = value;
            }
        }

        for (Map.Entry<String, Double> pair: map.entrySet()){
            String key = pair.getKey();
            double value = pair.getValue();
            if(value == max){
                System.out.printf("%s\n", pair.getKey());
            }
        }
    }
}