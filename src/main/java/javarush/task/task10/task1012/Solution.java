package javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
                'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
                'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }
        int[] number_letters = new int[33];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length(); j++) {
                Character charAt = list.get(i).charAt(j);
                if (alphabet.indexOf(charAt) >= 0){
                number_letters[alphabet.indexOf(charAt)] = number_letters[alphabet.indexOf(charAt)] + 1;
                }
            }
        }
        for (int i = 0; i < alphabet.size(); i++){
            System.out.println(alphabet.get(i) + " " + number_letters[i]);
        }

    }
}

/*
    Машина
    Перерыв
    Скакун
    Телефон
    Игра
    Пророк
    Яблоко
    Платок
    дерево
    усус
 */