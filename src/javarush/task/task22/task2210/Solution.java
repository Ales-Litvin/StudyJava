package javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
/*
 * Используя StringTokenizer разделить query на части по разделителю delimiter.
 *
 *         Пример
 *         getTokens("level22.lesson13.task01", ".")
 *         возвращает массив строк
 *         {"level22", "lesson13", "task01"}
 *
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(getTokens("level22.lesson13.task01", ".").toString());
    }

    public static String[] getTokens(String query, String delimiter) {
        List<String> list = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);

        while (stringTokenizer.hasMoreTokens()){
            list.add(stringTokenizer.nextToken());
        }
        String[] result = new String[list.size()];
        result = list.toArray(result);
        return result;
    }
}