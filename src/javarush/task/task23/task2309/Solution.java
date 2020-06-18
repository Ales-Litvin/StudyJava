package javarush.task.task23.task2309;

import javarush.task.task23.task2309.vo.*;

import java.util.List;

/*
Анонимность иногда так приятна!
*/

/*
 * 1. В пакете vo создайте public классы User, Location, Server, Subject,
 *  Subscription, которые наследуются от NamedItem
 *
 * 2. В классе Solution для каждого класса создайте свой метод,
 * который возвращает список экземпляров класса.
 *
 * Например, для класса User это будет - public List<User> getUsers()
 * Для класса Location это будет - public List<Location> getLocations()
 *
 * 3. Внутри каждого такого метода создайте анонимный класс от AbstractDbSelectExecutor
 * и вызовите его нужный метод.
 *
 * Подсказка:
 * тело метода должно начинаться так: return new AbstractDbSelectExecutor
 *
 * 4. Пример вывода для User и Location:
 * Id=5, name='User-5', description=Received from executing 'SELECT * FROM USER'
 * Id=1, name='Location-1', description=Received from executing 'SELECT * FROM LOCATION'
 *
 * 5. Проанализируйте пример вывода и сформируйте правильный query для всех классов.
 */

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.getUsers());
        print(solution.getLocations());
    }

    public static void print(List list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            NamedItem item = (NamedItem) obj;
            System.out.println(String.format(format, item.getId(), item.getName(), item.getDescription()));
        }
    }

    public List<User> getUsers(){
        return new AbstractDbSelectExecutor<User>() {
            @Override
            public String getQuery() {
                return String.format("SELECT * FROM %S", User.class.getSimpleName().toUpperCase());
            }
        }.execute();
    }

    public List<Location> getLocations(){
        return new AbstractDbSelectExecutor<Location>(){
            @Override
            public String getQuery() {
                return String.format("SELECT * FROM %S", Location.class.getSimpleName().toUpperCase());
            }
        }.execute();
    }

    public List<Server> getServers(){
        return new AbstractDbSelectExecutor<Server>(){
            @Override
            public String getQuery() {
                return String.format("SELECT * FROM %S", Server.class.getSimpleName().toUpperCase());
            }
        }.execute();
    }

    public List<Subject> getSubjects(){
        return new AbstractDbSelectExecutor<Subject>(){
            @Override
            public String getQuery() {
                return String.format("SELECT * FROM %S", Subject.class.getSimpleName().toUpperCase());
            }
        }.execute();
    }

    public List<Subscription> getSubscriptions(){
        return new AbstractDbSelectExecutor<Subscription>(){
            @Override
            public String getQuery() {
                return String.format("SELECT * FROM %S", Subscription.class.getSimpleName().toUpperCase());
            }
        }.execute();
    }
}