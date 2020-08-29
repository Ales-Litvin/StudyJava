package javarush.task.task36.task3605;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

/*
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        Set<Character> set = new TreeSet<Character>();

        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
            String data = "";
            while ((data = reader.readLine()) != null){
                for (char c : data.toCharArray()){
                    if (Character.isAlphabetic(c)) set.add(Character.toLowerCase(c));
                }
            }
        } catch (IOException e) {
            // do nothing
        }

        int count = Math.min(set.size(), 5);

        Iterator<Character> iterator = set.iterator();

        for (int i = 0; i < count; i++){
            System.out.print(iterator.next());
        }
    }
}