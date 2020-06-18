package javarush.task.task20.task2024;

/*
Знакомство с графами
*/

/*
Прочитать в дополнительных материалах о сериализации графов.
Дан ориентированный плоский граф Solution, содержащий циклы и петли.

Пример, http://edu.nstu.ru/courses/saod/images/graph1.gif

Сериализовать Solution.
Все данные должны сохранить порядок следования.
 */

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Solution implements Serializable {

    int node;
    List<Solution> edges = new LinkedList<>();

    public static void main(String[] args) {

    }
}