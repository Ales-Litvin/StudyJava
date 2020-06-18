package javarush.task.task07.task0716;

import java.util.ArrayList;

/*
Р или Л
 */

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("роза");
        strings.add("лоза");
        strings.add("лира");


        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings){
        // напишите тут ваш код
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).contains("л") == true && strings.get(i).contains("р") == true) {
            }
            else if (strings.get(i).contains("л") == true && strings.get(i).contains("р") == false) {
                strings.add(i + 1, strings.get(i)); i++;
            }
            else if (strings.get(i).contains("р") == true && strings.get(i).contains("л") == false) {
                strings.remove(i); i--;
            }
            else {}
        }

        return strings;
    }
}
