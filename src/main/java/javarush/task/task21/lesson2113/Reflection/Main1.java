package javarush.task.task21.lesson2113.Reflection;

/*
Как получить и установить значение поля объекта по имени
 */

import java.lang.reflect.Field;

public class Main1 {
    public static Cat createCat()  {

            Class clazz = null;
            Cat cat = null;
            try {

                /*
                Здесь мы, используя наш объект Class clazz, получаем доступ к полю age
                с помощью метода getDeclaredField(). Он дает нам возможность получить поле
                age в виде объекта Field age.
                 */

                clazz = Class.forName("javarush.task.task21.lesson2113.javarush.task.task21.lesson2113.Reflection.Cat");
                cat = (Cat) clazz.newInstance();

                //с полем name нам повезло - для него в классе есть setter
                cat.setName("Barsik");

                Field age = clazz.getDeclaredField("age");

                /*
                Но этого пока недостаточно, ведь private-полям нельзя просто так присваивать значения.
                Для этого нужно сделать поле «доступным» с помощью метода setAccessible()
                 */

                age.setAccessible(true);

                // Тем полям, для которых это сделано, можно присваивать значения
                age.set(cat, 6);

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }

            return cat;
    }

    public static void main(String[] args) {
            System.out.println(createCat());
    }
}
