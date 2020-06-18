package javarush.task.task22.task2208;

/*
Формируем WHERE
*/

/*
 *Сформируй часть запроса WHERE используя StringBuilder.
 * Если значение null, то параметр не должен попадать в запрос.
 *
 * Пример:
 * {name=Ivanov, country=Ukraine, city=Kiev, age=null}
 *
 * Результат:
 * name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'
 */

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
        public static void main(String[] args) {
            Map<String, String> mapLinked = new LinkedHashMap<>();
            mapLinked.put("name", "Ivanov"); //"Ivanov"
            mapLinked.put("country", null); // "Ukraine"
            mapLinked.put("city", "Kiev"); // "Kiev"
            mapLinked.put("age", null); //
            System.out.println(getQuery(mapLinked));
        }

        public static String getQuery(Map<String, String> params) {
            StringBuilder result = new StringBuilder("");
            if (params == null) return null;
            for (Map.Entry<String, String> pair : params.entrySet()){
                String key = pair.getKey();
                String value = pair.getValue();

                if (value != null && key != null){
                    if (!value.isEmpty()){
                        if (result.length() == 0) {
                            result = result.append(String.format("%s = '%s'", key, value));
                        } else {
                            result = result.append(String.format(" and %s = '%s'", key, value));
                        }
                    }
                }
            }

            return result.toString();
        }
}