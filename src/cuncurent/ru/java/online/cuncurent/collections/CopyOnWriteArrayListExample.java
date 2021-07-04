package cuncurent.ru.java.online.cuncurent.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList реализует алгоритм CopyOnWrite и является
 * потокобезопасным аналогом ArrayList.
 * Класс CopyOnWriteArrayList содержит изменяемую ссылку на неизменяемый массив,
 * обеспечивая преимущества потокобезопасности без необходимости использования
 * блокировок. Т.е. при выполнении модифицирующей операции CopyOnWriteArrayList
 * создаёт новую копию списка и гарантирует, что её итераторы вернут состояние
 * списка на момент создания итератора и не вызовут ConcurrentModificationException.
 *
 */
public class CopyOnWriteArrayListExample {
    List<String> list;

    public CopyOnWriteArrayListExample(){
        List<String> lst = new ArrayList<>();
        lst.add("Java");
        lst.add("J2EE");
        lst.add("J2SE");
        lst.add("Collection");
        lst.add("Concurrent");

        list = new CopyOnWriteArrayList<>(lst);

        System.out.println("Loop with changes");
        printCollection(true);
        System.out.println("\nLoop without changes");
        printCollection(false);
    }

    public static void main(String[] args) {
        new CopyOnWriteArrayListExample();
        System.exit(0);
    }

    private void printCollection(boolean change){
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.printf(" %s %n", next);
            if (change) {
                if (next.equals("Collection")){
                    list.add("New string");
                    list.remove(next);
                }
            }
        }
    }
}
