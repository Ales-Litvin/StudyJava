package javarush.task.task24.task2410;

/*
 *  Сделайте так, чтобы метод getIterator возращал анонимный класс.
 *  Перенисите логику LocalIterator в анонимный класс.
 *  Меняйте только тело метода getIterator
 */

import java.util.LinkedList;
import java.util.List;



/*
Рефакторинг, анонимные классы
*/
public class Solution {
    public static List<Iterator> iterators = new LinkedList<>();

    private int countItems;

    public Iterator getIterator(final String name) {

        /*
        class LocalIterator implements Iterator {
            public LocalIterator() {
                countItems++;
                System.out.println(name + " item " + countItems);
            }

            public Iterator next() {
                return new LocalIterator();
            }
        }

         */
        Iterator iterator = new Iterator(){
            {
                countItems++;
                System.out.println(name + " item " + countItems);
            }


            @Override
            public Iterator next() {

                return new Iterator() {
                    {
                        countItems++;
                        System.out.println(name + " item " + countItems);
                    }
                    @Override
                    public Iterator next() {
                        return null;
                    }
                };
            }
        };

        return iterator;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Iterator iterator = solution.getIterator("iterator");
        for (int i = 1; i < 5; i++) {
            iterators.add(iterator.next());
        }
    }
}