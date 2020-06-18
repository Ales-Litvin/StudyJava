package javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Отслеживаем изменения
*/

/*
G:\Test.txt
G:\Test1.txt
 */

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = bufferedReader.readLine();
        String file2 = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));
        String stringFile2;
        while ((stringFile2 = bufferedReader2.readLine()) != null){
            lines.add(new LineItem(Type.SAME, stringFile2));
        }
        bufferedReader2.close();

        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file1));
        String stringFile1;
        int count = 0;
        while (count < lines.size()){
            stringFile1 = bufferedReader1.readLine();
            if (stringFile1 != null) {
                if (lines.get(count).line.equals(stringFile1)) {
                }
                else if (!(lines.get(count).line.equals(stringFile1)) &
                        !(lines.get(count + 1).line.equals(stringFile1))) {
                    lines.add(count, new LineItem(Type.REMOVED, stringFile1));
                }
                else if (!(lines.get(count).line.equals(stringFile1)) &
                        (lines.get(count + 1).line.equals(stringFile1))) {
                    lines.set(count, new LineItem(Type.ADDED, lines.get(count).line));
                    count++;
                }
                else {
                    lines.add(new LineItem(Type.REMOVED, stringFile1));
                    count++;
                }
            }
            else {
                lines.set(count, new LineItem(Type.ADDED, lines.get(count).line));
            }
            count++;
        }
        bufferedReader1.close();

        /*for (LineItem l: lines){
            l.toString();
        }

         */




    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            System.out.printf("%s : %s\n", this.type.toString(), this.line);
            return super.toString();
        }
    }
}