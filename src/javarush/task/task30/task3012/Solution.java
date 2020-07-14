package javarush.task.task30.task3012;

/*
 * Реализуй метод createExpression(int number).
 * Метод createExpression вызывается с одним параметром number.
 * Этот параметр - число от 1 до 3000 включительно.
 *
 * Нужно вывести арифметическое выражение, результатом которого является число number.
 * Можно использовать числа: 1, 3, 9, 27, 81, 243, 729, 2187 не более, чем по одному разу.
 * Можно использовать знаки: "+" и "-" любое количество раз.
 *
 * Обрати внимание,
 * что перед каждым числом в искомой строке обязательно должен быть знак плюс или минус.
 * Перед выражением выведи [переданное число] =. (Смотри примеры вывода ниже).
 *
 * Пример1:
 * Переданное число:
 * 74
 * Ожидаемый вывод:
 * 74 = - 1 + 3 - 9 + 81
 *
 * Пример2:
 * Переданное число:
 * 1234
 * Ожидаемый вывод:
 * 1234 = + 1 - 9 + 27 - 243 - 729 + 2187
 *
 * При выводе выражения используй числа ТОЛЬКО В ВОЗРАСТАЮЩЕМ порядке!
 * Переданное число:
 * 2
 * Ожидаемый вывод:
 * 2 = - 1 + 3 //правильно
 * Ожидаемый вывод:
 * 2 = + 3 - 1 //НЕ правильно
 * Метод main не участвует в тестировании.
 *
 * Подсказка:
 * Почитай в интернете про троичную симметричную систему счисления.
 */

import java.util.ArrayList;
import java.util.List;

/*
Получи заданное число
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
        solution.createExpression(2);
        solution.createExpression(100);
        solution.createExpression(6);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        // это ряд степеней числа 3 (* единицу можно рассматривать как нулевую степень)
        int[] array = new int[]{ 1, 3, 9, 27, 81, 243, 729, 2187 };
        int result = number;
        // переводим число number в троичную уравновешенную систему
        List<Integer> list = new ArrayList<>();
        while (number != 0) {
            int balanceOfDivision = number % 3;
            number = number / 3;
                if (balanceOfDivision == 2){
                    list.add(-1);
                    number += 1;
                }
                else {
                    list.add(balanceOfDivision);
                }
        }
        //Collections.reverse(list);
        System.out.printf("%d = ", result);
        for (int i = 0; i < list.size(); i ++){
            if (list.get(i) == 1){
                System.out.printf("+ %d ", array[i]);
            }
            if (list.get(i) == -1){
                System.out.printf("- %d ", array[i]);
            }
        }
        System.out.print("\n");
    }
}