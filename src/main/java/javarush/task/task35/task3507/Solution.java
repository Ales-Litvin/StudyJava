package javarush.task.task35.task3507;

import java.util.Set;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.HashSet;

/*
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) throws Exception {

        Path path = Paths.get(pathToAnimals);
        MyLoader loader = new MyLoader();

        Set<Animal> set = new HashSet<>();
        for (File file : path.toFile().listFiles()){
            if (file.getName().endsWith(".class")){
                try {
                    Class<?> clazz = loader.findClass(file.toString());
                    Constructor constructor = clazz.getConstructor();
                    if (constructor.getModifiers() == Modifier.PUBLIC &&
                            Animal.class.isAssignableFrom(clazz) &&
                            constructor.getParameterCount() == 0){
                        constructor.setAccessible(true);
                        set.add((Animal) constructor.newInstance());
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return set;
    }

    public static class MyLoader extends ClassLoader {
        @Override
        public Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                Path path = Paths.get(name);
                byte[] b = Files.readAllBytes(path);
                return defineClass(null, b, 0, b.length);
            } catch (IOException ex) {
                return super.findClass(name);
            }
        }
    }
}