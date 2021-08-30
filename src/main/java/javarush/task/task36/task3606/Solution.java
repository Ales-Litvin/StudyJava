package javarush.task.task36.task3606;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/*
Осваиваем ClassLoader и Reflection
*/
public class Solution {
    private final List<Class<?>> hiddenClasses = new ArrayList<>();
    private final String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("secondhiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("firsthiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        Path path = Paths.get(packageName);
        MyLoader loader = new MyLoader();

        for (File file : path.toFile().listFiles()){
            if (file.getName().endsWith(".class")){
                    Class<?> clazz = loader.findClass(file.toString());
                    hiddenClasses.add(clazz);
            }
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        for (Class<?> clazz : hiddenClasses){
            if (clazz.getSimpleName().toLowerCase().startsWith(key.toLowerCase())) {
                try {
                    for (Constructor<?> constructor : clazz.getDeclaredConstructors()){
                        if (constructor.getParameterTypes().length == 0){
                            for (Class interfaced : clazz.getInterfaces()){
                                if (interfaced.equals(HiddenClass.class)){
                                    constructor.setAccessible(true);
                                    return (HiddenClass) constructor.newInstance();
                                }
                            }
                        }
                    }
                } catch (InstantiationException |
                        InvocationTargetException |
                        IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
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