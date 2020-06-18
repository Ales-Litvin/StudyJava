package javarush.task.task22.task2207;

/*
Обращенные слова
*/

/*
 * В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
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
import java.util.LinkedList;
import java.util.List;

public class Solution_rev1 {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String data;
        StringBuilder stringSum = new StringBuilder();
        while ((data = br.readLine()) != null){
            stringSum.append(data).append(" ");
        }
        br.close();

        for (String str : new String(stringSum).split(" ")){
            String stringRevers = new String(new StringBuilder(str).reverse());
            if (stringSum.indexOf(stringRevers) >= 0){
                Pair pair = new Pair();
                pair.first = str;
                pair.second = stringRevers;

                if (result.indexOf(pair) < 0) result.add(pair);

                stringSum.delete(stringSum.indexOf(str),
                        stringSum.indexOf(str) + str.length());

                stringSum.delete(stringSum.indexOf(stringRevers),
                        stringSum.indexOf(stringRevers) + stringRevers.length());
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