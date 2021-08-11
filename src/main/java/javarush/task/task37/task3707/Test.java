package javarush.task.task37.task3707;

import java.io.*;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Set<Integer> set = new AmigoSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        System.out.println(set);
        System.out.println("Size: " + set.size());

        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("G:\\Programming\\Work\\StudyJava\\src\\javarush\\task\\task37\\task3707\\temp.txt"))){
            out.writeObject(set);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Set<Integer> newSet = new AmigoSet<>();
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("G:\\Programming\\Work\\StudyJava\\src\\javarush\\task\\task37\\task3707\\temp.txt"))){
            newSet = (AmigoSet<Integer>) in.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(newSet);
        System.out.println("Size: " + newSet.size());

        System. out.println("set == newSet ?: " + set.equals(newSet));
    }
}
