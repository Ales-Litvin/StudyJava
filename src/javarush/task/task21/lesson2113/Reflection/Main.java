package javarush.task.task21.lesson2113.Reflection;

/*
Как создать экземпляр класса, если имя класса неизвестно до выполнения программы
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static Cat createCat()  {

        Class clazz = null;
        Cat cat = null;

        try {
            clazz = Class.forName("javarush.task.task21.lesson2113.javarush.task.task21.lesson2113.Reflection.Cat");
            // создали массив объектов Class
            // Они соответствуют параметрам нашего конструктора (у нас там как раз параметры String и int)
            Class[] catClassParams = {String.class, int.class};

            /*
            Мы передаем их в метод clazz.getConstructor() и получаем доступ к нужному конструктору.
            После этого остается только вызвать метод newInstance() с нужными параметрами и не забыть
            явно привести объект к нужному нам классу — Cat
             */
            cat = (Cat) clazz.getConstructor(catClassParams).newInstance("Barsik", 6);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return cat;
    }


    public static Object createObject() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String className = reader.readLine();

        Class clazz = Class.forName(className);
        Object result = clazz.newInstance();

        return result;
    }

    // Как вызвать метод объекта по имени
    public static void invokeSayMeowMethod()  {

        Class clazz = null;
        Cat cat = null;
        try {

            cat = new Cat("Barsik", 6);

            clazz = Class.forName(Cat.class.getName());

            Method sayMeow = clazz.getDeclaredMethod("sayMeow");

            sayMeow.setAccessible(true);

            sayMeow.invoke(cat);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        System.out.println(createCat());
        invokeSayMeowMethod();
    }
}