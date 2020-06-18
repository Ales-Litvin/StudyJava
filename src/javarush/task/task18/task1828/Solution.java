package javarush.task.task18.task1828;

/*
Прайсы 2
 */

/*
G:\CrUD.txt
 */

/*
1       Помидорчик                    2.56    154
2       Огурчик                       3.34    2000
3       Харбата                       1.25    1000
4       Кава                          4.58    1235
5       Абсент                        5.546   5641
6       Кавачка з малаком             1.35    15

Заменим 3
3       Харбата 15166151651651651     1.25    1000
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameCrUD = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader fileReader = new BufferedReader(new InputStreamReader(
                new FileInputStream(fileNameCrUD)));
        ArrayList<String> list = new ArrayList<String>();
        String string;
        int thisId = 0;
        int numberId = -1;
        while ((string = fileReader.readLine()) != null) {
            list.add(string);
            if ((string.substring(0, 8).trim()).equals(args[1]))
                numberId = thisId;
            else
                thisId++;
        }
        fileReader.close();

        try {
            switch (args[0]) {
                case "-u":
                    String stringCruD = String.format("%-8s%-30s%-8s%-4s", String.valueOf(args[1]), args[2], args[3], args[4]);
                    if (numberId != -1)
                    list.set(numberId, stringCruD);
                    break;
                case "-d":
                    list.remove(numberId);
                    break;
                default:
                    System.out.printf("Начальный параметр \" %s \" не опознан.", args[0]);
                    break;
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(fileNameCrUD)));

            for (int i = 0; i < list.size(); i++){

                if ( i != 0) { bufferedWriter.newLine(); }
                bufferedWriter.write(list.get(i), 0, list.get(i).length());
            }
            bufferedWriter.close();
        }
        catch (Exception e){ System.out.printf("Проверте правильность введенных данны. " +
                "\nОшибка: %s", e.getMessage()); }
    }
}