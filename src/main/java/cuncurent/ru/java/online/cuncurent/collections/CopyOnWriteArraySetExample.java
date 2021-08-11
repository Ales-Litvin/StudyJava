package cuncurent.ru.java.online.cuncurent.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * CopyOnWriteArraySet выполнен на основе CopyOnWriteArrayList с реализацией
 * интерфейса Set.
 */
public class CopyOnWriteArraySetExample {
    List<User> list  ;
    CopyOnWriteArraySet<User> cowSet;

    public CopyOnWriteArraySetExample() {
        list = new ArrayList<>();
        list.add(new User("Прохор "));
        list.add(new User("Георгий"));
        list.add(new User("Михаил"));

        cowSet = new CopyOnWriteArraySet<>(list);

        System.out.println("Цикл с измением");

        Iterator<User> itr = cowSet.iterator();
        int cnt = 0;
        while (itr.hasNext()) {
            User user = itr.next();
            System.out.println("  " + user.name);
            if (++cnt == 2) {
                cowSet.add(new User("Павел"));
                user.name = user.name + " Иванович";
            }
        }

        System.out.println("\nЦикл без измения");
        itr = cowSet.iterator();
        while (itr.hasNext()) {
            User user = itr.next();
            System.out.println("  " + user.name);
        }
    }

    static class User {
        private String name;
        public User(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        new CopyOnWriteArraySetExample();
    }
}
