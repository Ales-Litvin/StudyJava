package javarush.task.task13.task1326;

/*
Сортировка четных чисел из файла
 */

// Тестовый файл здесь: G:\Test.txt
// new String(byte[], Charset)

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        InputStream inStream = new FileInputStream(fileName);

        ArrayList<Integer> list = new ArrayList<>();

        while (inStream.available() > 0){
            int data = inStream.read();
            list.add((int) data);
        }
        inStream.close();

        listRemove_1310(list, 13);
        byte[] bytes = Solution.listToArray(list);
        // Создает новую строку, декодируя указанный массив байтов,
        // используя кодировку платформы по умолчанию.
        String stringNumber = new String(bytes);
        ArrayList<Integer> listNumber = stringToArrayList(stringNumber);
        evenSortArrayList(listNumber);
        printArrayList(listNumber);

    }

    // удаляет из ArrayList 13, 10
    public static void listRemove_1310(ArrayList<Integer> list, int number) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == number)
                list.remove(i);
        }
    }

    // возвращает массив byte[] из ArrayList
    public static byte[] listToArray(ArrayList<Integer> list) {
        byte[] bytes = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            int j = list.get(i);
            bytes[i] = (byte) j;
        }
        return bytes;
    }

    // помещает числа из String в ArrayList<Integer>
    public static ArrayList<Integer> stringToArrayList(String string){
        ArrayList<Integer> arrayList = new ArrayList<>();
        String text = "";
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != '\n' && i != string.length() - 1){
                text = text + string.charAt(i);
            }
            else if (i == string.length() - 1){
                text = text + string.charAt(i);
                arrayList.add(Integer.parseInt(text));
            }
            else {
                arrayList.add(Integer.parseInt(text));
                text = "";
            }
        }
        return arrayList;
    }

    // возращает ArrayList отсортированных четных чисел
    public static void evenSortArrayList(ArrayList<Integer> arrayList){
        for (int i = 0; i < arrayList.size(); i++){
            if (arrayList.get(i)%2 != 0)
                arrayList.remove(i);
        }
        for (int i = 0; i < arrayList.size(); i++){
            if (arrayList.get(i)%2 != 0)
                arrayList.remove(i);
        }
        Collections.sort(arrayList);
    }

    // Вывод на консоль ArrayList
    public static void printArrayList(ArrayList<Integer> arrayList){
        for (int i: arrayList){
            System.out.println(i);
        }
    }
}
