package javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/*
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        Set<String> set = new HashSet();
        set.add("user");
        set.add("loser");
        set.add("coder");
        set.add("proger");
        //тут цикл по чтению ключей, пункт 1
        while (true) {
            key = reader.readLine();
            if (set.contains(key) && "user".equals(key)) {
                //создаем объект, пункт 2
                person = new Person.User();
                doWork(person); //вызываем doWork
            } else if (set.contains(key) && "loser".equals(key)) {
                //создаем объект, пункт 2
                person = new Person.Loser();
                doWork(person); //вызываем doWork
            } else if (set.contains(key) && "coder".equals(key)) {
                //создаем объект, пункт 2
                person = new Person.Coder();
                doWork(person); //вызываем doWork
            } else if (set.contains(key) && "proger".equals(key)) {
                //создаем объект, пункт 2
                person = new Person.Proger();
                doWork(person); //вызываем doWork
            } else {
                break;
            }
        }
    }

    public static void doWork(Person person) {
        // пункт 3
            if (person instanceof Person.User)
                ((Person.User) person).live();
            else if (person instanceof Person.Loser)
                ((Person.Loser) person).doNothing();
            else if (person instanceof Person.Coder)
                ((Person.Coder) person).writeCode();
            else
                ((Person.Proger) person).enjoy();

    }
}

/*
user
loser
coder
proger
 */