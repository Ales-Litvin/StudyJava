package javarush.task.task21.task2102;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/*
Сравниваем модификаторы
*/

public class Solution {
    public static void main(String[] args) {
        int classModifiers = Solution.class.getModifiers();
        System.out.println(isModifierSet(classModifiers, Modifier.PUBLIC));   //true
        System.out.println(isModifierSet(classModifiers, Modifier.STATIC));   //false

        int methodModifiers = getMainMethod().getModifiers();
        System.out.println(isModifierSet(methodModifiers, Modifier.STATIC));      //true
    }

    public static boolean isModifierSet(int allModifiers, int specificModifier) {
        boolean results;
        if (Modifier.isPublic(specificModifier))
            results = Modifier.isPublic(allModifiers) && Modifier.isPublic(specificModifier);
        else
            results = Modifier.isStatic(allModifiers) && Modifier.isStatic(allModifiers);

        return results;
    }

    private static Method getMainMethod() {
        Method[] methods = Solution.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("learn/main")) return method;
        }

        return null;
    }
}