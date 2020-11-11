package javarush.task.task22.task2207;

/*
Обращенные слова
*/

/*
 * В методе learn.main с консоли считать имя файла, который содержит слова, разделенные пробелами.
 * Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
 * Использовать StringBuilder.
 * Кодировка файла - UTF-8.
 *
 * Пример содержимого файла
 * рот тор торт о
 * о тот тот тот
 *
 * Вывод:
 * рот тор
 * о о
 * тот тот
 */

/*
G:\Programming\Work\Hlam\src\javarush\task\task22\task2207\test.txt
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution_rev2 {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader br = new BufferedReader(new FileReader(fileName));

        ArrayList<String> list = new ArrayList<String>();
        String data;
        while ((data = br.readLine()) != null){
            String[] array = data.split("\\s+");
            list.addAll(Arrays.asList(array));
        }
        br.close();

        System.out.println(list);

        /*
         * Создаю массив для перебора элементов в цикле for
         */
        String[] array = new String[list.size()];
        array = list.toArray(array);

        for (String str : array){
            String stringRevers = new String(new StringBuilder(str).reverse());

            if (list.contains(str)) {
                list.remove(str);
                if (list.contains(stringRevers)) {
                    Pair pair = new Pair();
                    pair.first = str;
                    pair.second = stringRevers;

                    if (result.indexOf(pair) < 0) result.add(pair);
                    list.remove(stringRevers);
                }
            }
        }

        System.out.println(result.toString());
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;
        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :

            second == null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;
        }
    }

}