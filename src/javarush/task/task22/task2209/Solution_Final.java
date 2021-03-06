package javarush.task.task22.task2209;

/*
Составить цепочку слов
*/

/* В методе learn.main считай с консоли имя файла, который содержит слова, разделенные пробелом.*
 * В методе getLine используя StringBuilder расставь все слова в таком порядке,
 * чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
 *
 *         Каждое слово должно участвовать 1 раз.
 *         Считай, что абсолютно все слова из исходного списка могут (и должны!)
 *          быть включены в результат (лишних слов нет).
 *         Метод getLine должен возвращать любой правильный вариант
 *          при наличии нескольких таковых (см. пример).
 *         Слова разделять пробелом.
 *         Вывести полученную строку на экран.
 *
 *         Пример тела входного файла:
 *         Киев Нью-Йорк Амстердам Вена Мельбурн
 *
 *         Результат:
 *         Амстердам Мельбурн Нью-Йорк Киев Вена
 *         или
 *         Вена Амстердам Мельбурн Нью-Йорк К
 * иев
 *         или
 *         Мельбурн Нью-Йорк Киев Вена Амстердам
 *         и т.п.
 */

/*
 * Задача решена в "ЛОБ"
 */
/*
G:\Programming\Work\Hlam\src\javarush\task\task22\task2209\test.txt
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_Final {
    public static void main(String[] args) throws IOException {
        //...
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

        String[] array = new String[list.size()];
        array = list.toArray(array);

        StringBuilder result = getLine(array);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words == null || words.length == 0) return new StringBuilder("");
        List<StringBuilder> listResult = new ArrayList<>();

        for (String st : words) {
            List<String> listArray = new ArrayList<>(Arrays.asList(words));
            StringBuilder stringBuilder = new StringBuilder(st);
            listArray.remove(st);

            boolean haveString = true;

            while (haveString) {
                char lastChar = stringBuilder.toString().charAt(stringBuilder.toString().length() - 1);
                char firstChar = stringBuilder.toString().charAt(0);
                String regexOfLast = String.format("%S{1}.+", lastChar);
                String regexOfFirs = String.format(".+%S{1}", firstChar);

                int control = listArray.size();

                for (String str : words) {
                    if (listArray.contains(str) && str.toUpperCase().matches(regexOfLast)) {
                        stringBuilder = stringBuilder.append(" " + str);
                        listArray.remove(str);
                        break;
                    }
                    if (listArray.contains(str) && str.toUpperCase().matches(regexOfFirs)) {
                        stringBuilder = new StringBuilder(str + " ").append(stringBuilder);
                        listArray.remove(str);
                        break;
                    }
                }
                if (listArray.size() == 0) {
                    haveString = false;
                    listResult.add(stringBuilder);
                }
                if (control == listArray.size()) {
                    haveString = false;
                    listResult.add(stringBuilder);
                }

            }
        }

        int maxStringBuilder = listResult.get(0).toString().length();
        StringBuilder stringBuilder = listResult.get(0);
        for (StringBuilder builder : listResult){
            if (builder.toString().length() > maxStringBuilder) {
                maxStringBuilder = builder.toString().length();
                stringBuilder = builder;
            }
        }

        return stringBuilder;
    }
}