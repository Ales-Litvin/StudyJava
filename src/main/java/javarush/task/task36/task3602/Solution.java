package javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Найти класс по описанию Ӏ Java Collections: 6 уровень, 6 лекция
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class<?>[] classes = Collections.class.getDeclaredClasses();

        for (Class clazz : classes){
            if (isImplList(clazz) &&
                    Modifier.isStatic(clazz.getModifiers()) &&
                    Modifier.isPrivate(clazz.getModifiers())){
                try {
                    Method method = clazz.getDeclaredMethod("get", int.class);
                    method.setAccessible(true);
                    Constructor constructor = clazz.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    method.invoke(constructor.newInstance(), 2);
                } catch (NoSuchMethodException | InstantiationException | IllegalAccessException e){
                    // do nothing
                } catch (InvocationTargetException e){
                    if (e.getCause().toString(). contains("IndexOutOfBoundsException")){
                        return clazz;
                    }
                }
            }
        }

        return null;
    }

    private static boolean isImplList(Class<?> clazz){
        List<Class<?>> list1 = Arrays.asList(clazz.getInterfaces());
        List<Class<?>> list2 = Arrays.asList(clazz.getSuperclass().getInterfaces());
        return list1.contains(List.class) || list2.contains(List.class);
    }
}