package javarush.task.task10.task1016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Одинаковые слова в списке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            words.add(reader.readLine());
        }

        Map<String, Integer> map = countWords(words);

        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static Map<String, Integer> countWords(ArrayList<String> list) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        //напишите тут ваш код
        for (int i = 0; i < list.size(); i++){
            result.put(list.get(i), 0);
        }

        for (Map.Entry<String, Integer> pair : result.entrySet()) {
            String key = pair.getKey();
            int value = pair.getValue();
            for (String strings : list) {
                if (strings.equals(key)){
                    value = pair.getValue() + 1;
                    result.put(pair.getKey(), value);
                }
            }
        }
        return result;
    }

}

/*
Машина
Перерыв
Скакун
Телефон
Игра
пророк
Яблоко
платок
дерево
уксус
уксус
Игра
пророк
Яблоко
пророк
Яблоко
Яблоко
шишка
шайба
пикник
пикник
 */