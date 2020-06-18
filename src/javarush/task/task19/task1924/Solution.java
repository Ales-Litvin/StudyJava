package javarush.task.task19.task1924;

import java.util.HashMap;
import java.util.Map;
import java.io.*;

/*
Замена чисел
*/

/*
G:\Programming\Work\Hlam\src\javarush\task\task19\task1924\test.txt
 */

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static{
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String filename = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(filename));

        String data;
        while ((data = fileReader.readLine()) != null){
            for (Map.Entry<Integer, String> pair: map.entrySet()){
                String regex = "\\b" + pair.getKey() + "\\b";
                // ОСТОЛОП \b означает граница слова дополнительная дробь это экранирование символв
                data = data.replaceAll(regex, pair.getValue());
            }
            System.out.println(data);
            }
        fileReader.close();
    }
}